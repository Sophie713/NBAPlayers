package com.sophiemiller.nbaplayers.data.entities

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("id")
    val id: Int,
    @SerializedName("conference")
    val conference: String,
    @SerializedName("division")
    val division: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("abbreviation")
    val abbreviation: String
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
