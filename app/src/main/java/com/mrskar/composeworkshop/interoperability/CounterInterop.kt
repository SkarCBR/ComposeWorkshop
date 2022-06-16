package com.mrskar.composeworkshop.interoperability

import android.content.res.Configuration
import android.widget.TextView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.mrskar.composeworkshop.composables.CounterButtons
import com.mrskar.composeworkshop.ui.theme.ComposeWorkshopTheme

@Composable
fun ContentInterop(
    modifier: Modifier = Modifier
) {
    val counterState = remember { mutableStateOf(0) }
    Column(modifier = modifier) {
        CounterButtons(counterState.value) { newCount ->
            counterState.value = newCount
        }
        Divider(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
        )
        Text("I've been clicked ${counterState.value} times")
        Divider(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
        )
        AndroidView(
            modifier = Modifier,
            factory = { context ->
                TextView(context)
            },
            update = {
                it.text = "I've been clicked ${counterState.value} times"
            }
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_3,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun DefaultPreview() {
    ComposeWorkshopTheme {
        ContentInterop(
            Modifier.padding(16.dp)
        )
    }
}
