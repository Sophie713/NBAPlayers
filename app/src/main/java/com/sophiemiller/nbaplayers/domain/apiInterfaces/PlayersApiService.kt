package com.sophiemiller.nbaplayers.domain.apiInterfaces

import com.sophiemiller.nbaplayers.data.entities.PlayersListResponse
import retrofit2.Response
import retrofit2.http.GET

interface PlayersApiService {

    @GET("v1/players")
    suspend fun getListOfPlayers() : Response<PlayersListResponse>
}