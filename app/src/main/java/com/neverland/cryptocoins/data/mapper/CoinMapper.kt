package com.neverland.cryptocoins.data.mapper

import com.neverland.cryptocoins.data.model.CoinResponse
import com.neverland.cryptocoins.domain.model.Coin
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CoinMapper @Inject constructor() {

    fun mapToDomainModel(response: CoinResponse): Coin = Coin(
        id = response.id.orEmpty(),
        name = response.name.orEmpty(),
        symbol = response.symbol.orEmpty(),
        rank = response.rank ?: -1,
        isNew = response.isNew ?: false,
        isActive = response.isActive ?: false,
        type = response.type.orEmpty()
    )
}