package com.mrskar.composeworkshop.composables

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.mrskar.composeworkshop.MenuAction
import com.mrskar.composeworkshop.R

@Composable
fun DefaultTopAppBar(
    modifier: Modifier = Modifier
) {
    val menuItems = listOf(MenuAction.Notifications, MenuAction.Cart)
    TopAppBar(
        title = {
            Text(
                text = "Title"
            )
        },
        modifier = modifier,
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
        },
        actions = {
            menuItems.forEach {
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = it.icon),
                        contentDescription = it.label
                    )
                }
            }
        }
    )
}