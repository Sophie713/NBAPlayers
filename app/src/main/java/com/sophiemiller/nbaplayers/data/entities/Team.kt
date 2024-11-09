package com.sophiemiller.nbaplayers.data.entities

import com.google.gson.annotations.SerializedName

/**
 * data class Team - info about the team
 *
 * @property id
 * @property conference
 * @property division
 * @property city
 * @property name
 * @property fullName
 * @property abbreviation
 */
data class Team(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("conference")
    val conference: String? = null,
    @SerializedName("division")
    val division: String? = null,
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("full_name")
    val fullName: String? = null,
    @SerializedName("abbreviation")
    val abbreviation: String? = null
) {
    override fun toString(): String {
        return " Team: \n" +
                "     id: $id,\n" +
                "     conference: $conference,\n" +
                "     division: $division,\n" +
                "     city: $division,\n" +
                "     name: $name,\n" +
                "     fullName: $fullName,\n" +
                "     abbreviation: $abbreviation"
    }
}
