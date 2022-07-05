package com.plcoding.cryptocurrencyappyt.coin_list

import com.plcoding.cryptocurrencyappyt.Resource
import com.plcoding.cryptocurrencyappyt.domin.model.Coins

data class CoinListState(
    val isLoading: Boolean = false ,
    val coins:List<Coins> = emptyList(),
    val error:String =""
)
