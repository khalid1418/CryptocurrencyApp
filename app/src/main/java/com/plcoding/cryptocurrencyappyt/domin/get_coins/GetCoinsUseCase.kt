package com.plcoding.cryptocurrencyappyt.domin.get_coins

import com.plcoding.cryptocurrencyappyt.Resource
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoin
import com.plcoding.cryptocurrencyappyt.domin.model.Coins
import com.plcoding.cryptocurrencyappyt.domin.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke():Flow<Resource<List<Coins>>> = flow {
        try {
            emit(Resource.Loading<List<Coins>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coins>>(coins))

        }catch (e:HttpException){
            emit(Resource.Error<List<Coins>>(e.localizedMessage ?: "An unexpected error occured"))

        }catch (e:IOException){
            emit(Resource.Error<List<Coins>>("Couldn't reach the server.Please check your internet connection"))
        }
    }
}