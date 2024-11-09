package com.sophiemiller.nbaplayers.presentation.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.DefaultVerticalSpacer
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.Toolbar
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.ViewItemMediumTextRow
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.viewModels.PlayersAppViewModel
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.viewModels.viewModelEvents.SharedViewModelEvents

/**
 * Club details screen
 *
 * @param sharedPlayersAppViewModel
 */
@Composable
fun ScreenTeamDetails(
    sharedPlayersAppViewModel: PlayersAppViewModel,
) {
    val uiState = sharedPlayersAppViewModel.playerTeamState.collectAsState()
    val scrollState = rememberScrollState()
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            //Toolbar
            Toolbar(title = "${uiState.value.team.fullName}") {
                sharedPlayersAppViewModel.onEvent(
                    SharedViewModelEvents.OnNavigateBack
                )
            }
            DefaultVerticalSpacer()
            //check info isnt null and add info
            uiState.value.team.abbreviation?.let {
                ViewItemMediumTextRow("Abbreviation: $it")
            }
            uiState.value.team.conference?.let {
                ViewItemMediumTextRow("Conference: $it")
            }
            uiState.value.team.division?.let {
                ViewItemMediumTextRow("Division: $it")
            }
            uiState.value.team.city?.let {
                ViewItemMediumTextRow("City: $it")
            }
        }
    }
}