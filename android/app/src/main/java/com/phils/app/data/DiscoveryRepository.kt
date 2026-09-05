package com.phils.app.data

import com.phils.app.model.Discovery
import com.phils.app.model.SeedData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map

class DiscoveryRepository(private val prefs: PreferencesManager) {

    val discoveriesWithSavedFlow: Flow<List<Discovery>> = prefs.savedIdsFlow.combine(prefs.historyFlow) { savedIds, _ ->
        SeedData.discoveries.map { d ->
            d.copy(saved = savedIds.contains(d.id))
        }
    }

    val savedDiscoveriesFlow: Flow<List<Discovery>> = prefs.savedIdsFlow.map { savedIds ->
        SeedData.discoveries.filter { savedIds.contains(it.id) }.map { it.copy(saved = true) }
    }

    val historyDiscoveriesFlow: Flow<List<Discovery>> = prefs.historyFlow.map { historyIds ->
        historyIds.mapNotNull { SeedData.discoveryMap[it] }.reversed()
    }

    suspend fun toggleSave(id: String): Boolean {
        return prefs.toggleSave(id)
    }

    suspend fun recordDiscovery(id: String) {
        prefs.recordDiscovered(id)
    }

    fun getDiscoveryById(id: String): Discovery? {
        return SeedData.discoveryMap[id]
    }
}
