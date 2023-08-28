package com.plcoding.cryptoapp.domain.repository

import com.plcoding.cryptoapp.data.remote.dto.CoinDetailDto
import com.plcoding.cryptoapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String) : CoinDetailDto
}