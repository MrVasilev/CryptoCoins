package com.neverland.cryptocoins.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LinksResponse(
    @Json(name = "explorer")
    val explorer: List<String>? = null,

    @Json(name = "facebook")
    val facebook: List<String>? = null,

    @Json(name = "medium")
    val medium: Any? = null,

    @Json(name = "reddit")
    val reddit: List<String>? = null,

    @Json(name = "source_code")
    val sourceCode: List<String>? = null,

    @Json(name = "website")
    val website: List<String>? = null,

    @Json(name = "youtube")
    val youtube: List<String>? = null
)