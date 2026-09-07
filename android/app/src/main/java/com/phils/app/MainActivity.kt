package com.phils.app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import com.phils.app.data.DiscoveryRepository
import com.phils.app.data.PreferencesManager
import com.phils.app.theme.PhilsAppTheme
import com.phils.app.ui.MainScreen
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val deepLinkedDiscoveryId = mutableStateOf<String?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        deepLinkedDiscoveryId.value = extractDiscoveryId(intent)

        val prefs = PreferencesManager(applicationContext)
        val repository = DiscoveryRepository(prefs)

        setContent {
            val systemDark = isSystemInDarkTheme()
            val userDarkPref by prefs.isDarkThemeFlow.collectAsState(initial = null)
            val isDark = userDarkPref ?: systemDark
            val coroutineScope = rememberCoroutineScope()
            val deepLinkId by deepLinkedDiscoveryId

            PhilsAppTheme(darkTheme = isDark) {
                MainScreen(
                    repository = repository,
                    isDarkTheme = isDark,
                    deepLinkDiscoveryId = deepLinkId,
                    onClearDeepLink = { deepLinkedDiscoveryId.value = null },
                    onToggleTheme = { newDark ->
                        coroutineScope.launch {
                            prefs.setDarkTheme(newDark)
                        }
                    }
                )
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        val id = extractDiscoveryId(intent)
        if (id != null) {
            deepLinkedDiscoveryId.value = id
        }
    }

    private fun extractDiscoveryId(intent: Intent?): String? {
        val uri = intent?.data ?: return null
        return when {
            uri.scheme == "phils" && uri.host == "discovery" -> {
                uri.pathSegments?.firstOrNull() ?: uri.lastPathSegment
            }
            uri.pathSegments.contains("d") -> {
                val idx = uri.pathSegments.indexOf("d")
                if (idx != -1 && idx + 1 < uri.pathSegments.size) uri.pathSegments[idx + 1] else null
            }
            uri.pathSegments.contains("discovery") -> {
                val idx = uri.pathSegments.indexOf("discovery")
                if (idx != -1 && idx + 1 < uri.pathSegments.size) uri.pathSegments[idx + 1] else null
            }
            else -> uri.lastPathSegment
        }
    }
}
