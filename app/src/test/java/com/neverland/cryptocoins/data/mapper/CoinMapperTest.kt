package com.neverland.cryptocoins.data.mapper

import com.neverland.cryptocoins.DataGenerator.generateCoin
import com.neverland.cryptocoins.DataGenerator.generateCoinResponse
import com.neverland.cryptocoins.data.model.CoinResponse
import com.neverland.cryptocoins.domain.model.Coin
import org.junit.Assert.assertEquals
import org.junit.Test

class CoinMapperTest {

    private val tested = CoinMapper()

    @Test
    fun `mapToDomainModel with correct data should return correct mapped data`() {
        // given
        val id = "ID"
        val response = generateCoinResponse(id = id, isNew = false, isActive = false)
        val expected = generateCoin(id = id, isNew = false, isActive = false)

        // when
        val actual = tested.mapToDomainModel(response = response)

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `mapToDomainModel with correct data with true values should return correct mapped data`() {
        // given
        val id = "ID"
        val response = generateCoinResponse(id = id, isNew = true, isActive = true)
        val expected = generateCoin(id = id, isNew = true, isActive = true)

        // when
        val actual = tested.mapToDomainModel(response = response)

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `mapToDomainModel with null data should return empty data`() {
        // given
        val response = CoinResponse()
        val expected = Coin(
            id = "",
            name = "",
            symbol = "",
            rank = -1,
            isNew = false,
            isActive = false,
            type = ""
        )

        // when
        val actual = tested.mapToDomainModel(response = response)

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `mapToDomainModel with null response should return empty data`() {
        // given
        val expected = Coin(
            id = "",
            name = "",
            symbol = "",
            rank = -1,
            isNew = false,
            isActive = false,
            type = ""
        )

        // when
        val actual = tested.mapToDomainModel(response = null)

        // then
        assertEquals(expected, actual)
    }
}