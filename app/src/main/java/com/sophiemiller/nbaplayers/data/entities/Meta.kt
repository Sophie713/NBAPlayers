package com.sophiemiller.nbaplayers.data.entities

import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("next_cursor")
    val nextCursor: Int,
    @SerializedName("per_page")
    val perPage: Int
)