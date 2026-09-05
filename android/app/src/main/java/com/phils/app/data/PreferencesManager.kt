package com.phils.app.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "phils_prefs")

class PreferencesManager(private val context: Context) {
    companion object {
        val KEY_SAVED_IDS = stringSetPreferencesKey("saved_ids")
        val KEY_HISTORY = stringPreferencesKey("history_csv")
        val KEY_DARK_THEME = booleanPreferencesKey("is_dark_theme")
    }

    val savedIdsFlow: Flow<Set<String>> = context.dataStore.data.map { prefs ->
        prefs[KEY_SAVED_IDS] ?: emptySet()
    }

    val historyFlow: Flow<List<String>> = context.dataStore.data.map { prefs ->
        val raw = prefs[KEY_HISTORY] ?: ""
        if (raw.isEmpty()) emptyList() else raw.split(",").filter { it.isNotEmpty() }
    }

    val isDarkThemeFlow: Flow<Boolean?> = context.dataStore.data.map { prefs ->
        prefs[KEY_DARK_THEME]
    }

    suspend fun toggleSave(id: String): Boolean {
        var isSaved = false
        context.dataStore.edit { prefs ->
            val current = prefs[KEY_SAVED_IDS]?.toMutableSet() ?: mutableSetOf()
            if (current.contains(id)) {
                current.remove(id)
                isSaved = false
            } else {
                current.add(id)
                isSaved = true
            }
            prefs[KEY_SAVED_IDS] = current
        }
        return isSaved
    }

    suspend fun recordDiscovered(id: String) {
        context.dataStore.edit { prefs ->
            val raw = prefs[KEY_HISTORY] ?: ""
            val list = if (raw.isEmpty()) mutableListOf() else raw.split(",").filter { it.isNotEmpty() }.toMutableList()
            list.remove(id)
            list.add(id)
            // keep up to last 100
            val trimmed = if (list.size > 100) list.subList(list.size - 100, list.size) else list
            prefs[KEY_HISTORY] = trimmed.joinToString(",")
        }
    }

    suspend fun setDarkTheme(isDark: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[KEY_DARK_THEME] = isDark
        }
    }
}
