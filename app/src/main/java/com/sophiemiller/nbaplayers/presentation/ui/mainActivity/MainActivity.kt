package com.sophiemiller.nbaplayers.presentation.ui.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.sophiemiller.nbaplayers.presentation.ui.compose.MainActivityContent
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.viewModels.PlayersAppViewModel
import com.sophiemiller.nbaplayers.presentation.ui.theme.NBAPlayersTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * main startup activity that holds all the available screens
 *
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<PlayersAppViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NBAPlayersTheme(content = {MainActivityContent(viewModel)})
        }
        //load first batch of items
        viewModel.loadMoreItems()
    }
}