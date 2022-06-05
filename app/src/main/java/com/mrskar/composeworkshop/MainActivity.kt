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
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrskar.composeworkshop.composables.Counter
import com.mrskar.composeworkshop.composables.DefaultTopAppBar
import com.mrskar.composeworkshop.ui.theme.ComposeWorkshopTheme
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow

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
    val snackbarHostState = remember { SnackbarHostState() }
    // we allow only one snackbar to be in the queue here, hence conflated
    val channel = remember { Channel<Int>(Channel.Factory.CONFLATED) }

    SnackBarComponent(channel, snackbarHostState)
    Scaffold(
        scaffoldState = rememberScaffoldState(snackbarHostState = snackbarHostState),
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colors.background,
        topBar = {
            DefaultTopAppBar()
        }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Counter(counterState.value) { newCount ->
                counterState.value = newCount
                if (counterState.value >= 6) {
                    channel.trySend(0)
                }
            }
            Divider(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )
            Text("I've been clicked ${counterState.value} times")
        }
    }
}

@Composable
private fun SnackBarComponent(channel: Channel<Int>, snackbarHostState: SnackbarHostState) {
    LaunchedEffect(key1 = channel) {
        channel.receiveAsFlow().collect {
            val result = snackbarHostState.showSnackbar(
                message = "This is a Snackbar!!",
                actionLabel = "Take Action!"
            )
            when (result) {
                SnackbarResult.ActionPerformed -> {
                    snackbarHostState.showSnackbar(
                        message = "Action performed!!"
                    )
                }
                SnackbarResult.Dismissed -> {
                    snackbarHostState.showSnackbar(
                        message = "Action dismissed!!"
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_3,
    uiMode = UI_MODE_NIGHT_YES
)
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