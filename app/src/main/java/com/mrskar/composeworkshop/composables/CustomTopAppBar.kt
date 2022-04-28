package com.mrskar.composeworkshop.composables

import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.mrskar.composeworkshop.R

@Composable
fun CustomTopAppBar() {
    TopAppBar(
        content = {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
            Text(
                text = "Title"
            )
            Icon(
                painter = painterResource(id = R.drawable.icons_normal_ic_notification_brand_blue),
                contentDescription = null,
                tint = MaterialTheme.colors.background,
            )
        }
    )
}