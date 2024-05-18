package com.sophiemiller.nbaplayers.domain.repositories


import com.sophiemiller.nbaplayers.data.entities.PlayersListResponse
import com.sophiemiller.nbaplayers.domain.apiInterfaces.PlayersApiService
import retrofit2.Response
import javax.inject.Inject

class PlayersRepository @Inject constructor(val playersApiService: PlayersApiService) {

    suspend fun getPlayers(pageNumber: Int): Response<PlayersListResponse> {
        return playersApiService.getListOfPlayers(pageNumber = pageNumber)
    }
}