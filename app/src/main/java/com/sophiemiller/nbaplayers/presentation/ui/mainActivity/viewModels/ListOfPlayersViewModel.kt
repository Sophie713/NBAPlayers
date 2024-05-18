package com.sophiemiller.nbaplayers.presentation.ui.mainActivity.viewModels

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sophiemiller.nbaplayers.data.entities.Player
import com.sophiemiller.nbaplayers.domain.repositories.PlayersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ListOfPlayersViewModel @Inject constructor(val playersRepository: PlayersRepository) :
    ViewModel() {

    private val players = mutableStateListOf<Player>()

    val handler = CoroutineExceptionHandler { _, exception ->
        Log.e("xyz", exception.message.toString())
    }

    fun getPlayersList(): SnapshotStateList<Player> {
        return players
    }

    fun loadMoreItems() {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }


    init {
        viewModelScope.launch(Dispatchers.IO) {
            val response = playersRepository.getAllPlayers()
            withContext(Dispatchers.Main + handler) {
                if (response.isSuccessful) {
                    //players.clear()
                    response.body()?.data?.let { players.addAll(it) }
                } else {
                    //todo xyz show error
                }

            }
        }
    }

}