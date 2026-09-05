package com.phils.app.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

val LocalPhilsColors = staticCompositionLocalOf { SolLightColors }

object PhilsTheme {
    val colors: PhilsThemeColors
        @Composable
        @ReadOnlyComposable
        get() = LocalPhilsColors.current

    val typography: androidx.compose.material3.Typography
        @Composable
        @ReadOnlyComposable
        get() = PhilsTypography
}

@Composable
fun PhilsAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val philsColors = if (darkTheme) ManiDarkColors else SolLightColors

    val materialColors = if (darkTheme) {
        darkColorScheme(
            primary = philsColors.textPrimary,
            onPrimary = philsColors.surface,
            surface = philsColors.surface,
            onSurface = philsColors.textPrimary,
            background = philsColors.bg,
            onBackground = philsColors.textPrimary
        )
    } else {
        lightColorScheme(
            primary = philsColors.textPrimary,
            onPrimary = philsColors.surface,
            surface = philsColors.surface,
            onSurface = philsColors.textPrimary,
            background = philsColors.bg,
            onBackground = philsColors.textPrimary
        )
    }

    CompositionLocalProvider(LocalPhilsColors provides philsColors) {
        MaterialTheme(
            colorScheme = materialColors,
            typography = PhilsTypography,
            content = content
        )
    }
}
