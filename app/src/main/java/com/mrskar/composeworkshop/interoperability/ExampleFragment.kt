package com.mrskar.composeworkshop.interoperability

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.mrskar.composeworkshop.R
import com.mrskar.composeworkshop.ui.theme.ComposeWorkshopTheme

class ExampleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            // Dispose of the Composition when the view's LifecycleOwner
            // is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                ComposeWorkshopTheme {
                    Text("Hello Compose!")
                }
            }
        }
    }

    /*
    // If more than one ComposeView, they must have ID to handle savedInstanceState
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        LinearLayout(requireContext()).apply {
            addView(ComposeView(requireContext()).apply {
                id = R.id.compose_view_x
            })
            addView(TextView(requireContext()))
            addView(ComposeView(requireContext()).apply {
                id = R.id.compose_view_y
            })
        }
     */
}