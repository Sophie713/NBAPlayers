package com.sophiemiller.nbaplayers.domain.usecases

import com.sophiemiller.nbaplayers.data.entities.PlayersListResponse
import com.sophiemiller.nbaplayers.domain.repositories.PlayersRepository
import com.sophiemiller.nbaplayers.data.constants.RESULTS_PER_PAGE
import retrofit2.Response
import javax.inject.Inject

/**
 * usecase to download extra rows
 * number of players downloaded set in Constants -> RESULTS_PER_PAGE
 *
 * @property playersRepository
 */
class UseCaseGetMorePlayers@Inject constructor(val playersRepository: PlayersRepository) {

    suspend fun getNextPageOfPlayers(currentListItemCount: Int) : Response<PlayersListResponse> {
        val nextPageNumber = (currentListItemCount/ RESULTS_PER_PAGE).toInt()
       return playersRepository.getPlayers(nextPageNumber)
    }
}