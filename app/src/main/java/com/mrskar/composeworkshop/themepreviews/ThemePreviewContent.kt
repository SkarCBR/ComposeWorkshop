package com.mrskar.composeworkshop.themepreviews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Snackbar
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun ThemePreviewContent() {
    val checkedState = remember { mutableStateOf(true) }
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        item { Text(text = "This is a Text") }
        item { TextButton(onClick = {}) { Text(text = "This is a TextButton") } }
        item { OutlinedButton(onClick = {}) { Text(text = "This is a OutlinedButton") } }
        item { Button(onClick = {}) { Text(text = "This is a Button") } }
        item {
            FloatingActionButton(onClick = {}) {
                Text(text = "This is a Floating Action Button")
            }
        }
        item {
            val textState = remember { mutableStateOf(TextFieldValue("This is a TextField")) }
            TextField(
                value = textState.value,
                onValueChange = { textState.value = it }
            )
        }
        item {
            val textState = remember {
                mutableStateOf(TextFieldValue("This is an OutlinedTextField"))
            }
            OutlinedTextField(
                value = textState.value,
                onValueChange = { textState.value = it }
            )
        }
        item {
            Snackbar(
                content = { Text(text = "This is a Snackbar") },
                action = { Text(text = "Action") }
            )
        }
        item {
            Switch(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it }
            )
        }
    }
}