package com.phils.app.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phils.app.data.DiscoveryRepository
import com.phils.app.model.Discovery
import com.phils.app.model.SeedData
import com.phils.app.theme.PhilsTheme
import com.phils.app.ui.components.BottomBar
import com.phils.app.ui.components.NavTab
import com.phils.app.ui.detail.DetailScreen
import com.phils.app.ui.feed.DiscoverScreen
import com.phils.app.ui.journey.JourneyScreen
import com.phils.app.ui.saved.SavedScreen
import com.phils.app.ui.search.SearchScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    repository: DiscoveryRepository,
    isDarkTheme: Boolean,
    onToggleTheme: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    deepLinkDiscoveryId: String? = null,
    onClearDeepLink: () -> Unit = {}
) {
    val theme = PhilsTheme.colors
    val coroutineScope = rememberCoroutineScope()

    var currentTab by remember { mutableStateOf(NavTab.DISCOVER) }
    val detailStack = remember { mutableStateListOf<String>() }
    var currentDiscoverIndex by rememberSaveable { mutableIntStateOf(0) }

    // Handle deep link opened card
    LaunchedEffect(deepLinkDiscoveryId) {
        if (!deepLinkDiscoveryId.isNullOrBlank()) {
            if (!detailStack.contains(deepLinkDiscoveryId)) {
                repository.recordDiscovery(deepLinkDiscoveryId)
                detailStack.add(deepLinkDiscoveryId)
            }
            onClearDeepLink()
        }
    }

    val allDiscoveries by repository.discoveriesWithSavedFlow.collectAsState(initial = SeedData.discoveries)
    val savedDiscoveries by repository.savedDiscoveriesFlow.collectAsState(initial = emptyList())
    val historyDiscoveries by repository.historyDiscoveriesFlow.collectAsState(initial = emptyList())

    // Toast message state
    var toastMessage by remember { mutableStateOf<String?>(null) }
    val showToast: (String) -> Unit = { msg ->
        toastMessage = msg
    }

    LaunchedEffect(toastMessage) {
        if (toastMessage != null) {
            delay(2200)
            toastMessage = null
        }
    }

    val handleToggleSave: (Discovery) -> Unit = { discovery ->
        coroutineScope.launch {
            val isNowSaved = repository.toggleSave(discovery.id)
            showToast(if (isNowSaved) "Saved to your shelf" else "Removed from shelf")
        }
    }

    val handleToggleSaveById: (String) -> Unit = { id ->
        coroutineScope.launch {
            val isNowSaved = repository.toggleSave(id)
            showToast(if (isNowSaved) "Saved to your shelf" else "Removed from shelf")
        }
    }

    val handleOpenDiscovery: (String) -> Unit = { id ->
        coroutineScope.launch {
            repository.recordDiscovery(id)
        }
        detailStack.add(id)
    }

    // Hardware / Gesture back handler
    BackHandler(enabled = detailStack.isNotEmpty()) {
        detailStack.removeAt(detailStack.lastIndex)
    }

    // Background prefetch from server on launch if connected
    LaunchedEffect(Unit) {
        repository.fetchMoreFeed(limit = 6)
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(theme.bg)
    ) {
        // Main Tab Content
        when (currentTab) {
            NavTab.DISCOVER -> {
                DiscoverScreen(
                    discoveries = allDiscoveries,
                    currentIndex = currentDiscoverIndex,
                    onIndexChange = { newIndex -> currentDiscoverIndex = newIndex },
                    onExplore = { disc -> handleOpenDiscovery(disc.id) },
                    onToggleSave = handleToggleSave,
                    onLoadMore = {
                        coroutineScope.launch {
                            repository.fetchMoreFeed(limit = 10)
                        }
                    }
                )
            }
            NavTab.SEARCH -> {
                SearchScreen(
                    onOpenDiscovery = handleOpenDiscovery,
                    onToggleSave = handleToggleSaveById,
                    onSearch = { query -> repository.search(query) }
                )
            }
            NavTab.SAVED -> {
                SavedScreen(
                    savedDiscoveries = savedDiscoveries,
                    onOpenDiscovery = handleOpenDiscovery,
                    onToggleSave = handleToggleSaveById
                )
            }
            NavTab.YOU -> {
                JourneyScreen(
                    discoveredList = historyDiscoveries,
                    savedCount = savedDiscoveries.size,
                    isDarkTheme = isDarkTheme,
                    onToggleTheme = onToggleTheme,
                    onOpenDiscovery = handleOpenDiscovery
                )
            }
        }

        // Floating Bottom Navigation Bar (Hidden when inside Detail screen)
        if (detailStack.isEmpty()) {
            BottomBar(
                currentTab = currentTab,
                onTabSelected = { currentTab = it },
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }

        // Active Detail Screen Overlay (from the top of the stack)
        detailStack.lastOrNull()?.let { topId ->
            val disc = repository.getDiscoveryById(topId)
            if (disc != null) {
                val isSaved = savedDiscoveries.any { it.id == topId }
                DetailScreen(
                    discovery = disc,
                    onBack = { detailStack.removeAt(detailStack.lastIndex) },
                    onOpenDiscovery = handleOpenDiscovery,
                    onToggleSave = handleToggleSave,
                    isSaved = isSaved
                )
            }
        }

        // Floating Toast Notification
        AnimatedVisibility(
            visible = toastMessage != null,
            enter = fadeIn() + slideInVertically { it / 2 },
            exit = fadeOut() + slideOutVertically { it / 2 },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .navigationBarsPadding()
                .padding(bottom = 96.dp)
        ) {
            toastMessage?.let { msg ->
                Box(
                    modifier = Modifier
                        .shadow(12.dp, RoundedCornerShape(999.dp))
                        .clip(RoundedCornerShape(999.dp))
                        .background(theme.textPrimary)
                        .padding(horizontal = 24.dp, vertical = 12.dp)
                ) {
                    Text(
                        text = msg,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = theme.surface
                    )
                }
            }
        }
    }
}
