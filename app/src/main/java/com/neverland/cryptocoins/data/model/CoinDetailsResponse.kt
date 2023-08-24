package com.neverland.cryptocoins.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CoinDetailsResponse(
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
    val type: String? = null,

    @Json(name = "contract")
    val contract: String? = null,

    @Json(name = "description")
    val description: String? = null,

    @Json(name = "logo")
    val logo: String? = null,

    @Json(name = "message")
    val message: String? = null,

    @Json(name = "parent")
    val parent: ParentResponse? = null,

    @Json(name = "development_status")
    val developmentStatus: String? = null,

    @Json(name = "hardware_wallet")
    val hardwareWallet: Boolean? = null,

    @Json(name = "hash_algorithm")
    val hashAlgorithm: String? = null,

    @Json(name = "links")
    val links: LinksResponse? = null,

    @Json(name = "open_source")
    val isOpenSource: Boolean? = null,

    @Json(name = "org_structure")
    val orgStructure: String? = null,

    @Json(name = "platform")
    val platform: String? = null,

    @Json(name = "proof_type")
    val proofType: String? = null,

    @Json(name = "tags")
    val tags: List<TagResponse>? = null,

    @Json(name = "team")
    val team: List<TeamMemberResponse>? = null,

    @Json(name = "whitepaper")
    val whitePaper: WhitePaperResponse? = null,

    @Json(name = "started_at")
    val startedAt: String? = null,

    @Json(name = "first_data_at")
    val firstDataAt: String? = null,

    @Json(name = "last_data_at")
    val lastDataAt: String? = null
)