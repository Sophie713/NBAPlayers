package com.sophiemiller.nbaplayers.presentation.ui.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sophiemiller.nbaplayers.presentation.constants.Arguments
import com.sophiemiller.nbaplayers.presentation.constants.Routes
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.navigation.Screens
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.viewModels.ListOfPlayersViewModel

@Composable
fun MainActivityContent(sharedListOfPlayersViewModel: ListOfPlayersViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screens.ScreenListOfPlayers.route) {
        /**
         * Screen that shows list of the players
         */
        composable(Screens.ScreenListOfPlayers.route) {
            ScreenListOfPlayers(
                sharedListOfPlayersViewModel = sharedListOfPlayersViewModel,
                navController = navController
            )
        }
        /**
         * screen that shows player details
         */
        composable(Screens.ScreenPlayerDetails.route + "/{${Arguments.PLAYER_POSITION}}",
            arguments = listOf(
                navArgument(name = Arguments.PLAYER_POSITION) {
                    type = NavType.IntType
                    nullable = false
                    defaultValue = 0
                }
            )) { entry ->
            val position = entry.arguments?.getInt(Arguments.PLAYER_POSITION) ?: 0
            ScreenPlayerDetails(
                sharedListOfPlayersViewModel = sharedListOfPlayersViewModel,
                navController = navController,
                playerPosition = position
            )
        }
        /**
         * screen that shows club details
         */
        composable(
            Screens.ScreenClubDetails.route + "/{${Arguments.PLAYER_POSITION}}", arguments = listOf(
                navArgument(name = Arguments.PLAYER_POSITION) {
                    type = NavType.IntType
                    nullable = false
                    defaultValue = 0
                })
        ) { entry ->
            val position = entry.arguments?.getInt(Arguments.PLAYER_POSITION) ?: 0
            ScreenClubDetails(
                sharedListOfPlayersViewModel = sharedListOfPlayersViewModel,
                navController = navController,
                playerPosition = position
            )
        }
    }
}