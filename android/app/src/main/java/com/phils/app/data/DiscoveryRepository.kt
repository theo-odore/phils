package com.phils.app.data

import android.util.Log
import com.phils.app.data.api.NetworkClient
import com.phils.app.data.api.toDomain
import com.phils.app.model.Discovery
import com.phils.app.model.SeedData
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
    private val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)
) {
    companion object {
        private const val TAG = "DiscoveryRepository"
    }

    private val listType = Types.newParameterizedType(List::class.java, Discovery::class.java)
    private val moshiAdapter: JsonAdapter<List<Discovery>> by lazy {
        NetworkClient.moshi.adapter(listType)
    }

    // Shuffled once per app launch so every session starts with a fresh random theory
    private val initialDeck: List<Discovery> = SeedData.discoveries.shuffled()

    // In-memory list of dynamically fetched and locally cached discoveries
    private val _dynamicDiscoveries = MutableStateFlow<List<Discovery>>(emptyList())
    val dynamicDiscoveries: StateFlow<List<Discovery>> = _dynamicDiscoveries.asStateFlow()

    private val _isFetching = MutableStateFlow(false)
    val isFetching: StateFlow<Boolean> = _isFetching.asStateFlow()

    init {
        // Load existing dynamic cache from DataStore on launch
        scope.launch {
            try {
                val json = prefs.dynamicDiscoveriesJsonFlow.first()
                if (json.isNotBlank()) {
                    val cached = moshiAdapter.fromJson(json)
                    if (!cached.isNullOrEmpty()) {
                        _dynamicDiscoveries.value = cached
                        Log.d(TAG, "Loaded ${cached.size} cached dynamic discoveries from local storage")
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "Failed to load cached dynamic discoveries", e)
            }
        }
    }

    /**
     * Combined flow of all discoveries (Shuffled built-in theories + all dynamically cached theories),
     * with reactive saved status applied.
     */
    val discoveriesWithSavedFlow: Flow<List<Discovery>> = combine(
        _dynamicDiscoveries,
        prefs.savedIdsFlow
    ) { dynamicList, savedIds ->
        val combined = (initialDeck + dynamicList).distinctBy { it.id }
        combined.map { d ->
            d.copy(saved = savedIds.contains(d.id))
        }
    }

    val savedDiscoveriesFlow: Flow<List<Discovery>> = combine(
        _dynamicDiscoveries,
        prefs.savedIdsFlow
    ) { dynamicList, savedIds ->
        val all = (initialDeck + dynamicList).distinctBy { it.id }
        all.filter { savedIds.contains(it.id) }.map { it.copy(saved = true) }
    }

    val historyDiscoveriesFlow: Flow<List<Discovery>> = combine(
        _dynamicDiscoveries,
        prefs.historyFlow
    ) { dynamicList, historyIds ->
        val allMap = (initialDeck + dynamicList).associateBy { it.id }
        historyIds.mapNotNull { allMap[it] }.reversed()
    }

    suspend fun toggleSave(id: String): Boolean {
        return prefs.toggleSave(id)
    }

    suspend fun recordDiscovery(id: String) {
        prefs.recordDiscovered(id)
    }

    fun getDiscoveryById(id: String): Discovery? {
        val dynamicMatch = _dynamicDiscoveries.value.find { it.id == id }
        return dynamicMatch ?: SeedData.discoveryMap[id]
    }

    fun search(query: String): List<Discovery> {
        if (query.isBlank()) return emptyList()
        val all = (initialDeck + _dynamicDiscoveries.value).distinctBy { it.id }
        val q = query.lowercase().trim()
        return all.filter { d ->
            d.title.lowercase().contains(q) ||
            d.hook.lowercase().contains(q) ||
            d.short.lowercase().contains(q) ||
            d.tags.any { it.lowercase().contains(q) } ||
            d.detail.whatIsThis.lowercase().contains(q) ||
            d.detail.keyPeople.any { it.name.lowercase().contains(q) }
        }
    }

    /**
     * Attempts to fetch more discoveries from server (backed by NVIDIA NIM).
     * If online: appends new discoveries and updates the Ever-Growing Local Cache in DataStore.
     * If offline / server unreachable: fails gracefully without interruption or error.
     */
    suspend fun fetchMoreFeed(limit: Int = 10): Int = withContext(Dispatchers.IO) {
        if (_isFetching.value) return@withContext 0
        _isFetching.value = true
        try {
            Log.d(TAG, "Fetching more discoveries from Phils API (limit=$limit)...")
            val response = NetworkClient.api.getFeed(limit = limit)
            if (response.success && response.data != null) {
                val incoming = response.data.discoveries.map { it.toDomain() }
                if (incoming.isNotEmpty()) {
                    val currentIds = (initialDeck.map { it.id } + _dynamicDiscoveries.value.map { it.id }).toSet()
                    val currentTitles = (initialDeck.map { it.title.lowercase() } + _dynamicDiscoveries.value.map { it.title.lowercase() }).toSet()
                    
                    val newUnique = incoming.filter { 
                        !currentIds.contains(it.id) && !currentTitles.contains(it.title.lowercase()) 
                    }

                    if (newUnique.isNotEmpty()) {
                        val updated = _dynamicDiscoveries.value + newUnique
                        _dynamicDiscoveries.value = updated
                        
                        // Persist to Ever-Growing Local Cache
                        try {
                            val json = moshiAdapter.toJson(updated)
                            prefs.saveDynamicDiscoveriesJson(json)
                            Log.d(TAG, "Persisted ${updated.size} dynamic discoveries to Ever-Growing Local Cache")
                        } catch (e: Exception) {
                            Log.e(TAG, "Failed to persist dynamic cache to DataStore", e)
                        }
                        return@withContext newUnique.size
                    }
                }
            }
            0
        } catch (t: Throwable) {
            Log.i(TAG, "Network feed unavailable (offline or server not started): ${t.message}")
            0
        } finally {
            _isFetching.value = false
        }
    }
}
