package com.sophiemiller.nbaplayers.data.entities

import com.google.gson.annotations.SerializedName

/**
 * data class Player - info about the player, includes team info
 *
 * @property id
 * @property firstName
 * @property lastName
 * @property position
 * @property height
 * @property weight
 * @property jerseyNumber
 * @property college
 * @property country
 * @property draftYear
 * @property draftRound
 * @property draftNumber
 * @property team
 */
data class Player(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("first_name")
    val firstName: String? = null,
    @SerializedName("last_name")
    val lastName: String? = null,
    @SerializedName("position")
    val position: String? = null,
    @SerializedName("height")
    val height: String? = null,
    @SerializedName("weight")
    val weight: String? = null,
    @SerializedName("jersey_number")
    val jerseyNumber: String? = null,
    @SerializedName("college")
    val college: String? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("draft_year")
    val draftYear: Int? = null,
    @SerializedName("draft_round")
    val draftRound: Int? = null,
    @SerializedName("draft_number")
    val draftNumber: Int? = null,
    @SerializedName("team")
    val team: Team? = null
) {
    override fun toString(): String {
        return "Player: \n" +
                "                    id: $id,\n" +
                "                    firstName: $firstName,\n" +
                "                    lastName: $lastName,\n" +
                "                    position: $position,\n" +
                "                    height: $height,\n" +
                "                    weight: $weight,\n" +
                "                    jerseyNumber: $jerseyNumber,\n" +
                "                    college: $college,\n" +
                "                    country: $country,\n" +
                "                    draftYear: $draftYear,\n" +
                "                    draftRound: $draftRound,\n" +
                "                    draftNumber: $draftNumber,\n" +
                "                    team: ${team.toString()}"
    }
}
