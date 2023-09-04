package com.plcoding.cryptoapp.domain.usecase.get_coins

import com.plcoding.cryptoapp.common.Constants.BASE_ERROR_MESSAGE
import com.plcoding.cryptoapp.common.Resource
import com.plcoding.cryptoapp.data.remote.dto.toCoin
import com.plcoding.cryptoapp.domain.model.Coin
import com.plcoding.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: BASE_ERROR_MESSAGE))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection"))
        }
    }
}