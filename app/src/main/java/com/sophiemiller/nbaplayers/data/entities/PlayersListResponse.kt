package com.sophiemiller.nbaplayers.data.entities

import com.google.gson.annotations.SerializedName

/**
 * data class PlayersListResponse - list of players with all the data
 *
 * @property data
 * @property meta
 */
data class PlayersListResponse(
    @SerializedName("data")
    val data: List<Player?>? = null,
    @SerializedName("meta")
    val meta : Meta? = null
) {
    override fun toString(): String {
        return buildString {
            data?.forEach { player: Player? ->
                append(player.toString())
            }
        }
    }
}