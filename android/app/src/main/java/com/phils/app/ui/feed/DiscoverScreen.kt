package com.phils.app.ui.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudOff
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phils.app.model.Discovery
import com.phils.app.theme.PhilsTheme
import com.phils.app.ui.components.WhySheet

@Composable
fun DiscoverScreen(
    discoveries: List<Discovery>,
    currentIndex: Int,
    onIndexChange: (Int) -> Unit,
    onExplore: (Discovery) -> Unit,
    onToggleSave: (Discovery) -> Unit,
    onLoadMore: () -> Unit = {},
    isFetching: Boolean = false,
    errorMessage: String? = null,
    isCacheLoaded: Boolean = true,
    onRetry: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val theme = PhilsTheme.colors
    var whyDiscovery by remember { mutableStateOf<Discovery?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(top = 16.dp, bottom = 86.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Header
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Text(
                text = "Phils",
                fontFamily = FontFamily.Serif,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Medium,
                fontSize = 28.sp,
                color = theme.textPrimary
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Discover ideas worth thinking about.",
                fontFamily = FontFamily.SansSerif,
                fontSize = 13.sp,
                color = theme.textSecondary
            )
        }

        // Card Stack / Empty / Loading / Error State
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            if (discoveries.isNotEmpty()) {
                CardStack(
                    discoveries = discoveries,
                    currentIndex = currentIndex,
                    onIndexChange = onIndexChange,
                    onExplore = onExplore,
                    onToggleSave = onToggleSave,
                    onShowWhy = { whyDiscovery = it },
                    onLoadMore = onLoadMore
                )
            } else if (!isCacheLoaded || (isFetching && errorMessage == null)) {
                // Editorial Loading Card State
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .height(340.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(theme.surface)
                        .border(1.dp, theme.line, RoundedCornerShape(20.dp))
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(36.dp),
                            color = theme.textPrimary,
                            strokeWidth = 2.5.dp
                        )
                        Spacer(modifier = Modifier.height(18.dp))
                        Text(
                            text = "Gathering ideas worth thinking about...",
                            fontFamily = FontFamily.Serif,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = theme.textPrimary,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "Connecting to Phils API",
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 12.sp,
                            color = theme.textSecondary
                        )
                    }
                }
            } else {
                // Editorial Error State
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .height(360.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(theme.surface)
                        .border(1.dp, theme.line, RoundedCornerShape(20.dp))
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.CloudOff,
                            contentDescription = "Server Offline",
                            tint = theme.textSecondary,
                            modifier = Modifier.size(42.dp)
                        )
                        Spacer(modifier = Modifier.height(14.dp))
                        Text(
                            text = "Server Offline",
                            fontFamily = FontFamily.Serif,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = theme.textPrimary,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = errorMessage ?: "Unable to fetch discoveries from the API. Please ensure the backend is running.",
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 13.sp,
                            color = theme.textSecondary,
                            textAlign = TextAlign.Center,
                            lineHeight = 18.sp
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(999.dp))
                                .background(theme.textPrimary)
                                .clickable { onRetry() }
                                .padding(horizontal = 20.dp, vertical = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Refresh,
                                contentDescription = "Retry",
                                tint = theme.bg,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Retry Connection",
                                fontFamily = FontFamily.SansSerif,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = theme.bg
                            )
                        }
                    }
                }
            }
        }

        // Footer Hint
        Text(
            text = if (discoveries.isNotEmpty()) "Swipe to discover next idea" else "",
            fontFamily = FontFamily.Monospace,
            fontSize = 11.sp,
            color = theme.textFaint,
            letterSpacing = 1.sp
        )
    }

    whyDiscovery?.let { disc ->
        WhySheet(
            discovery = disc,
            onDismiss = { whyDiscovery = null }
        )
    }
}
