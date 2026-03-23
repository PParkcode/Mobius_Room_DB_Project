package com.mobius.pbl.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * @file MobiusPblTheme.kt
 * @fn MobiusPblTheme
 * @brief Material3 테마 정의입니다.
 */
@Composable
fun MobiusPblTheme(
    content: @Composable () -> Unit,
) {
    val isDark = isSystemInDarkTheme()
    val colorScheme = if (isDark) {
        darkColorScheme(
            primary = Color(0xFFBB86FC),
        )
    } else {
        lightColorScheme(
            primary = Color(0xFF6200EE),
            secondary = Color(0xFF03DAC5),
        )
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}

