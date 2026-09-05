package com.phils.app.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp
import com.phils.app.theme.PhilsTheme

@Composable
fun CatalogCorner(modifier: Modifier = Modifier) {
    val theme = PhilsTheme.colors
    val foldColor = theme.bg
    val shadowColor = if (!theme.isDark) Color(0x22000000) else Color(0x44000000)

    Box(modifier = modifier.size(34.dp)) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val w = size.width
            val h = size.height

            // 1. Fold Shadow
            val shadowPath = Path().apply {
                moveTo(0f, 0f)
                lineTo(w, h)
                lineTo(0f, h)
                close()
            }
            drawPath(shadowPath, color = shadowColor)

            // 2. Main Corner Fold Triangle
            val foldPath = Path().apply {
                moveTo(0f, 0f)
                lineTo(w, 0f)
                lineTo(w, h)
                close()
            }
            drawPath(foldPath, color = foldColor)
        }
    }
}
