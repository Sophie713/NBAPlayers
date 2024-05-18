package com.sophiemiller.nbaplayers.presentation.ui.mainActivity.viewModels

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sophiemiller.nbaplayers.data.constants.LOG_TAG
import com.sophiemiller.nbaplayers.data.entities.Player
import com.sophiemiller.nbaplayers.domain.usecases.UseCaseGetMorePlayers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * shared viewmodel that keeps all the downloaded data - shared across all screens
 *
 * @property useCaseGetMorePlayers
 */
@HiltViewModel
class ListOfPlayersViewModel @Inject constructor(private val useCaseGetMorePlayers: UseCaseGetMorePlayers) :
    ViewModel() {

    private val players: SnapshotStateList<Player> = mutableStateListOf()

    /**
     * error handler for coroutines
     */
    private val handler = CoroutineExceptionHandler { _, exception ->
        Log.e(LOG_TAG, exception.message.toString())
    }

    /**
     * returns list of currently downloaded players as SnapshotStateList
     *
     * @return
     */
    fun getPlayersList(): SnapshotStateList<Player> {
        return players
    }

    /**
     * load more into the list of players
     * number downloaded set in Constants -> RESULTS_PER_PAGE
     *
     */
    fun loadMoreItems() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = useCaseGetMorePlayers.getNextPageOfPlayers(players.size)
            withContext(Dispatchers.Main + handler) {
                if (response.isSuccessful) {
                    response.body()?.data?.let { players.addAll(it) }
                } else {
                    Log.e(LOG_TAG, "getNextPageOfPlayers: ${response.errorBody().toString()}")
                }

            }
        }
    }

}