package com.phils.app.theme

import androidx.compose.ui.graphics.Color

// Dual Theme Tokens: Sól (Sun - Light) & Máni (Moon - Dark)
data class PhilsThemeColors(
    val isDark: Boolean,
    val bg: Color,
    val bgSoft: Color,
    val surface: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val textFaint: Color,
    val line: Color,
    val navBg: Color,
    val sheetBg: Color,
    val shadow: Color,
    val shadowSoft: Color,
    val skeleton: Color,
    val skeletonShine: Color
)

val SolLightColors = PhilsThemeColors(
    isDark = false,
    bg = Color(0xFFFDF8F5),
    bgSoft = Color(0xFFF4EBE1),
    surface = Color(0xFFFFFFFF),
    textPrimary = Color(0xFF4A3320),
    textSecondary = Color(0xFF8A6B4E),
    textFaint = Color(0xFFB5A292),
    line = Color(0xFFEAD5C5),
    navBg = Color(0xEBFFFFFF),
    sheetBg = Color(0xFFFDF8F5),
    shadow = Color(0x2E4A3320),
    shadowSoft = Color(0x1A4A3320),
    skeleton = Color(0xFFEAD5C5),
    skeletonShine = Color(0xA6FFFFFF)
)

val ManiDarkColors = PhilsThemeColors(
    isDark = true,
    bg = Color(0xFF0B1120),
    bgSoft = Color(0xFF151E2E),
    surface = Color(0xFF1E293B),
    textPrimary = Color(0xFFE2E8F0),
    textSecondary = Color(0xFF94A3B8),
    textFaint = Color(0xFF64748B),
    line = Color(0xFF334155),
    navBg = Color(0xEB1E293B),
    sheetBg = Color(0xFF0B1120),
    shadow = Color(0x99000000),
    shadowSoft = Color(0x66000000),
    skeleton = Color(0xFF334155),
    skeletonShine = Color(0x0FFFFFFF)
)

// Mood Color Palettes
data class MoodTone(
    val bg: Color,
    val accent: Color,
    val soft: Color
)

data class MoodPalette(
    val light: MoodTone,
    val dark: MoodTone
)

val Moods = mapOf(
    "stone" to MoodPalette(
        light = MoodTone(bg = Color(0xFFF4EFE6), accent = Color(0xFF6B5A3E), soft = Color(0xFFE8DFCF)),
        dark = MoodTone(bg = Color(0xFF2A2520), accent = Color(0xFFCDAF79), soft = Color(0xFF3D352E))
    ),
    "ocean" to MoodPalette(
        light = MoodTone(bg = Color(0xFFE6F0EE), accent = Color(0xFF2A5A5C), soft = Color(0xFFCDE3DF)),
        dark = MoodTone(bg = Color(0xFF172220), accent = Color(0xFF7FBCCF), soft = Color(0xFF233532))
    ),
    "burgundy" to MoodPalette(
        light = MoodTone(bg = Color(0xFFF4E2E0), accent = Color(0xFF8A332C), soft = Color(0xFFE8CAC6)),
        dark = MoodTone(bg = Color(0xFF2B1615), accent = Color(0xFFE09892), soft = Color(0xFF422120))
    ),
    "cosmic" to MoodPalette(
        light = MoodTone(bg = Color(0xFFEAE3F2), accent = Color(0xFF4A3A80), soft = Color(0xFFD8CDEC)),
        dark = MoodTone(bg = Color(0xFF1C1724), accent = Color(0xFFAC9BE8), soft = Color(0xFF2D243A))
    ),
    "sage" to MoodPalette(
        light = MoodTone(bg = Color(0xFFE9EDDE), accent = Color(0xFF4A6134), soft = Color(0xFFD5DCC1)),
        dark = MoodTone(bg = Color(0xFF1D2319), accent = Color(0xFFA8C78E), soft = Color(0xFF2F3827))
    ),
    "rose" to MoodPalette(
        light = MoodTone(bg = Color(0xFFF6E4E9), accent = Color(0xFF843458), soft = Color(0xFFECC6D6)),
        dark = MoodTone(bg = Color(0xFF261319), accent = Color(0xFFECAEC8), soft = Color(0xFF3E1E28))
    ),
    "ochre" to MoodPalette(
        light = MoodTone(bg = Color(0xFFF4E8D0), accent = Color(0xFF85601E), soft = Color(0xFFEBD6A9)),
        dark = MoodTone(bg = Color(0xFF261F12), accent = Color(0xFFE3AF53), soft = Color(0xFF40341E))
    ),
    "lavender" to MoodPalette(
        light = MoodTone(bg = Color(0xFFEFE6F4), accent = Color(0xFF604787), soft = Color(0xFFDFCEEF)),
        dark = MoodTone(bg = Color(0xFF1D1826), accent = Color(0xFFC1A7E8), soft = Color(0xFF2F263D))
    ),
    "terracotta" to MoodPalette(
        light = MoodTone(bg = Color(0xFFF4E4D8), accent = Color(0xFF964F2D), soft = Color(0xFFEAC9B2)),
        dark = MoodTone(bg = Color(0xFF271B13), accent = Color(0xFFEEB285), soft = Color(0xFF402D1F))
    ),
    "indigo" to MoodPalette(
        light = MoodTone(bg = Color(0xFFE4E6F1), accent = Color(0xFF323E75), soft = Color(0xFFCDD2EA)),
        dark = MoodTone(bg = Color(0xFF141728), accent = Color(0xFF97A1E3), soft = Color(0xFF222744))
    )
)

fun getMoodTone(moodKey: String, isDark: Boolean): MoodTone {
    val palette = Moods[moodKey] ?: Moods["stone"]!!
    return if (isDark) palette.dark else palette.light
}
