package com.sophiemiller.nbaplayers.domain.apiInterfaces

import com.sophiemiller.nbaplayers.data.entities.PlayersListResponse
import com.sophiemiller.nbaplayers.presentation.constants.RESULTS_PER_PAGE
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PlayersApiService {

    @GET("v1/players")
    suspend fun getListOfPlayers(@Query("cursor") pageNumber: Int, @Query("per_page") resultsPerPage: Int = RESULTS_PER_PAGE) : Response<PlayersListResponse>
}