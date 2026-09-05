package com.phils.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.phils.app.data.DiscoveryRepository
import com.phils.app.data.PreferencesManager
import com.phils.app.theme.PhilsAppTheme
import com.phils.app.ui.MainScreen
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val prefs = PreferencesManager(applicationContext)
        val repository = DiscoveryRepository(prefs)

        setContent {
            val systemDark = isSystemInDarkTheme()
            val userDarkPref by prefs.isDarkThemeFlow.collectAsState(initial = null)
            val isDark = userDarkPref ?: systemDark
            val coroutineScope = rememberCoroutineScope()

            PhilsAppTheme(darkTheme = isDark) {
                MainScreen(
                    repository = repository,
                    isDarkTheme = isDark,
                    onToggleTheme = { newDark ->
                        coroutineScope.launch {
                            prefs.setDarkTheme(newDark)
                        }
                    }
                )
            }
        }
    }
}
