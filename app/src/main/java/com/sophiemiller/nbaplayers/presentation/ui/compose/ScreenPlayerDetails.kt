package com.sophiemiller.nbaplayers.presentation.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.DefaultVerticalSpacer
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.Toolbar
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.ViewItemMediumTextRow
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.viewModels.PlayersAppViewModel
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.viewModels.viewModelEvents.SharedViewModelEvents

/**
 * player details screen
 *
 * @param sharedPlayersAppViewModel
 */
@Composable
fun ScreenPlayerDetails(
    sharedPlayersAppViewModel: PlayersAppViewModel
) {
    val uiState = sharedPlayersAppViewModel.playerDetailState.collectAsState()
    val scrollState = rememberScrollState()
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            //Toolbar
            Toolbar(title = "${(uiState.value.player.firstName ?: "")} ${(uiState.value.player.lastName ?: "")}")
            { sharedPlayersAppViewModel.onEvent(SharedViewModelEvents.OnNavigateBack) }
            DefaultVerticalSpacer()
            uiState.value.player.position?.let {
                ViewItemMediumTextRow("Position: $it")
            }
            uiState.value.player.height?.let {
                ViewItemMediumTextRow("Height : $it")
            }
            uiState.value.player.weight?.let {
                ViewItemMediumTextRow("Weight: $it")
            }
            uiState.value.player.jerseyNumber?.let {
                ViewItemMediumTextRow("Jersey Number: $it")
            }
            uiState.value.player.college?.let {
                ViewItemMediumTextRow("College: $it")
            }
            uiState.value.player.country?.let {
                ViewItemMediumTextRow("Country: $it")
            }
            uiState.value.player.draftYear?.let {
                ViewItemMediumTextRow("Draft Year: $it")
            }
            uiState.value.player.draftRound?.let {
                ViewItemMediumTextRow("Draft Round: $it")
            }
            uiState.value.player.draftNumber?.let {
                ViewItemMediumTextRow("Draft Number: $it")
            }
            DefaultVerticalSpacer()
            uiState.value.player.team?.let { team ->
                if (team.fullName != null) {
                    Button(onClick = {
                        sharedPlayersAppViewModel.onEvent(SharedViewModelEvents.OnTeamDetailsClicked(team))
                    }, modifier = Modifier.padding(horizontal = 16.dp)) {
                        Text(text = "Team Info")
                    }
                }
            }
        }
    }
}
