package com.phils.app.ui.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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

        // Card Stack with dynamic flex weight
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            CardStack(
                discoveries = discoveries,
                currentIndex = currentIndex,
                onIndexChange = onIndexChange,
                onExplore = onExplore,
                onToggleSave = onToggleSave,
                onShowWhy = { whyDiscovery = it },
                onLoadMore = onLoadMore
            )
        }

        // Footer Hint
        Text(
            text = "Swipe to discover next idea",
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
