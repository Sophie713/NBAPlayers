package com.sophiemiller.nbaplayers.presentation.ui.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.sophiemiller.nbaplayers.presentation.ui.compose.MainActivityContent
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.viewModels.ListOfPlayersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<ListOfPlayersViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityContent(viewModel)
        }
    }
}