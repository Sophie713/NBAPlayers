package com.sophiemiller.nbaplayers.presentation.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.navigation.NavManager
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.navigation.Screens
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.viewModels.PlayersAppViewModel

/**
 * composable
 * Main Activity compose navigation through all the app screens
 *
 * @param sharedPlayersAppViewModel
 */
@Composable
fun MainActivityContent(sharedPlayersAppViewModel: PlayersAppViewModel) {
    val navController = rememberNavController()
    sharedPlayersAppViewModel.setNavManager(NavManager(navController))
    /**
     * edge to edge padding
     */
    Box(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
    ) {
        NavHost(navController, startDestination = Screens.ScreenListOfPlayers.route) {
            /**
             * Screen that shows list of the players
             */
            composable(Screens.ScreenListOfPlayers.route) {
                ScreenListOfPlayers(
                    sharedPlayersAppViewModel = sharedPlayersAppViewModel,
                )
            }
            /**
             * screen that shows player details
             */
            composable(Screens.ScreenPlayerDetails.route) {
                ScreenPlayerDetails(
                    sharedPlayersAppViewModel = sharedPlayersAppViewModel,
                )
            }
            /**
             * screen that shows club details
             */
            composable(
                Screens.ScreenClubDetails.route
            ) {
                ScreenTeamDetails(
                    sharedPlayersAppViewModel = sharedPlayersAppViewModel,
                )
            }
        }
    }
}