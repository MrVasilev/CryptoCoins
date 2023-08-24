package com.neverland.cryptocoins.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TeamMemberResponse(
    @Json(name = "id")
    val id: String? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "position")
    val position: String? = null
)