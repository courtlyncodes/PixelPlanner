package com.example.pixelplanner.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.ui.graphics.Color


// Light Color Scheme
val LightColorScheme = lightColorScheme(
    primary = SoftTaupe,
    onPrimary = OnSoftTaupe,
    primaryContainer = BlushPink,
    onPrimaryContainer = OnBlushPink,
    inversePrimary = WarmTerracotta,

    secondary = WarmTerracotta,
    onSecondary = OnWarmTerracotta,
    secondaryContainer = BlushPink,
    onSecondaryContainer = OnBlushPink,

    tertiary = SoftIvory,
    onTertiary = OnSoftIvory,
    tertiaryContainer = DelicateWhite,
    onTertiaryContainer = OnDelicateWhite,

    background = DelicateWhite,
    onBackground = OnDelicateWhite,
    surface = SoftIvory,
    onSurface = OnSoftIvory,

    surfaceVariant = CreamBeige,
    onSurfaceVariant = OnCreamBeige,

    error = ErrorRed,
    onError = OnError,
    errorContainer = ErrorContainer,
    onErrorContainer = OnErrorContainer
)

// Dark Color Scheme
val DarkColorScheme = darkColorScheme(
    primary = SoftTaupe,
    onPrimary = OnSoftTaupe,
    primaryContainer = BlushPink,
    onPrimaryContainer = OnBlushPink,
    inversePrimary = WarmTerracotta,

    secondary = WarmTerracotta,
    onSecondary = OnWarmTerracotta,
    secondaryContainer = CreamBeige,
    onSecondaryContainer = OnCreamBeige,

    tertiary = SoftIvory,
    onTertiary = OnSoftIvory,
    tertiaryContainer = DelicateWhite,
    onTertiaryContainer = OnDelicateWhite,

    background = DelicateWhite,
    onBackground = OnDelicateWhite,
    surface = SoftIvory,
    onSurface = OnSoftIvory,

    surfaceVariant = CreamBeige,
    onSurfaceVariant = OnCreamBeige,

    error = ErrorRed,
    onError = OnError,
    errorContainer = ErrorContainer,
    onErrorContainer = OnErrorContainer
)


@Composable
fun PixelPlannerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}