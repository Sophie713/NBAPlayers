package com.sophiemiller.nbaplayers.data.entities

import com.google.gson.annotations.SerializedName

/**
 * data class Meta - info about paging
 *
 * @property nextCursor
 * @property perPage
 */
data class Meta(
    @SerializedName("next_cursor")
    val nextCursor: Int? = null,
    @SerializedName("per_page")
    val perPage: Int? = null
)