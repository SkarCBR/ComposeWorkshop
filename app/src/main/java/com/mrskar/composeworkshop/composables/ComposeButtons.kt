package com.mrskar.composeworkshop.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrskar.composeworkshop.ui.theme.AvailableThemes
import com.mrskar.composeworkshop.ui.theme.ComposeWorkshopTheme

@Composable
internal fun LidlButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text,
        modifier
            .height(48.dp)
            .background(
                color = MaterialTheme.colors.secondary,
                shape = RoundedCornerShape(2.dp),
            )
            .clickable(onClick = onClick)
            .wrapContentHeight(),
        style = MaterialTheme.typography.button,
        color = MaterialTheme.colors.onSecondary,
        textAlign = TextAlign.Center,
    )
}

@Composable
internal fun LidlOutlineButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text,
        modifier
            .height(48.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.secondary,
                shape = RoundedCornerShape(2.dp),
            )
            .clickable(onClick = onClick)
            .wrapContentHeight(),
        style = MaterialTheme.typography.button,
        color = MaterialTheme.colors.secondary,
        textAlign = TextAlign.Center,
    )
}

@Composable
internal fun LidlOutlinedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val buttonColors = ButtonDefaults.textButtonColors(
        backgroundColor = Color.Transparent,
        contentColor = MaterialTheme.colors.secondary
    )
    Box(
        modifier = Modifier
            .clickable(
                onClick = onClick
            )
            .background(
                buttonColors.backgroundColor(true).value,
                RoundedCornerShape(2.dp)
            )
            .border(
                BorderStroke(1.dp, MaterialTheme.colors.secondary),
                RoundedCornerShape(2.dp)
            )
            .padding(start = 12.dp, end = 12.dp)
            .wrapContentSize()
            .height(40.dp)
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text.uppercase(),
            style = MaterialTheme.typography.button,
            lineHeight = 16.sp,
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = buttonColors.contentColor(true).value
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    ComposeWorkshopTheme(
        theme = AvailableThemes.CustomLight
    ) {
        Column(modifier = Modifier.padding(16.dp)){
            LidlButton(text = "Button!", onClick = { /*TODO*/ })
            Spacer(modifier = Modifier.height(8.dp))
            LidlOutlineButton(text = "Outlined Button!", onClick = { /*TODO*/ })
            Spacer(modifier = Modifier.height(8.dp))
            LidlOutlinedButton(text = "OutlinedButton", onClick =  {})
        }
    }
}