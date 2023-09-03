package com.neverland.cryptocoins.data.mapper

import com.neverland.cryptocoins.DataGenerator.generateTeamMember
import com.neverland.cryptocoins.DataGenerator.generateTeamMemberResponse
import com.neverland.cryptocoins.data.model.TeamMemberResponse
import com.neverland.cryptocoins.domain.model.TeamMember
import org.junit.Assert.assertEquals
import org.junit.Test

class TeamMemberMapperTest {

    private val tested = TeamMemberMapper()

    @Test
    fun `mapToDomainModelList with correct data should return correct mapped data`() {
        // given
        val response = listOf(
            generateTeamMemberResponse(id = "1"),
            generateTeamMemberResponse(id = "2"),
            generateTeamMemberResponse(id = "3")
        )
        val expected = listOf(
            generateTeamMember(id = "1"),
            generateTeamMember(id = "2"),
            generateTeamMember(id = "3")
        )

        // when
        val actual = tested.mapToDomainModelList(response = response)

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `mapToDomainModel with null data should return empty data`() {
        // given
        val response = listOf(
            TeamMemberResponse(),
            TeamMemberResponse(),
            TeamMemberResponse()
        )
        val expected = listOf(
            generateTeamMember(id = "", name = "", position = ""),
            generateTeamMember(id = "", name = "", position = ""),
            generateTeamMember(id = "", name = "", position = "")
        )

        // when
        val actual = tested.mapToDomainModelList(response = response)

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `mapToDomainModel with empty list response should return empty list data`() {
        // when
        val actual = tested.mapToDomainModelList(response = emptyList())

        // then
        assertEquals(emptyList<TeamMember>(), actual)
    }

    @Test
    fun `mapToDomainModel with null response should return empty list data`() {
        // when
        val actual = tested.mapToDomainModelList(response = null)

        // then
        assertEquals(emptyList<TeamMember>(), actual)
    }
}