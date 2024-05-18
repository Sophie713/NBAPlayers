package com.sophiemiller.nbaplayers.presentation.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.DefaultVerticalSpacer
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.HeaderText
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.ViewItemMediumTextRow
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.viewModels.ListOfPlayersViewModel

/**
 * Club details screen
 *
 * @param sharedListOfPlayersViewModel
 * @param playerPosition
 */
@Composable
fun ScreenClubDetails(
    sharedListOfPlayersViewModel: ListOfPlayersViewModel,
    playerPosition: Int
) {
    val team = sharedListOfPlayersViewModel.getPlayersList()[playerPosition].team
    Surface {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            HeaderText(text = "Team Name: ${team.fullName}")
            DefaultVerticalSpacer()
            ViewItemMediumTextRow("Abbreviation: ${team.abbreviation}")
            ViewItemMediumTextRow("Conference: ${team.conference}")
            ViewItemMediumTextRow("Division: ${team.division}")
            ViewItemMediumTextRow("City: ${team.city}")
        }
    }
}