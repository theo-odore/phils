package com.phils.app.ui.feed

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.phils.app.model.Discovery
import kotlinx.coroutines.launch
import kotlin.math.abs

@Composable
fun CardStack(
    discoveries: List<Discovery>,
    currentIndex: Int,
    onIndexChange: (Int) -> Unit,
    onExplore: (Discovery) -> Unit,
    onToggleSave: (Discovery) -> Unit,
    onShowWhy: (Discovery) -> Unit,
    onLoadMore: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    if (discoveries.isEmpty()) return

    LaunchedEffect(currentIndex, discoveries.size) {
        if (discoveries.isNotEmpty() && currentIndex >= discoveries.size - 4) {
            onLoadMore()
        }
    }

    val coroutineScope = rememberCoroutineScope()
    val density = LocalDensity.current

    // Direct primitive float tracking during drag.
    // Reading values inside graphicsLayer lambda ensures zero recomposition and zero layout recalculation.
    var dragOffsetX by remember { mutableFloatStateOf(0f) }
    val animOffsetX = remember { Animatable(0f) }
    var isAnimating by remember { mutableStateOf(false) }

    val thresholdPx = with(density) { 95.dp.toPx() }
    val throwDistancePx = with(density) { 460.dp.toPx() }

    val currentCard = discoveries[currentIndex % discoveries.size]
    val nextCard = discoveries[(currentIndex + 1) % discoveries.size]
    val thirdCard = discoveries[(currentIndex + 2) % discoveries.size]

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        // Slot 2: Background third card
        Box(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    val currentX = if (isAnimating) animOffsetX.value else dragOffsetX
                    val progress = (abs(currentX) / throwDistancePx).coerceIn(0f, 1f)

                    // Interpolate scale from 0.88 towards 0.94
                    val currentScale = 0.88f + (0.94f - 0.88f) * progress
                    scaleX = currentScale
                    scaleY = currentScale

                    // Interpolate translation towards Slot 1 position
                    val startX = -30.dp.toPx()
                    val targetX = 34.dp.toPx()
                    translationX = startX + (targetX - startX) * progress

                    val startY = 48.dp.toPx()
                    val targetY = 24.dp.toPx()
                    translationY = startY + (targetY - startY) * progress

                    // Interpolate rotation and alpha towards Slot 1
                    rotationZ = -5.5f + (4.5f - (-5.5f)) * progress
                    alpha = 0.85f + (0.95f - 0.85f) * progress
                }
        ) {
            DiscoveryCard(
                discovery = thirdCard,
                onExplore = {},
                onToggleSave = {},
                onShowWhy = {},
                interactive = false
            )
        }

        // Slot 1: Middle second card
        Box(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    val currentX = if (isAnimating) animOffsetX.value else dragOffsetX
                    val progress = (abs(currentX) / throwDistancePx).coerceIn(0f, 1f)

                    // Interpolate scale from 0.94 towards 1.0 (Slot 0 size)
                    val currentScale = 0.94f + (1.0f - 0.94f) * progress
                    scaleX = currentScale
                    scaleY = currentScale

                    // Interpolate translation towards Slot 0 center
                    val startX = 34.dp.toPx()
                    translationX = startX * (1f - progress)

                    val startY = 24.dp.toPx()
                    translationY = startY * (1f - progress)

                    // Interpolate rotation towards Slot 0 resting angle (-2.5f)
                    rotationZ = 4.5f + (-2.5f - 4.5f) * progress
                    alpha = 0.95f + (1.0f - 0.95f) * progress
                }
        ) {
            DiscoveryCard(
                discovery = nextCard,
                onExplore = {},
                onToggleSave = {},
                onShowWhy = {},
                interactive = false
            )
        }

        // Slot 0: Front interactive card
        Box(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    val currentX = if (isAnimating) animOffsetX.value else dragOffsetX
                    translationX = currentX
                    rotationZ = -2.5f + (currentX / 26f)
                    val dismissProgress = (abs(currentX) / throwDistancePx).coerceIn(0f, 1f)
                    alpha = 1f - (dismissProgress * 0.35f)
                }
                .pointerInput(currentIndex, discoveries.size) {
                    detectHorizontalDragGestures(
                        onDragStart = {
                            if (isAnimating) return@detectHorizontalDragGestures
                        },
                        onDragEnd = {
                            if (isAnimating) return@detectHorizontalDragGestures
                            val currentX = dragOffsetX
                            if (abs(currentX) > thresholdPx) {
                                val targetX = if (currentX > 0) throwDistancePx else -throwDistancePx
                                coroutineScope.launch {
                                    isAnimating = true
                                    animOffsetX.snapTo(currentX)
                                    animOffsetX.animateTo(
                                        targetValue = targetX,
                                        animationSpec = spring(
                                            dampingRatio = 0.82f,
                                            stiffness = Spring.StiffnessMedium
                                        )
                                    )
                                    onIndexChange((currentIndex + 1) % discoveries.size)
                                    dragOffsetX = 0f
                                    animOffsetX.snapTo(0f)
                                    isAnimating = false
                                }
                            } else {
                                coroutineScope.launch {
                                    isAnimating = true
                                    animOffsetX.snapTo(currentX)
                                    animOffsetX.animateTo(
                                        targetValue = 0f,
                                        animationSpec = spring(
                                            dampingRatio = 0.72f,
                                            stiffness = Spring.StiffnessLow
                                        )
                                    )
                                    dragOffsetX = 0f
                                    isAnimating = false
                                }
                            }
                        },
                        onDragCancel = {
                            if (isAnimating) return@detectHorizontalDragGestures
                            val currentX = dragOffsetX
                            coroutineScope.launch {
                                isAnimating = true
                                animOffsetX.snapTo(currentX)
                                animOffsetX.animateTo(
                                    targetValue = 0f,
                                    animationSpec = spring(
                                        dampingRatio = 0.72f,
                                        stiffness = Spring.StiffnessLow
                                    )
                                )
                                dragOffsetX = 0f
                                isAnimating = false
                            }
                        },
                        onHorizontalDrag = { change, dragAmount ->
                            if (!isAnimating) {
                                change.consume()
                                dragOffsetX += dragAmount
                            }
                        }
                    )
                }
        ) {
            DiscoveryCard(
                discovery = currentCard,
                onExplore = onExplore,
                onToggleSave = onToggleSave,
                onShowWhy = onShowWhy,
                interactive = true
            )
        }
    }
}
