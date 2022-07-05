package com.plcoding.cryptocurrencyappyt.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.plcoding.cryptocurrencyappyt.domin.model.Coins

data class CoinDto(
    val symbol: String,
    @field:SerializedName("is_active")
    val isActive: Boolean,
    @field:SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val id: String,
    val type: String
)

fun CoinDto.toCoin(): Coins {
    return Coins(
        symbol = symbol,
        isActive = isActive,
        name = name,
        rank = rank,
        id = id
    )
}
