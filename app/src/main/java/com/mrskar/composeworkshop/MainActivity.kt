package com.mrskar.composeworkshop

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrskar.composeworkshop.composables.Counter
import com.mrskar.composeworkshop.composables.CustomTopAppBar
import com.mrskar.composeworkshop.composables.DefaultTopAppBar
import com.mrskar.composeworkshop.ui.theme.ComposeWorkshopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeWorkshopTheme {
                Content()
            }
        }
    }
}

@Composable
private fun Content() {
    val counterState = remember { mutableStateOf(0) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colors.background,
        topBar = {
            DefaultTopAppBar()
            //CustomTopAppBar()
        }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Counter(counterState.value) { newCount ->
                counterState.value = newCount
            }
            Divider(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )
            Text("I've been clicked ${counterState.value} times")
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_3,
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
private fun DefaultPreview() {
    ComposeWorkshopTheme {
        Content()
    }
}