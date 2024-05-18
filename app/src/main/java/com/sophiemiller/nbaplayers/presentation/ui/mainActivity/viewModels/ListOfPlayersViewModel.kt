package com.sophiemiller.nbaplayers.presentation.ui.mainActivity.viewModels

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sophiemiller.nbaplayers.data.entities.Player
import com.sophiemiller.nbaplayers.domain.usecases.UseCaseGetMorePlayers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ListOfPlayersViewModel @Inject constructor(val useCaseGetMorePlayers: UseCaseGetMorePlayers) :
    ViewModel() {

    private val players: SnapshotStateList<Player> = mutableStateListOf<Player>()

    val handler = CoroutineExceptionHandler { _, exception ->
        Log.e("xyz", exception.message.toString())
    }

    fun getPlayersList(): SnapshotStateList<Player> {
        return players
    }

    fun loadMoreItems() {
        viewModelScope.launch(Dispatchers.IO) { //todo xyz show loading
            val response = useCaseGetMorePlayers.getNextPageOfPlayers(players.size)
            withContext(Dispatchers.Main + handler) {
                if (response.isSuccessful) {
                    response.body()?.data?.let { players.addAll(it) }
                } else {
                    //todo xyz show error
                }

            }
        }
    }

}