package com.mrskar.composeworkshop.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mrskar.composeworkshop.composables.CounterButtons

@Composable
fun Counter(
    modifier: Modifier = Modifier
) {
    val counterState = remember { mutableStateOf(0) }
    Column(
        modifier = modifier
    ) {
        CounterButtons(counterState.value) { newCount ->
            counterState.value = newCount
        }
        Divider(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
        )
        Text("I've been clicked ${counterState.value} times")
    }
}