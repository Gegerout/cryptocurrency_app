package com.plcoding.cryptoapp.data.repository

import com.plcoding.cryptoapp.data.remote.CoinPaprikaApi
import com.plcoding.cryptoapp.data.remote.dto.CoinDetailDto
import com.plcoding.cryptoapp.data.remote.dto.CoinDto
import com.plcoding.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: CoinPaprikaApi) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}