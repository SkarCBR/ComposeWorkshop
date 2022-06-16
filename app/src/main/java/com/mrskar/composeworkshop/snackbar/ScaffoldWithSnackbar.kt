package com.mrskar.composeworkshop.snackbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrskar.composeworkshop.ui.theme.AvailableThemes
import com.mrskar.composeworkshop.ui.theme.ComposeWorkshopTheme
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow

@Composable
private fun ScaffoldWithSnackbar() {
    val scaffoldState = rememberScaffoldState()
    // we allow only one snackbar to be in the queue here, hence conflated
    val channel = remember { Channel<SnackbarType>(Channel.CONFLATED) }

    Scaffold(
        scaffoldState = scaffoldState,
        snackbarHost = { CustomSnackbarHost(hostState = it) },
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colors.background,
    ) {
        Box(Modifier.padding(it)) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = { channel.trySend(SnackbarType.SUCCESS) },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Green
                    )
                ) {
                    Text(text = "Show success!")
                }
                Button(
                    onClick = { channel.trySend(SnackbarType.ERROR) },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.error
                    )
                ) {
                    Text(text = "Show error!")
                }
            }
        }
    }
    SnackBarComponent(channel, scaffoldState.snackbarHostState)
}

@Composable
private fun SnackBarComponent(
    channel: Channel<SnackbarType>,
    snackbarHostState: SnackbarHostState
) {
    LaunchedEffect(key1 = channel) {
        channel.receiveAsFlow().collect {
            val result = when (it) {
                SnackbarType.SUCCESS -> {
                    snackbarHostState.showSnackbar(
                        message = "This is a success Snackbar!!",
                        actionLabel = "Take Action!",
                        duration = SnackbarDuration.Short
                    )
                }
                SnackbarType.ERROR -> {
                    snackbarHostState.showSnackbar(
                        message = "This is an error Snackbar!!",
                        actionLabel = "Take Action!",
                        duration = SnackbarDuration.Short
                    )
                }
            }
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

enum class SnackbarType {
    SUCCESS,
    ERROR
}

@Preview
@Composable
private fun Preview() {
    ComposeWorkshopTheme(AvailableThemes.CustomLight) {
        ScaffoldWithSnackbar()
    }
}