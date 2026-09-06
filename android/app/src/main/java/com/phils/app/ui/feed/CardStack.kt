package com.phils.app.ui.feed

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.phils.app.model.Discovery
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

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

    androidx.compose.runtime.LaunchedEffect(currentIndex, discoveries.size) {
        if (discoveries.isNotEmpty() && currentIndex >= discoveries.size - 4) {
            onLoadMore()
        }
    }

    val coroutineScope = rememberCoroutineScope()
    val dragOffsetX = remember { Animatable(0f) }
    var isDragging by remember { mutableStateOf(false) }

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
                .fillMaxSize(0.88f)
                .offset(x = (-30).dp, y = 48.dp)
                .rotate(-5.5f)
                .zIndex(1f)
                .graphicsLayer(alpha = 0.85f)
        ) {
            DiscoveryCard(
                discovery = thirdCard,
                onExplore = {},
                onToggleSave = {},
                onShowWhy = {}
            )
        }

        // Slot 1: Middle second card
        Box(
            modifier = Modifier
                .fillMaxSize(0.94f)
                .offset(x = 34.dp, y = 24.dp)
                .rotate(4.5f)
                .zIndex(2f)
                .graphicsLayer(alpha = 0.95f)
        ) {
            DiscoveryCard(
                discovery = nextCard,
                onExplore = {},
                onToggleSave = {},
                onShowWhy = {}
            )
        }

        // Slot 0: Front interactive card
        val currentTilt = -2.5f + (dragOffsetX.value / 25f)

        Box(
            modifier = Modifier
                .fillMaxSize()
                .offset { IntOffset(dragOffsetX.value.roundToInt(), 0) }
                .rotate(currentTilt)
                .zIndex(3f)
                .pointerInput(currentIndex) {
                    detectHorizontalDragGestures(
                        onDragStart = { isDragging = true },
                        onDragEnd = {
                            isDragging = false
                            val currentX = dragOffsetX.value
                            val threshold = 180f
                            coroutineScope.launch {
                                if (currentX > threshold) {
                                    // Swiped Right -> Throw off and advance
                                    dragOffsetX.animateTo(
                                        targetValue = 1200f,
                                        animationSpec = spring(dampingRatio = 0.8f, stiffness = Spring.StiffnessMedium)
                                    )
                                    onIndexChange((currentIndex + 1) % discoveries.size)
                                    dragOffsetX.snapTo(0f)
                                } else if (currentX < -threshold) {
                                    // Swiped Left -> Throw off and advance
                                    dragOffsetX.animateTo(
                                        targetValue = -1200f,
                                        animationSpec = spring(dampingRatio = 0.8f, stiffness = Spring.StiffnessMedium)
                                    )
                                    onIndexChange((currentIndex + 1) % discoveries.size)
                                    dragOffsetX.snapTo(0f)
                                } else {
                                    // Snap back to center
                                    dragOffsetX.animateTo(
                                        targetValue = 0f,
                                        animationSpec = spring(dampingRatio = 0.7f, stiffness = Spring.StiffnessLow)
                                    )
                                }
                            }
                        },
                        onDragCancel = {
                            isDragging = false
                            coroutineScope.launch { dragOffsetX.animateTo(0f) }
                        },
                        onHorizontalDrag = { _, dragAmount ->
                            coroutineScope.launch {
                                dragOffsetX.snapTo(dragOffsetX.value + dragAmount)
                            }
                        }
                    )
                }
        ) {
            DiscoveryCard(
                discovery = currentCard,
                onExplore = onExplore,
                onToggleSave = onToggleSave,
                onShowWhy = onShowWhy
            )
        }
    }
}
