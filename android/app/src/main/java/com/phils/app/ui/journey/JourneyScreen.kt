package com.phils.app.ui.journey

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phils.app.model.Discovery
import com.phils.app.theme.PhilsTheme
import com.phils.app.ui.components.MiniCard
import kotlin.math.roundToInt

@Composable
fun JourneyScreen(
    discoveredList: List<Discovery>,
    savedCount: Int,
    isDarkTheme: Boolean,
    onToggleTheme: (Boolean) -> Unit,
    onOpenDiscovery: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val theme = PhilsTheme.colors
    val scrollState = rememberScrollState()

    val discoveredCount = discoveredList.size
    val philosophiesCount = discoveredList.count { it.type == "PHILOSOPHY" }

    // Tally by type
    val typeTally = discoveredList.groupBy { it.type }.mapValues { it.value.size }
    val topTypes = typeTally.entries.sortedByDescending { it.value }.take(3)

    Column(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .verticalScroll(scrollState)
            .padding(top = 16.dp, start = 20.dp, end = 20.dp, bottom = 90.dp)
    ) {
        Text(
            text = "Your Journey",
            fontFamily = FontFamily.Serif,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Medium,
            fontSize = 28.sp,
            color = theme.textPrimary
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "A record of what you've explored, not who's watching.",
            fontFamily = FontFamily.SansSerif,
            fontSize = 13.sp,
            color = theme.textSecondary
        )

        Spacer(modifier = Modifier.height(30.dp))

        // Stat Blocks Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            StatBlock(value = discoveredCount, label = "Ideas discovered")
            StatBlock(value = philosophiesCount, label = "Philosophies explored")
            StatBlock(value = savedCount, label = "Ideas saved")
        }

        Spacer(modifier = Modifier.height(36.dp))

        // Recently Discovered Carousel
        if (discoveredList.isNotEmpty()) {
            Text(
                text = "RECENTLY DISCOVERED",
                fontFamily = FontFamily.Monospace,
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = 1.4.sp,
                color = theme.textFaint
            )

            Spacer(modifier = Modifier.height(14.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(discoveredList.take(6), key = { it.id }) { discovery ->
                    Box(modifier = Modifier.width(160.dp)) {
                        MiniCard(
                            discovery = discovery,
                            onOpen = onOpenDiscovery,
                            showSave = false
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(36.dp))
        }

        // Most Explored Areas
        if (topTypes.isNotEmpty()) {
            Text(
                text = "MOST EXPLORED AREAS",
                fontFamily = FontFamily.Monospace,
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = 1.4.sp,
                color = theme.textFaint
            )

            Spacer(modifier = Modifier.height(14.dp))

            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                topTypes.forEach { (type, count) ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(theme.surface)
                            .border(1.dp, theme.line, RoundedCornerShape(12.dp))
                            .padding(horizontal = 16.dp, vertical = 14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = type,
                            fontFamily = FontFamily.Monospace,
                            fontSize = 12.sp,
                            color = theme.textPrimary
                        )
                        Text(
                            text = "$count",
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 13.sp,
                            color = theme.textSecondary
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(36.dp))
        }

        // Appearance Settings
        Text(
            text = "APPEARANCE",
            fontFamily = FontFamily.Monospace,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = 1.4.sp,
            color = theme.textFaint
        )

        Spacer(modifier = Modifier.height(14.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(theme.surface)
                .border(1.dp, theme.line, RoundedCornerShape(14.dp))
                .padding(horizontal = 18.dp, vertical = 14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = if (isDarkTheme) Icons.Filled.DarkMode else Icons.Filled.LightMode,
                    contentDescription = "Theme",
                    tint = theme.textPrimary,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = if (isDarkTheme) "Máni (Dark night)" else "Sól (Light parchment)",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 14.sp,
                    color = theme.textPrimary
                )
            }

            Switch(
                checked = isDarkTheme,
                onCheckedChange = onToggleTheme,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = theme.surface,
                    checkedTrackColor = theme.textPrimary,
                    uncheckedThumbColor = theme.textPrimary,
                    uncheckedTrackColor = theme.bgSoft
                )
            )
        }
    }
}

@Composable
private fun StatBlock(value: Int, label: String) {
    val theme = PhilsTheme.colors
    val animVal = remember { Animatable(0f) }

    LaunchedEffect(value) {
        animVal.animateTo(value.toFloat(), animationSpec = tween(700))
    }

    Column {
        Text(
            text = "${animVal.value.roundToInt()}",
            fontFamily = FontFamily.Serif,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp,
            color = theme.textPrimary
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            fontFamily = FontFamily.SansSerif,
            fontSize = 11.5.sp,
            color = theme.textSecondary
        )
    }
}
