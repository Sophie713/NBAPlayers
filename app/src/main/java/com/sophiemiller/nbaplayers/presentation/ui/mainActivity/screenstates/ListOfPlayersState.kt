package com.sophiemiller.nbaplayers.presentation.ui.mainActivity.screenstates

import com.sophiemiller.nbaplayers.data.entities.Player

data class ListOfPlayersState(
    val playersList: MutableList<Player?> = mutableListOf(),
    val showErrorDialog: Boolean = false,
    val isLoading: Boolean = false,
)