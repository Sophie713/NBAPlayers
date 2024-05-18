package com.sophiemiller.nbaplayers.presentation.ui.mainActivity.navigation

import androidx.navigation.NavArgs
import com.sophiemiller.nbaplayers.presentation.constants.Routes

sealed class Screens(val route: String) {
    object ScreenListOfPlayers : Screens(Routes.LIST_OF_PLAYERS)
    object ScreenPlayerDetails : Screens(Routes.PLAYER_DETAIL)
    object ScreenClubDetails : Screens(Routes.CLUB_DETAILS)

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}