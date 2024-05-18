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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.DefaultVerticalSpacer
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.Toolbar
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
    val player = sharedListOfPlayersViewModel.getPlayersList()[playerPosition]
    val scrollState = rememberScrollState()
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            //Toolbar
            Toolbar(title = "${(player.firstName ?: "")} ${(player.lastName ?: "")}") { navController.popBackStack() }
            DefaultVerticalSpacer()
            player.position?.let {
                ViewItemMediumTextRow("Position: $it")
            }
            player.height?.let {
                ViewItemMediumTextRow("Height : $it")
            }
            player.weight?.let {
                ViewItemMediumTextRow("Weight: $it")
            }
            player.jerseyNumber?.let {
                ViewItemMediumTextRow("Jersey Number: $it")
            }
            player.college?.let {
                ViewItemMediumTextRow("College: $it")
            }
            player.country?.let {
                ViewItemMediumTextRow("Country: $it")
            }
            player.draftYear?.let {
                ViewItemMediumTextRow("Draft Year: $it")
            }
            player.draftRound?.let {
                ViewItemMediumTextRow("Draft Round: $it")
            }
            player.draftNumber?.let {
                ViewItemMediumTextRow("Draft Number: $it")
            }
            DefaultVerticalSpacer()
            player.team?.let { team ->
                if (team.fullName != null) {
                    Button(onClick = {
                        navController.navigate(
                            Screens.ScreenClubDetails.withArgs(
                                playerPosition.toString()
                            )
                        )
                    }, modifier = Modifier.padding(horizontal = 16.dp)) {
                        Text(text = "Team Info")
                    }
                }
            }
        }
    }
}
