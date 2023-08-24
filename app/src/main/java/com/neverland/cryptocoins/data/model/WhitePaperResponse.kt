package com.neverland.cryptocoins.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WhitePaperResponse(
    @Json(name = "link")
    val link: String? = null,

    @Json(name = "thumbnail")
    val thumbnail: String? = null
)