package com.sophiemiller.nbaplayers.presentation.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.DefaultVerticalSpacer
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.HeaderText
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.ViewItemMediumTextRow
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.navigation.Screens
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.viewModels.ListOfPlayersViewModel

/**
 * player details screen
 *
 * @param navController
 * @param sharedListOfPlayersViewModel
 * @param playerPosition
 */
@Composable
fun ScreenPlayerDetails(
    navController: NavHostController,
    sharedListOfPlayersViewModel: ListOfPlayersViewModel,
    playerPosition: Int
) {
    val player = sharedListOfPlayersViewModel.getPlayersList().get(playerPosition)
    Surface {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            HeaderText(text = "Name: " + player.firstName + " " + player.lastName)
            DefaultVerticalSpacer()
            ViewItemMediumTextRow("Position: ${player.position}")
            ViewItemMediumTextRow("Height : ${player.height}")
            ViewItemMediumTextRow("Weight: ${player.weight}")
            ViewItemMediumTextRow("Jersey Number: ${player.jerseyNumber}")
            ViewItemMediumTextRow("College: ${player.college}")
            ViewItemMediumTextRow("Country: ${player.country}")
            ViewItemMediumTextRow("Draft Year: ${player.draftYear}")
            ViewItemMediumTextRow("Draft Round: ${player.draftRound}")
            ViewItemMediumTextRow("Draft Number: ${player.draftNumber}")
            DefaultVerticalSpacer()
            Button(onClick = {
                navController.navigate(
                    Screens.ScreenClubDetails.withArgs(
                        playerPosition.toString()
                    )
                )
            }) {
                Text(text = "Team Info")
            }
        }
    }
}
