package com.neverland.cryptocoins.data.mapper

import com.neverland.cryptocoins.DataGenerator.generateCoinDetails
import com.neverland.cryptocoins.DataGenerator.generateCoinDetailsResponse
import com.neverland.cryptocoins.DataGenerator.generateLinks
import com.neverland.cryptocoins.DataGenerator.generateLinksResponse
import com.neverland.cryptocoins.DataGenerator.generateParent
import com.neverland.cryptocoins.DataGenerator.generateParentResponse
import com.neverland.cryptocoins.DataGenerator.generateTag
import com.neverland.cryptocoins.DataGenerator.generateTagResponse
import com.neverland.cryptocoins.DataGenerator.generateTeamMember
import com.neverland.cryptocoins.DataGenerator.generateTeamMemberResponse
import com.neverland.cryptocoins.DataGenerator.generateWhitePaper
import com.neverland.cryptocoins.DataGenerator.generateWhitePaperResponse
import com.neverland.cryptocoins.data.model.LinksResponse
import com.neverland.cryptocoins.data.model.ParentResponse
import com.neverland.cryptocoins.data.model.TagResponse
import com.neverland.cryptocoins.data.model.TeamMemberResponse
import com.neverland.cryptocoins.data.model.WhitePaperResponse
import com.neverland.cryptocoins.domain.model.Links
import com.neverland.cryptocoins.domain.model.Parent
import com.neverland.cryptocoins.domain.model.WhitePaper
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

class CoinDetailsMapperTest {

    private val linksMapper = mock<LinksMapper>()
    private val parentMapper = mock<ParentMapper>()
    private val tagMapper = mock<TagMapper>()
    private val teamMemberMapper = mock<TeamMemberMapper>()
    private val whitePaperMapper = mock<WhitePaperMapper>()

    private val tested =
        CoinDetailsMapper(linksMapper, parentMapper, tagMapper, teamMemberMapper, whitePaperMapper)

    @Test
    fun `mapToDomainModel with correct data should return correct mapped data`() {
        // given
        val linksResponse = generateLinksResponse()
        val links = generateLinks()
        val parentResponse = generateParentResponse()
        val parent = generateParent()
        val tagResponse = generateTagResponse()
        val tag = generateTag()
        val teamResponse = generateTeamMemberResponse()
        val team = generateTeamMember()
        val whitePaperResponse = generateWhitePaperResponse()
        val whitePaper = generateWhitePaper()
        val response = generateCoinDetailsResponse(
            parentResponse = parentResponse,
            linksResponse = linksResponse,
            whitePaperResponse = whitePaperResponse,
            tagResponse = tagResponse,
            teamResponse = teamResponse
        )
        val expected = generateCoinDetails(
            parent = parent,
            links = links,
            whitePaper = whitePaper,
            tag = tag,
            team = team
        )

        whenever(linksMapper.mapToDomainModel(linksResponse)).thenReturn(links)
        whenever(parentMapper.mapToDomainModel(parentResponse)).thenReturn(parent)
        whenever(whitePaperMapper.mapToDomainModel(whitePaperResponse)).thenReturn(whitePaper)
        whenever(tagMapper.mapToDomainModelList(listOf(tagResponse))).thenReturn(listOf(tag))
        whenever(teamMemberMapper.mapToDomainModelList(listOf(teamResponse))).thenReturn(listOf(team))

        // when
        val actual = tested.mapToDomainModel(response = response)

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `mapToDomainModel with null data should return empty data`() {
        // given
        val linksResponse = LinksResponse()
        val links = Links(
            explorer = emptyList(),
            facebook = emptyList(),
            reddit = emptyList(),
            sourceCode = emptyList(),
            website = emptyList(),
            youtube = emptyList()
        )
        val parentResponse = ParentResponse()
        val parent = Parent(id = "", name = "", symbol = "")
        val tagResponse = TagResponse()
        val tag = generateTag(id = "", name = "", coinCounter = -1, icoCounter = -1)
        val teamResponse = TeamMemberResponse()
        val team = generateTeamMember(id = "", name = "", position = "")
        val whitePaperResponse = WhitePaperResponse()
        val whitePaper = WhitePaper(link = "", thumbnail = "")
        val response = generateCoinDetailsResponse(
            parentResponse = parentResponse,
            linksResponse = linksResponse,
            whitePaperResponse = whitePaperResponse,
            tagResponse = tagResponse,
            teamResponse = teamResponse,
            id = "",
            name = "",
            description = "",
            message = "",
            symbol = "",
            type = "",
            rank = -1
        )
        val expected = generateCoinDetails(
            parent = parent,
            links = links,
            whitePaper = whitePaper,
            tag = tag,
            team = team,
            id = "",
            name = "",
            description = "",
            message = "",
            symbol = "",
            type = "",
            rank = -1
        )

        whenever(linksMapper.mapToDomainModel(linksResponse)).thenReturn(links)
        whenever(parentMapper.mapToDomainModel(parentResponse)).thenReturn(parent)
        whenever(whitePaperMapper.mapToDomainModel(whitePaperResponse)).thenReturn(whitePaper)
        whenever(tagMapper.mapToDomainModelList(listOf(tagResponse))).thenReturn(listOf(tag))
        whenever(teamMemberMapper.mapToDomainModelList(listOf(teamResponse))).thenReturn(listOf(team))

        // when
        val actual = tested.mapToDomainModel(response = response)

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `mapToDomainModel with null response should return empty data`() {
        // given
        val links = Links(
            explorer = emptyList(),
            facebook = emptyList(),
            reddit = emptyList(),
            sourceCode = emptyList(),
            website = emptyList(),
            youtube = emptyList()
        )
        val parent = Parent(id = "", name = "", symbol = "")
        val tag = generateTag(id = "", name = "", coinCounter = -1, icoCounter = -1)
        val team = generateTeamMember(id = "", name = "", position = "")
        val whitePaper = WhitePaper(link = "", thumbnail = "")
        val expected = generateCoinDetails(
            parent = parent,
            links = links,
            whitePaper = whitePaper,
            tag = tag,
            team = team,
            id = "",
            name = "",
            description = "",
            message = "",
            symbol = "",
            type = "",
            rank = -1
        )

        whenever(linksMapper.mapToDomainModel(null)).thenReturn(links)
        whenever(parentMapper.mapToDomainModel(null)).thenReturn(parent)
        whenever(whitePaperMapper.mapToDomainModel(null)).thenReturn(whitePaper)
        whenever(tagMapper.mapToDomainModelList(null)).thenReturn(listOf(tag))
        whenever(teamMemberMapper.mapToDomainModelList(null)).thenReturn(listOf(team))

        // when
        val actual = tested.mapToDomainModel(response = null)

        // then
        assertEquals(expected, actual)
    }
}