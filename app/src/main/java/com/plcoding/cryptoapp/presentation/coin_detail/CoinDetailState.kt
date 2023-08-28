package com.plcoding.cryptoapp.presentation.coin_detail

import com.plcoding.cryptoapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
