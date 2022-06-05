package com.mrskar.composeworkshop.composables

import androidx.compose.foundation.clickable
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.mrskar.composeworkshop.R

@Composable
fun CustomTopAppBar(
    onNavIconClick: (Int) -> Unit,
    onActionClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier,
        content = {
            Icon(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier.clickable { onNavIconClick(0) }
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_cart),
                contentDescription = null,
                modifier = Modifier.clickable { onNavIconClick(1) }
            )
            Text(
                text = "Title",
                modifier = Modifier.weight(1f)
            )
            IconButton(
                onClick = onActionClick
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icons_normal_ic_notification_brand_blue),
                    contentDescription = null,
                )
            }
        }
    )
}