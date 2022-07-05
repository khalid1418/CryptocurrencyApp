package com.plcoding.cryptocurrencyappyt.domin.model

import com.google.gson.annotations.SerializedName

data class Coins(
    val symbol: String ,
    val isActive: Boolean ,
    val name: String,
    val rank: Int,
    val id: String,
)
