package com.sophiemiller.nbaplayers.presentation.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.DefaultVerticalSpacer
import com.sophiemiller.nbaplayers.presentation.ui.compose.views.Toolbar
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
    playerPosition: Int,
    navController: NavHostController
) {
    val team = sharedListOfPlayersViewModel.getPlayersList()[playerPosition].team
    val scrollState = rememberScrollState()
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            //Toolbar
            // we checked null before
            Toolbar(title = "${team!!.fullName}") { navController.popBackStack() }
            DefaultVerticalSpacer()
            //check info isnt null and add info
            team.abbreviation?.let {
                ViewItemMediumTextRow("Abbreviation: $it")
            }
            team.conference?.let {
                ViewItemMediumTextRow("Conference: $it")
            }
            team.division?.let {
                ViewItemMediumTextRow("Division: $it")
            }
            team.city?.let {
                ViewItemMediumTextRow("City: $it")
            }
        }
    }
}