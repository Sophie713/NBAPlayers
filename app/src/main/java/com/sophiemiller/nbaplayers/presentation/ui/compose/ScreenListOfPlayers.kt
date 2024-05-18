package com.sophiemiller.nbaplayers.presentation.ui.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.DefaultSpacer
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.ListItemNBAPlayer
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.navigation.Screens
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.viewModels.ListOfPlayersViewModel
import kotlinx.coroutines.flow.distinctUntilChanged

@Composable
fun ScreenListOfPlayers(
    sharedListOfPlayersViewModel: ListOfPlayersViewModel,
    navController: NavController
) {
    val listOfPlayers = sharedListOfPlayersViewModel.getPlayersList()
    val listState = rememberLazyListState()
    var isLoading by remember { mutableStateOf(true) }
    if (isLoading) {
        DefaultSpacer()
        CircularProgressIndicator(
            modifier = Modifier.width(80.dp),
            color = MaterialTheme.colorScheme.background,
            trackColor = MaterialTheme.colorScheme.primary,
        )
    }
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
                player.team.fullName,
                {
                    navController.navigate(Screens.ScreenPlayerDetails.withArgs(position.toString()))
                }
            )
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

