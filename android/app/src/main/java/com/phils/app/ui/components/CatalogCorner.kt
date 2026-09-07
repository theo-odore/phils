package com.phils.app.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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

    val shadowPath = remember { Path() }
    val foldPath = remember { Path() }

    Box(modifier = modifier.size(34.dp)) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val w = size.width
            val h = size.height

            // 1. Fold Shadow
            shadowPath.reset()
            shadowPath.moveTo(0f, 0f)
            shadowPath.lineTo(w, h)
            shadowPath.lineTo(0f, h)
            shadowPath.close()
            drawPath(shadowPath, color = shadowColor)

            // 2. Main Corner Fold Triangle
            foldPath.reset()
            foldPath.moveTo(0f, 0f)
            foldPath.lineTo(w, 0f)
            foldPath.lineTo(w, h)
            foldPath.close()
            drawPath(foldPath, color = foldColor)
        }
    }
}
