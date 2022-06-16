package com.mrskar.composeworkshop.composables

import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.mrskar.composeworkshop.MenuAction

@Composable
fun CustomBottomBar(
    items: List<MenuAction>,
    onActionClick: (Int) -> Unit,
) {
    BottomAppBar {
        items.forEachIndexed { index, menuAction ->
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = { onActionClick(index) }
            ) {
                Icon(
                    painter = painterResource(id = menuAction.icon),
                    contentDescription = menuAction.label
                )
            }
        }
    }
}