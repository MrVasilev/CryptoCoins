package com.neverland.cryptocoins.data.mapper

import com.neverland.cryptocoins.DataGenerator.generateLinks
import com.neverland.cryptocoins.DataGenerator.generateLinksResponse
import com.neverland.cryptocoins.data.model.LinksResponse
import com.neverland.cryptocoins.domain.model.Links
import org.junit.Assert.assertEquals
import org.junit.Test

class LinksMapperTest {

    private val tested = LinksMapper()

    @Test
    fun `mapToDomainModel with correct data should return correct mapped data`() {
        // given
        val response = generateLinksResponse()
        val expected = generateLinks()

        // when
        val actual = tested.mapToDomainModel(response = response)

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `mapToDomainModel with empty list data should return empty data`() {
        // given
        val response = LinksResponse(
            explorer = emptyList(),
            facebook = emptyList(),
            reddit = emptyList(),
            sourceCode = emptyList(),
            website = emptyList(),
            youtube = emptyList()
        )
        val expected = Links(
            explorer = emptyList(),
            facebook = emptyList(),
            reddit = emptyList(),
            sourceCode = emptyList(),
            website = emptyList(),
            youtube = emptyList()
        )

        // when
        val actual = tested.mapToDomainModel(response = response)

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `mapToDomainModel with null data should return empty data`() {
        // given
        val response = LinksResponse()
        val expected = Links(
            explorer = emptyList(),
            facebook = emptyList(),
            reddit = emptyList(),
            sourceCode = emptyList(),
            website = emptyList(),
            youtube = emptyList()
        )

        // when
        val actual = tested.mapToDomainModel(response = response)

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `mapToDomainModel with null response should return empty data`() {
        // given
        val expected = Links(
            explorer = emptyList(),
            facebook = emptyList(),
            reddit = emptyList(),
            sourceCode = emptyList(),
            website = emptyList(),
            youtube = emptyList()
        )

        // when
        val actual = tested.mapToDomainModel(response = null)

        // then
        assertEquals(expected, actual)
    }
}