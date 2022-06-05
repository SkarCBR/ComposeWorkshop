package com.mrskar.composeworkshop.composables

import android.content.Intent
import android.net.Uri
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.mrskar.composeworkshop.ui.theme.ComposeWorkshopTheme

@Composable
fun TextWithLink(
    moreInfoText: String,
    url: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(url)) }
    TextButton(
        onClick = {
            onClick()
            context.startActivity(intent)
        },
        modifier = modifier
    ) {
        Text(
            text = moreInfoText,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    ComposeWorkshopTheme {
        TextWithLink(
            moreInfoText = "Text with Link",
            url = "www.lidl.com",
            onClick = { /* no op */ }
        )
    }
}
