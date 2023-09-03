package com.neverland.cryptocoins.data.mapper

import com.neverland.cryptocoins.DataGenerator.generateTag
import com.neverland.cryptocoins.DataGenerator.generateTagResponse
import com.neverland.cryptocoins.data.model.TagResponse
import com.neverland.cryptocoins.domain.model.Tag
import org.junit.Assert.assertEquals
import org.junit.Test

class TagMapperTest {

    private val tested = TagMapper()

    @Test
    fun `mapToDomainModelList with correct data should return correct mapped data`() {
        // given
        val response = listOf(
            generateTagResponse(id = "1"),
            generateTagResponse(id = "2"),
            generateTagResponse(id = "3")
        )
        val expected = listOf(
            generateTag(id = "1"),
            generateTag(id = "2"),
            generateTag(id = "3")
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
            TagResponse(),
            TagResponse(),
            TagResponse()
        )
        val expected = listOf(
            generateTag(id = "", name = "", coinCounter = -1, icoCounter = -1),
            generateTag(id = "", name = "", coinCounter = -1, icoCounter = -1),
            generateTag(id = "", name = "", coinCounter = -1, icoCounter = -1)
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
        assertEquals(emptyList<Tag>(), actual)
    }

    @Test
    fun `mapToDomainModel with null response should return empty list data`() {
        // when
        val actual = tested.mapToDomainModelList(response = null)

        // then
        assertEquals(emptyList<Tag>(), actual)
    }
}