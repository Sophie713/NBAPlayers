package com.sophiemiller.nbaplayers.presentation.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.DefaultVerticalSpacer
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.ListItemNBAPlayer
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.Toolbar
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.navigation.Screens
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.viewModels.ListOfPlayersViewModel
import kotlinx.coroutines.flow.distinctUntilChanged

/**
 * Main screen for list of players
 *
 * @param sharedListOfPlayersViewModel
 * @param navController
 */
@Composable
fun ScreenListOfPlayers(
    sharedListOfPlayersViewModel: ListOfPlayersViewModel,
    navController: NavController
) {
    Column {
        val listOfPlayers = sharedListOfPlayersViewModel.getPlayersList()
        val listState = rememberLazyListState()
        var isLoading by remember { mutableStateOf(true) }
        if (isLoading) {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.background,
                trackColor = MaterialTheme.colorScheme.primary,
            )
        }
        //Toolbar
        Toolbar(title = "NBA Players", onBackClick = null)
        DefaultVerticalSpacer()
        DefaultVerticalSpacer()
        // Main layout
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize()
        ) {
            items(listOfPlayers.size) { position ->
                if (listOfPlayers.size > 0) {
                    isLoading = false
                }
                val player = listOfPlayers[position]
                ListItemNBAPlayer(
                    "${player.firstName} ${player.lastName}",
                    player.position,
                    player.team?.fullName
                ) {
                    navController.navigate(Screens.ScreenPlayerDetails.withArgs(position.toString()))
                }
            }
        }

        LaunchedEffect(listState) {
            snapshotFlow { listState.firstVisibleItemIndex + listState.layoutInfo.visibleItemsInfo.size >= listState.layoutInfo.totalItemsCount }
                .distinctUntilChanged()
                .collect { isAtEnd ->
                    if (isAtEnd) {
                        sharedListOfPlayersViewModel.loadMoreItems()
                    }
                }
        }
    }
}

