package com.plcoding.cryptocurrencyappyt.coin_detail

import com.plcoding.cryptocurrencyappyt.Resource
import com.plcoding.cryptocurrencyappyt.domin.model.CoinDetail
import com.plcoding.cryptocurrencyappyt.domin.model.Coins

data class CoinDetailState(
    val isLoading: Boolean = false ,
    val coin:CoinDetail? =null,
    val error:String =""
)
