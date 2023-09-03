package com.neverland.cryptocoins.data.network

import com.neverland.cryptocoins.data.model.CoinDetailsResponse
import com.neverland.cryptocoins.data.model.CoinResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinsApi {
    @GET("v1/coins")
    suspend fun getCoins(): List<CoinResponse>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinDetails(@Path("coinId") coinId: String): CoinDetailsResponse

}