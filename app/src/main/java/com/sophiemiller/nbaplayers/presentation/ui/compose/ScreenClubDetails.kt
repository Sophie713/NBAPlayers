package com.sophiemiller.nbaplayers.presentation.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.DefaultSpacer
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.HeaderText
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.viewModels.ListOfPlayersViewModel

@Composable
fun ScreenClubDetails(
    sharedListOfPlayersViewModel: ListOfPlayersViewModel,
    navController: NavHostController,
    playerPosition: Int
) {


    val team = sharedListOfPlayersViewModel.getPlayersList().get(playerPosition).team
    Surface(modifier = Modifier.padding(16.dp)) {
        Column {
            HeaderText(text = "Team Name: ${team.fullName}")
            DefaultSpacer()
        }
    }
}