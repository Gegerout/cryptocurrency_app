package com.plcoding.cryptoapp.presentation.coint_list

import com.plcoding.cryptoapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
