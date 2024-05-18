package com.sophiemiller.nbaplayers.presentation.ui.compose

import androidx.compose.foundation.layout.Column
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
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.ViewItemPlayerDetailsRow
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.navigation.Screens
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.viewModels.ListOfPlayersViewModel

@Composable
fun ScreenPlayerDetails(
    navController: NavHostController,
    sharedListOfPlayersViewModel: ListOfPlayersViewModel,
    playerPosition: Int
) {
    val player = sharedListOfPlayersViewModel.getPlayersList().get(playerPosition)
    Surface(modifier = Modifier.padding(16.dp)) {
        Column {
            HeaderText(text = "Name: " + player.firstName + " " + player.lastName)
            DefaultVerticalSpacer()
            ViewItemPlayerDetailsRow("Position: ${player.position}")
            ViewItemPlayerDetailsRow("Height : ${player.height}")
            ViewItemPlayerDetailsRow("Weight: ${player.weight}")
            ViewItemPlayerDetailsRow("Jersey Number: ${player.jerseyNumber}")
            ViewItemPlayerDetailsRow("College: ${player.college}")
            ViewItemPlayerDetailsRow("Country: ${player.country}")
            ViewItemPlayerDetailsRow("Draft Year: ${player.draftYear}")
            ViewItemPlayerDetailsRow("Draft Round: ${player.draftRound}")
            ViewItemPlayerDetailsRow("Draft Number: ${player.draftNumber}")
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
