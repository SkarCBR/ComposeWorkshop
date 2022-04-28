package com.mrskar.composeworkshop.composables

import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.mrskar.composeworkshop.R

@Composable
fun DefaultTopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "Title"
            )
        },
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
        },
        actions = {
            Icon(
                painter = painterResource(id = R.drawable.icons_normal_ic_notification_brand_blue),
                contentDescription = null,
                tint = MaterialTheme.colors.background
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_cart),
                contentDescription = null,
                tint = MaterialTheme.colors.background
            )
        }
    )
}