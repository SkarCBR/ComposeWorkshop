package com.mrskar.composeworkshop.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mrskar.composeworkshop.R

private val appFont = FontFamily(
    Font(R.font.roboto_black),
    Font(R.font.roboto_light, FontWeight.Light),
    Font(R.font.roboto_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.roboto_thin, FontWeight.Thin),
    Font(R.font.roboto_bold, FontWeight.Bold),
    Font(R.font.roboto_bold, FontWeight.SemiBold),
)

internal val AppThemeTypography = Typography(
    defaultFontFamily = appFont,
    h1 = TextStyle.H1,
    h2 = TextStyle.H2,
    h3 = TextStyle.H3,
    body1 = TextStyle.Body,
    body2 = TextStyle.BodySmall,
    caption = TextStyle.Caption,
    button = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        letterSpacing = 0.5.sp
    )
)

private val TextStyle.Companion.H1: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp,
        lineHeight = 34.sp,
    )

private val TextStyle.Companion.H2: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
    )

private val TextStyle.Companion.H3: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 24.sp,
    )

private val TextStyle.Companion.Body: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    )

private val TextStyle.Companion.BodySmall: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 24.sp,
    )

private val TextStyle.Companion.Caption: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.0.sp
    )

// Adding TextStyle using kotlin extension function
val TextStyle.Companion.Small: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    )

// Adding TextStyle to Typography using kotlin extension function
val Typography.tiny: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp,
    )
