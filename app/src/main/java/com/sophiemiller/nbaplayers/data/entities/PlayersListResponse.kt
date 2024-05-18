package com.sophiemiller.nbaplayers.data.entities

import com.google.gson.annotations.SerializedName

data class PlayersListResponse(
    @SerializedName("data")
    val data: List<Player>,
    @SerializedName("meta")
    val meta : Meta?
) {
    override fun toString(): String {
        var stringList = ""
        data.forEach { player: Player ->
            stringList = stringList + "\n" + player.toString()
        }
        return stringList
    }
}