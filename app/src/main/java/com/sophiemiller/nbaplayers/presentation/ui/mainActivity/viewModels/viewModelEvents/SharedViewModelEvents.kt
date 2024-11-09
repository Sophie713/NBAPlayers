package com.sophiemiller.nbaplayers.presentation.ui.mainActivity.viewModels.viewModelEvents

import com.sophiemiller.nbaplayers.data.entities.Player
import com.sophiemiller.nbaplayers.data.entities.Team

sealed class SharedViewModelEvents {
    /**
     * indicate the UI is loading players
     *
     * @property isShow
     */
    data class OnShowListLoading(val isShow: Boolean) : SharedViewModelEvents()

    /**
     * triggered when user tries to open player detail
     *
     * @property player
     */
    data class OnPlayerItemClicked(val player: Player) : SharedViewModelEvents()

    /**
     * load more players to the liast
     *
     * @constructor Create empty On load more players
     */
    data object OnLoadMorePlayers : SharedViewModelEvents()

    /**
     * triggered when user tries to open team detail
     *
     * @property team
     */
    data class OnTeamDetailsClicked(val team: Team) : SharedViewModelEvents()

    /**
     * triggered when user tries to navigate back
     *
     */
    data object OnNavigateBack : SharedViewModelEvents()

    /**
     * On dismiss error dialog when loading players
     *
     * @constructor Create empty On dismiss error dialog
     */
    data object OnDismissErrorDialog: SharedViewModelEvents()

}