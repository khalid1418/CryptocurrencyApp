package com.plcoding.cryptocurrencyappyt.domin.get_coin

import com.plcoding.cryptocurrencyappyt.Resource
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoin
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoinDetail
import com.plcoding.cryptocurrencyappyt.domin.model.CoinDetail
import com.plcoding.cryptocurrencyappyt.domin.model.Coins
import com.plcoding.cryptocurrencyappyt.domin.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId:String):Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))

        }catch (e:HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occured"))

        }catch (e:IOException){
            emit(Resource.Error<CoinDetail>("Couldn't reach the server.Please check your internet connection"))
        }
    }
}