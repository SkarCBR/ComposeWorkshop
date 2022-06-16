package com.mrskar.composeworkshop.themepreviews

import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.mrskar.composeworkshop.MenuAction
import com.mrskar.composeworkshop.composables.CustomTopAppBar
import com.mrskar.composeworkshop.ui.theme.AvailableThemes
import com.mrskar.composeworkshop.ui.theme.ComposeWorkshopTheme

@Composable
fun ThemePreview(theme: AvailableThemes = AvailableThemes.DefaultLight) {
    val menuItems = listOf(MenuAction.Notifications, MenuAction.Cart)
    val currentTheme = remember { mutableStateOf(theme) }
    ComposeWorkshopTheme(currentTheme.value) {
        Scaffold(
            topBar = {
                CustomTopAppBar(
                    onNavIconClick = {},
                    onActionClick = {
                        currentTheme.value = rotateTheme(currentTheme.value)
                    }
                )
            },
            bottomBar = {
                BottomAppBar {
                    menuItems.forEach {
                        IconButton(
                            modifier = Modifier.weight(1f),
                            onClick = { }
                        ) {
                            Icon(
                                painter = painterResource(id = it.icon),
                                contentDescription = it.label
                            )
                        }
                    }
                }
            }
        ) {
            ThemePreviewContent()
        }
    }
}

private fun rotateTheme(theme: AvailableThemes): AvailableThemes {
    return when (theme) {
        AvailableThemes.DefaultLight -> AvailableThemes.CustomLight
        AvailableThemes.CustomLight -> AvailableThemes.Legacy
        AvailableThemes.Legacy -> AvailableThemes.DefaultDark
        AvailableThemes.DefaultDark -> AvailableThemes.DefaultLight
    }
}

@Preview
@Composable
private fun ThemePreviewLight() {
    ThemePreview(AvailableThemes.DefaultLight)
}

@Preview
@Composable
private fun ThemePreviewLegacy() {
    ThemePreview(AvailableThemes.Legacy)
}

@Preview
@Composable
private fun ThemePreviewNew() {
    ThemePreview(AvailableThemes.CustomLight)
}
