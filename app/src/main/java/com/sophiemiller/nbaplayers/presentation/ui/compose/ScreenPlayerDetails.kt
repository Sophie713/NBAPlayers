package com.sophiemiller.nbaplayers.presentation.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.DefaultSpacer
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.HeaderText
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
            DefaultSpacer()
            Text("Position: ${player.position}")
            Text("Height : ${player.height}")
            Text("Weight: ${player.weight}")
            Text("Jersey Number: ${player.jerseyNumber}")
            Text("College: ${player.college}")
            Text("Country: ${player.country}")
            Text("Draft Year: ${player.draftYear}")
            Text("Draft Round: ${player.draftRound}")
            Text("Draft Number: ${player.draftNumber}")
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
