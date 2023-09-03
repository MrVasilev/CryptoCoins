package com.neverland.cryptocoins.data.mapper

import com.neverland.cryptocoins.data.model.WhitePaperResponse
import com.neverland.cryptocoins.domain.model.WhitePaper
import org.junit.Assert.assertEquals
import org.junit.Test

class WhitePaperMapperTest {

    private val tested = WhitePaperMapper()

    @Test
    fun `mapToDomainModel with correct data should return correct mapped data`() {
        // given
        val link = "LINK"
        val thumbnail = "THUMBNAIL"
        val response = WhitePaperResponse(link = link, thumbnail = thumbnail)
        val expected = WhitePaper(link = link, thumbnail = thumbnail)

        // when
        val actual = tested.mapToDomainModel(response = response)

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `mapToDomainModel with null data should return empty data`() {
        // given
        val response = WhitePaperResponse()
        val expected = WhitePaper(link = "", thumbnail = "")

        // when
        val actual = tested.mapToDomainModel(response = response)

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `mapToDomainModel with null response should return empty data`() {
        // given
        val expected = WhitePaper(link = "", thumbnail = "")

        // when
        val actual = tested.mapToDomainModel(response = null)

        // then
        assertEquals(expected, actual)
    }
}