package com.plcoding.cryptocurrencyappyt.domin.model

import com.plcoding.cryptocurrencyappyt.data.remote.dto.TagsItem
import com.plcoding.cryptocurrencyappyt.data.remote.dto.TeamMember

data class CoinDetail(
    val id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val symbol: String? = null,
    val isActive: Boolean? = null,
    val rank: Int? = null,
    val tags: List<String?>? = null,
    val team: List<TeamMember?>? = null
    )
