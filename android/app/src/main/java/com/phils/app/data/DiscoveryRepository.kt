package com.phils.app.data

import android.content.Context
import android.util.Log
import com.phils.app.data.api.NetworkClient
import com.phils.app.data.api.toDomain
import com.phils.app.model.Discovery
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Types
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DiscoveryRepository(
    private val prefs: PreferencesManager,
    private val context: Context? = null,
    private val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)
) {
    companion object {
        private const val TAG = "DiscoveryRepository"
    }

    private val listType = Types.newParameterizedType(List::class.java, Discovery::class.java)
    private val moshiAdapter: JsonAdapter<List<Discovery>> by lazy {
        NetworkClient.moshi.adapter(listType)
    }

    // In-memory list of discoveries dynamically fetched and locally cached from DataStore
    private val _dynamicDiscoveries = MutableStateFlow<List<Discovery>>(emptyList())
    val dynamicDiscoveries: StateFlow<List<Discovery>> = _dynamicDiscoveries.asStateFlow()

    private val _isFetching = MutableStateFlow(false)
    val isFetching: StateFlow<Boolean> = _isFetching.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    private val _isCacheLoaded = MutableStateFlow(false)
    val isCacheLoaded: StateFlow<Boolean> = _isCacheLoaded.asStateFlow()

    init {
        // Load existing dynamic cache from DataStore on launch
        scope.launch {
            try {
                val json = prefs.dynamicDiscoveriesJsonFlow.first()
                if (json.isNotBlank()) {
                    val cached = moshiAdapter.fromJson(json)
                    if (!cached.isNullOrEmpty()) {
                        _dynamicDiscoveries.value = cached
                        Log.d(TAG, "Loaded ${cached.size} cached discoveries from local DataStore")
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "Failed to load cached discoveries", e)
            } finally {
                // Ensure all bundled curated discoveries are present in the deck
                val defaults = DefaultDiscoveries.load(context)
                if (_dynamicDiscoveries.value.isEmpty()) {
                    if (defaults.isNotEmpty()) {
                        _dynamicDiscoveries.value = defaults
                        Log.d(TAG, "Seeded ${_dynamicDiscoveries.value.size} bundled discoveries from assets")
                    }
                } else if (defaults.isNotEmpty() && _dynamicDiscoveries.value.size < defaults.size) {
                    val existingIds = _dynamicDiscoveries.value.map { it.id }.toSet()
                    val missing = defaults.filter { !existingIds.contains(it.id) }
                    if (missing.isNotEmpty()) {
                        _dynamicDiscoveries.value = _dynamicDiscoveries.value + missing
                        Log.d(TAG, "Merged ${missing.size} missing bundled discoveries into deck (total: ${_dynamicDiscoveries.value.size})")
                    }
                }
                _isCacheLoaded.value = true
                // Fetch latest feed from API (limit=50 to fetch entire curated corpus)
                fetchMoreFeed(limit = 50)
            }
        }
    }

    /**
     * Combined flow of all discoveries with reactive saved status applied.
     */
    val discoveriesWithSavedFlow: Flow<List<Discovery>> = combine(
        _dynamicDiscoveries,
        prefs.savedIdsFlow
    ) { dynamicList, savedIds ->
        dynamicList.map { d ->
            d.copy(saved = savedIds.contains(d.id))
        }
    }

    val savedDiscoveriesFlow: Flow<List<Discovery>> = combine(
        _dynamicDiscoveries,
        prefs.savedIdsFlow
    ) { dynamicList, savedIds ->
        dynamicList.filter { savedIds.contains(it.id) }.map { it.copy(saved = true) }
    }

    val historyDiscoveriesFlow: Flow<List<Discovery>> = combine(
        _dynamicDiscoveries,
        prefs.historyFlow
    ) { dynamicList, historyIds ->
        val allMap = dynamicList.associateBy { it.id }
        historyIds.mapNotNull { allMap[it] }.reversed()
    }

    suspend fun toggleSave(id: String): Boolean {
        return prefs.toggleSave(id)
    }

    suspend fun recordDiscovery(id: String) {
        prefs.recordDiscovered(id)
    }

    fun getDiscoveryById(id: String): Discovery? {
        return _dynamicDiscoveries.value.find { it.id == id }
    }

    fun search(query: String): List<Discovery> {
        if (query.isBlank()) return emptyList()
        val all = _dynamicDiscoveries.value
        val q = query.lowercase().trim()
        return all.filter { d ->
            d.title.lowercase().contains(q) ||
            d.hook.lowercase().contains(q) ||
            d.short.lowercase().contains(q) ||
            d.tags.any { it.lowercase().contains(q) } ||
            d.detail.whatIsThis.lowercase().contains(q) ||
            d.detail.keyPeople.any { it.name.lowercase().contains(q) } ||
            d.detail.corePrinciplesRich.any { it.name.lowercase().contains(q) } ||
            d.detail.keyThinkersRich.any { it.name.lowercase().contains(q) }
        }
    }

    fun retry() {
        scope.launch {
            fetchMoreFeed(limit = 50)
        }
    }

    /**
     * Attempts to fetch more discoveries from server API.
     * Appends unique incoming discoveries and updates local DataStore cache.
     */
    suspend fun fetchMoreFeed(limit: Int = 50): Int = withContext(Dispatchers.IO) {
        if (_isFetching.value) return@withContext 0
        _isFetching.value = true
        try {
            val cursor = _dynamicDiscoveries.value.lastOrNull()?.id
            Log.d(TAG, "Fetching discoveries from Phils API (limit=$limit, cursor=$cursor)...")
            val response = NetworkClient.api.getFeed(limit = limit, cursor = cursor)
            if (response.success && response.data != null) {
                val incoming = response.data.discoveries.map { it.toDomain() }
                if (incoming.isNotEmpty()) {
                    val currentIds = _dynamicDiscoveries.value.map { it.id }.toSet()
                    val currentTitles = _dynamicDiscoveries.value.map { it.title.lowercase() }.toSet()

                    val newUnique = incoming.filter {
                        !currentIds.contains(it.id) && !currentTitles.contains(it.title.lowercase())
                    }

                    if (newUnique.isNotEmpty()) {
                        val updated = _dynamicDiscoveries.value + newUnique
                        _dynamicDiscoveries.value = updated

                        // Persist to local dynamic cache
                        try {
                            val json = moshiAdapter.toJson(updated)
                            prefs.saveDynamicDiscoveriesJson(json)
                            Log.d(TAG, "Persisted ${updated.size} discoveries to DataStore cache")
                        } catch (e: Exception) {
                            Log.e(TAG, "Failed to persist dynamic cache to DataStore", e)
                        }
                    }
                }
                _errorMessage.value = null
                return@withContext incoming.size
            } else {
                if (_dynamicDiscoveries.value.isEmpty()) {
                    _errorMessage.value = "Failed to load feed from Phils server."
                }
                0
            }
        } catch (t: Throwable) {
            Log.e(TAG, "Network feed unavailable: ${t.message}")
            if (_dynamicDiscoveries.value.isEmpty()) {
                _errorMessage.value = "Unable to connect to Phils server. Check your connection or server status."
            }
            0
        } finally {
            _isFetching.value = false
        }
    }
}
