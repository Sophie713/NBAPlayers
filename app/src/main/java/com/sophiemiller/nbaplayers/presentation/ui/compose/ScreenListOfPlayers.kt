package com.sophiemiller.nbaplayers.presentation.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sophiemiller.nbaplayers.R
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.DefaultVerticalSpacer
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.InfoDialog
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.ListItemNBAPlayer
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.Toolbar
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.viewModels.PlayersAppViewModel
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.viewModels.viewModelEvents.SharedViewModelEvents
import kotlinx.coroutines.flow.distinctUntilChanged

/**
 * Main screen for list of players
 *
 * @param sharedPlayersAppViewModel
 */
@Composable
fun ScreenListOfPlayers(
    sharedPlayersAppViewModel: PlayersAppViewModel,
) {
    val uiState = sharedPlayersAppViewModel.listOfPlayersState.collectAsState()
    val listState = rememberLazyListState()

    Column(Modifier.fillMaxSize().background(MaterialTheme.colorScheme.primaryContainer)) {
        if (uiState.value.showErrorDialog) {
            InfoDialog(
                onDismiss = { sharedPlayersAppViewModel.onEvent(SharedViewModelEvents.OnDismissErrorDialog) },
                title = stringResource(R.string.error_loading_players),
                description = stringResource(R.string.error_loading_players_desc),
                buttonText = stringResource(R.string.ok)
            )
        }
        if (uiState.value.isLoading) {
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
        if (uiState.value.playersList.size < 1) {
            Button(onClick = {
                sharedPlayersAppViewModel.onEvent(SharedViewModelEvents.OnLoadMorePlayers)
            }, modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(text = "Reload")
            }
        } else {
            // Main layout
            LazyColumn(
                state = listState,
                modifier = Modifier.fillMaxSize()
            ) {
                items(uiState.value.playersList.size) { position ->
                    uiState.value.playersList[position]?.let {
                        ListItemNBAPlayer(it) {
                            sharedPlayersAppViewModel.onEvent(
                                SharedViewModelEvents.OnPlayerItemClicked(
                                    it
                                )
                            )
                        }
                    }
                }
            }
            LaunchedEffect(listState) {
                snapshotFlow { listState.firstVisibleItemIndex + listState.layoutInfo.visibleItemsInfo.size >= listState.layoutInfo.totalItemsCount }
                    .distinctUntilChanged()
                    .collect { isAtEnd ->
                        if (isAtEnd) {
                            sharedPlayersAppViewModel.onEvent(
                                SharedViewModelEvents.OnShowListLoading(
                                    true
                                )
                            )
                            sharedPlayersAppViewModel.onEvent(SharedViewModelEvents.OnLoadMorePlayers)
                        }
                    }
            }
        }
    }
}

