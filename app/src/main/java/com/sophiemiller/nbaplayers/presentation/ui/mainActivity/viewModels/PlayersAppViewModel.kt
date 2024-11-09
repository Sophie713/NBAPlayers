package com.sophiemiller.nbaplayers.presentation.ui.mainActivity.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sophiemiller.nbaplayers.data.constants.LOG_TAG
import com.sophiemiller.nbaplayers.data.entities.Player
import com.sophiemiller.nbaplayers.data.entities.Team
import com.sophiemiller.nbaplayers.domain.usecases.UseCaseGetMorePlayers
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.navigation.NavManager
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.navigation.Screens
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.screenstates.ListOfPlayersState
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.screenstates.PlayerDetailState
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.screenstates.TeamDetailState
import com.sophiemiller.nbaplayers.presentation.ui.mainActivity.viewModels.viewModelEvents.SharedViewModelEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * shared viewmodel that keeps all the downloaded data - shared across all screens
 *
 * @property useCaseGetMorePlayers
 */
@HiltViewModel
class PlayersAppViewModel @Inject constructor(private val useCaseGetMorePlayers: UseCaseGetMorePlayers) :
    ViewModel() {

        //manager for navigation
    private var navManager: NavManager? = null

    private val _listOfPlayersState = MutableStateFlow(ListOfPlayersState())
    val listOfPlayersState: StateFlow<ListOfPlayersState> = _listOfPlayersState


    private val _playerDetailState = MutableStateFlow(PlayerDetailState(Player()))
    val playerDetailState: StateFlow<PlayerDetailState> = _playerDetailState

    private val _playerTeamState = MutableStateFlow(TeamDetailState(Team()))
    val playerTeamState: StateFlow<TeamDetailState> = _playerTeamState

    /**
     * error handler for load list coroutine
     */
    private val loadListHandler = CoroutineExceptionHandler { _, exception ->
        viewModelScope.launch (Dispatchers.Main){
            Log.e(LOG_TAG, exception.message.toString())
            _listOfPlayersState.value = listOfPlayersState.value.copy(
                isLoading = false,
                showErrorDialog = true
            )
        }
    }

    /**
     * handle all available events
     * don't use else branch to insure all events will have to be implemented
     *
     * @param event
     */
    fun onEvent(event: SharedViewModelEvents) {
        when (event) {
            is SharedViewModelEvents.OnShowListLoading -> {
                _listOfPlayersState.value = listOfPlayersState.value.copy(
                    isLoading = event.isShow,
                )
            }

            SharedViewModelEvents.OnLoadMorePlayers -> {
                _listOfPlayersState.value = listOfPlayersState.value.copy(
                    isLoading = true,
                )
                loadMoreItems()
            }

            is SharedViewModelEvents.OnPlayerItemClicked -> {
                _playerDetailState.value = playerDetailState.value.copy(
                    player = event.player
                )
                navManager?.navigate(Screens.ScreenPlayerDetails)
            }

            is SharedViewModelEvents.OnTeamDetailsClicked -> {
                _playerTeamState.value = playerTeamState.value.copy(
                    team = event.team
                )
                navManager?.navigate(
                    Screens.ScreenClubDetails
                )
            }

            SharedViewModelEvents.OnNavigateBack -> {
                navManager?.popBackStack()
            }

            SharedViewModelEvents.OnDismissErrorDialog -> {
                _listOfPlayersState.value = listOfPlayersState.value.copy(
                    isLoading = false,
                    showErrorDialog = false
                )
            }
        }
    }

    /**
     * set navigation manager
     *
     * @param navManager
     */
    fun setNavManager(navManager: NavManager) {
        this.navManager = navManager
    }

    /**
     * load more into the list of players
     * number downloaded set in Constants -> RESULTS_PER_PAGE
     *
     */
    fun loadMoreItems() {
        viewModelScope.launch(Dispatchers.IO + loadListHandler) {
            val response =
                useCaseGetMorePlayers.getNextPageOfPlayers(listOfPlayersState.value.playersList.size)
            withContext(Dispatchers.Main) {
                if (response?.isSuccessful == true) {
                    response.body()?.data?.let { listOfPlayers ->
                        val allPlayers = listOfPlayersState.value.playersList
                        allPlayers.addAll(listOfPlayers)
                        _listOfPlayersState.value = listOfPlayersState.value.copy(
                            playersList = allPlayers,
                            isLoading = false,
                            showErrorDialog = false
                        )
                    } ?: run {
                        _listOfPlayersState.value = listOfPlayersState.value.copy(
                            showErrorDialog = true,
                            isLoading = false,
                        )
                        Log.e(
                            LOG_TAG,
                            "getNextPageOfPlayers: Couldnt parse data: ${
                                response.body()?.toString()
                            }"
                        )
                    }
                } else {
                    _listOfPlayersState.value = listOfPlayersState.value.copy(
                        showErrorDialog = true,
                        isLoading = false
                    )
                    Log.e(LOG_TAG, "getNextPageOfPlayers: ${response?.errorBody().toString()}")
                }

            }
        }
    }

    init {
        onEvent(SharedViewModelEvents.OnLoadMorePlayers)
    }
}