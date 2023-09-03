package com.neverland.cryptocoins.data.mapper

import com.neverland.cryptocoins.DataGenerator.generateParent
import com.neverland.cryptocoins.DataGenerator.generateParentResponse
import com.neverland.cryptocoins.data.model.ParentResponse
import com.neverland.cryptocoins.domain.model.Parent
import org.junit.Assert.assertEquals
import org.junit.Test

class ParentMapperTest {

    private val tested = ParentMapper()

    @Test
    fun `mapToDomainModel with correct data should return correct mapped data`() {
        // given
        val response = generateParentResponse()
        val expected = generateParent()

        // when
        val actual = tested.mapToDomainModel(response = response)

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `mapToDomainModel with null data should return empty data`() {
        // given
        val response = ParentResponse()
        val expected = Parent(id = "", name = "", symbol = "")

        // when
        val actual = tested.mapToDomainModel(response = response)

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `mapToDomainModel with null response should return empty data`() {
        // given
        val expected = Parent(id = "", name = "", symbol = "")

        // when
        val actual = tested.mapToDomainModel(response = null)

        // then
        assertEquals(expected, actual)
    }
}