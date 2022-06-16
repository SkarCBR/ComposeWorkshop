package com.mrskar.composeworkshop

import androidx.annotation.DrawableRes

sealed class MenuAction(
    val label: String,
    @DrawableRes val icon: Int
) {
    object Notifications : MenuAction(
        "Notifications",
        R.drawable.icons_normal_ic_notification_brand_blue
    )

    object Cart : MenuAction("Cart", R.drawable.ic_cart)
}