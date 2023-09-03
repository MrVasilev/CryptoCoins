package com.neverland.cryptocoins

import com.neverland.cryptocoins.data.model.CoinDetailsResponse
import com.neverland.cryptocoins.data.model.CoinResponse
import com.neverland.cryptocoins.data.model.LinksResponse
import com.neverland.cryptocoins.data.model.ParentResponse
import com.neverland.cryptocoins.data.model.TagResponse
import com.neverland.cryptocoins.data.model.TeamMemberResponse
import com.neverland.cryptocoins.data.model.WhitePaperResponse
import com.neverland.cryptocoins.domain.model.Coin
import com.neverland.cryptocoins.domain.model.CoinDetails
import com.neverland.cryptocoins.domain.model.Links
import com.neverland.cryptocoins.domain.model.Parent
import com.neverland.cryptocoins.domain.model.Tag
import com.neverland.cryptocoins.domain.model.TeamMember
import com.neverland.cryptocoins.domain.model.WhitePaper

private const val ID = "ID"
private const val NAME = "NAME"
private const val DESCRIPTION = "DESCRIPTION"
private const val MESSAGE = "MESSAGE"
private const val POSITION = "POSITION"
private const val SYMBOL = "SYMBOL"
private const val TYPE = "TYPE"
private const val LINK = "LINK"
private const val THUMBNAIL = "THUMBNAIL"
private const val RANK = 1
private const val COIN_COUNTER = 1
private const val ICO_COUNTER = 1
private val explorer = listOf("EXP", "LORER")
private val facebook = listOf("FACE", "BOOK")
private val reddit = listOf("RED", "DIT")
private val sourceCode = listOf("SOURCE", "CODE")
private val website = listOf("WEB", "SITE")
private val youtube = listOf("YOU", "TUBE")

object DataGenerator {

    fun generateCoinResponse(id: String = ID, isNew: Boolean = false, isActive: Boolean = false) =
        CoinResponse(
            id = id,
            name = NAME,
            symbol = SYMBOL,
            rank = RANK,
            isNew = isNew,
            isActive = isActive,
            type = TYPE
        )

    fun generateCoin(id: String = ID, isNew: Boolean = false, isActive: Boolean = false) =
        Coin(
            id = id,
            name = NAME,
            symbol = SYMBOL,
            rank = RANK,
            isNew = isNew,
            isActive = isActive,
            type = TYPE
        )

    fun generateCoinDetailsResponse(
        parentResponse: ParentResponse,
        linksResponse: LinksResponse,
        whitePaperResponse: WhitePaperResponse,
        tagResponse: TagResponse,
        teamResponse: TeamMemberResponse,
        id: String = ID,
        name: String = NAME,
        description: String = DESCRIPTION,
        message: String = MESSAGE,
        symbol: String = SYMBOL,
        type: String = TYPE,
        rank: Int = RANK
    ) = CoinDetailsResponse(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        isNew = false,
        isActive = false,
        type = type,
        contract = "",
        description = description,
        logo = "",
        message = message,
        parent = parentResponse,
        developmentStatus = "",
        hardwareWallet = false,
        hashAlgorithm = "",
        links = linksResponse,
        isOpenSource = false,
        orgStructure = "",
        platform = "",
        proofType = "",
        tags = listOf(tagResponse),
        team = listOf(teamResponse),
        whitePaper = whitePaperResponse,
        startedAt = "",
        firstDataAt = "",
        lastDataAt = ""
    )

    fun generateCoinDetails(
        parent: Parent,
        links: Links,
        whitePaper: WhitePaper,
        tag: Tag,
        team: TeamMember,
        id: String = ID,
        name: String = NAME,
        description: String = DESCRIPTION,
        message: String = MESSAGE,
        symbol: String = SYMBOL,
        type: String = TYPE,
        rank: Int = RANK
    ) = CoinDetails(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        isNew = false,
        isActive = false,
        type = type,
        contract = "",
        description = description,
        logo = "",
        message = message,
        parent = parent,
        developmentStatus = "",
        hardwareWallet = false,
        hashAlgorithm = "",
        links = links,
        isOpenSource = false,
        orgStructure = "",
        platform = "",
        proofType = "",
        tags = listOf(tag),
        team = listOf(team),
        whitePaper = whitePaper,
        startedAt = "",
        firstDataAt = "",
        lastDataAt = ""
    )

    fun generateTeamMemberResponse(id: String = ID) = TeamMemberResponse(
        id = id,
        name = NAME,
        position = POSITION
    )

    fun generateTeamMember(id: String = ID, name: String = NAME, position: String = POSITION) =
        TeamMember(
            id = id,
            name = name,
            position = position
        )

    fun generateTagResponse(id: String = ID) = TagResponse(
        id = id,
        name = NAME,
        coinCounter = COIN_COUNTER,
        icoCounter = ICO_COUNTER
    )

    fun generateTag(
        id: String = ID,
        name: String = NAME,
        coinCounter: Int = COIN_COUNTER,
        icoCounter: Int = ICO_COUNTER
    ) = Tag(
        id = id,
        name = name,
        coinCounter = coinCounter,
        icoCounter = icoCounter
    )

    fun generateLinksResponse() = LinksResponse(
        explorer = explorer,
        facebook = facebook,
        reddit = reddit,
        sourceCode = sourceCode,
        website = website,
        youtube = youtube
    )

    fun generateLinks() = Links(
        explorer = explorer,
        facebook = facebook,
        reddit = reddit,
        sourceCode = sourceCode,
        website = website,
        youtube = youtube
    )

    fun generateParentResponse() = ParentResponse(id = ID, name = NAME, symbol = SYMBOL)

    fun generateParent() = Parent(id = ID, name = NAME, symbol = SYMBOL)

    fun generateWhitePaperResponse() = WhitePaperResponse(link = LINK, thumbnail = THUMBNAIL)

    fun generateWhitePaper() = WhitePaper(link = LINK, thumbnail = THUMBNAIL)

}