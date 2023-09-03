package com.neverland.cryptocoins.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoinResponse(
    @Json(name = "id")
    val id: String? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "symbol")
    val symbol: String? = null,

    @Json(name = "rank")
    val rank: Int? = null,

    @Json(name = "is_new")
    val isNew: Boolean? = null,

    @Json(name = "is_active")
    val isActive: Boolean? = null,

    @Json(name = "type")
    val type: String? = null
)