package com.mrskar.composeworkshop.main

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrskar.composeworkshop.MenuAction
import com.mrskar.composeworkshop.composables.CustomBottomBar
import com.mrskar.composeworkshop.composables.DefaultTopAppBar
import com.mrskar.composeworkshop.ui.theme.ComposeWorkshopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeWorkshopTheme {
                MainSkeleton(
                    topBar = {
                        DefaultTopAppBar()
                    },
                    content = {
                        Counter(Modifier.padding(16.dp))
                    },
                    bottomBar = {
                        CustomBottomBar(
                            items = listOf(MenuAction.Notifications, MenuAction.Cart),
                            onActionClick = { index ->
                                // Perform some action, like changing "content" lambda
                            }
                        )
                    }
                )
            }
        }
    }
}

@Composable
private fun MainSkeleton(
    topBar: @Composable () -> Unit,
    content: @Composable (PaddingValues) -> Unit,
    bottomBar: @Composable () -> Unit,
) {
    Scaffold(
        scaffoldState = rememberScaffoldState(),
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colors.background,
        topBar = topBar,
        bottomBar = bottomBar,
        content = content
    )
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_3,
    uiMode = UI_MODE_NIGHT_YES
)
@Preview(
    showBackground = true,
    device = Devices.PIXEL_3,
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
private fun DefaultPreview() {
    ComposeWorkshopTheme {
        MainSkeleton(
            topBar = { DefaultTopAppBar() },
            content = { Counter(Modifier.padding(it)) },
            bottomBar = {
                CustomBottomBar(
                    items = listOf(MenuAction.Notifications, MenuAction.Cart),
                    onActionClick = { index ->

                    }
                )
            }
        )
    }
}