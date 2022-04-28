package com.mrskar.composeworkshop.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Row {
        Button(
            onClick = { updateCount(count + 1) },
            enabled = count < 6,
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Text(
                text = if (count < 6) "Click on this Button!" else "Button disabled",
                color = if (count >= 6) Color.Red else Color.White
            )
        }
        if (count >= 6) {
            AnimatedVisibility(visible = count >= 6) {
                Button(
                    onClick = { updateCount(0) },
                    modifier = Modifier
                        .padding(start = 8.dp)
                ) {
                    Text(text = "Reset count")
                }
            }
        }
    }
}