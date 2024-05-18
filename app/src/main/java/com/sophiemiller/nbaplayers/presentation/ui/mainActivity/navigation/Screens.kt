package com.sophiemiller.nbaplayers.presentation.ui.mainActivity.navigation

import androidx.navigation.NavArgs
import com.sophiemiller.nbaplayers.data.constants.Routes

/**
 * sealed class to include all the screens and simplify adding args
 *
 * @property route - all routes defined in Constants.Routes object
 */
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