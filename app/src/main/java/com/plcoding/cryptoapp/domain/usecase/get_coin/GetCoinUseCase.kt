package com.plcoding.cryptoapp.domain.usecase.get_coin

import com.plcoding.cryptoapp.common.Constants.BASE_ERROR_MESSAGE
import com.plcoding.cryptoapp.common.Resource
import com.plcoding.cryptoapp.data.remote.dto.toCoinDetail
import com.plcoding.cryptoapp.domain.model.CoinDetail
import com.plcoding.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: BASE_ERROR_MESSAGE))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Check your internet connection"))
        }
    }
}