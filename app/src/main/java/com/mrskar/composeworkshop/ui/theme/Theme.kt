package com.mrskar.composeworkshop.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@Composable
fun ComposeWorkshopTheme(
    theme: AvailableThemes = if (isSystemInDarkTheme()) AvailableThemes.DefaultLight else AvailableThemes.DefaultDark,
    content: @Composable () -> Unit
) {
    val colors = when (theme) {
        AvailableThemes.DefaultDark -> DarkColorPalette
        AvailableThemes.CustomLight -> NewLightThemeColors
        AvailableThemes.Legacy -> LightThemeColors
        else -> LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = AppThemeTypography,
        shapes = Shapes,
        content = content
    )
}

enum class AvailableThemes {
    DefaultLight,
    DefaultDark,
    CustomLight,
    Legacy,
}

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightThemeColors = lightColors(
    primary = White,
    primaryVariant = White,
    onPrimary = BrandBlack,
    secondary = BrandBlue,
    secondaryVariant = BrandBlue,
    onSecondary = White,
    error = RedTomato,
    onError = White,
    onBackground = BrandBlack,
    background = Pearl,
    surface = White,
    onSurface = BrandBlack,
)

private val NewLightThemeColors = lightColors(
    primary = BrandBlue,
    primaryVariant = BrandBluePressed,
    onPrimary = White,
    secondary = BrandBlue,
    secondaryVariant = BrandBluePressed,
    onSecondary = White,
    error = RedTomato,
    onError = White,
    background = Pearl,
    onBackground = BrandBlack,
    surface = White,
    onSurface = BrandBlack,
)
