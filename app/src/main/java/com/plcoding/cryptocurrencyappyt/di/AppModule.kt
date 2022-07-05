package com.plcoding.cryptocurrencyappyt.di

import com.plcoding.cryptocurrencyappyt.Constant
import com.plcoding.cryptocurrencyappyt.data.remote.CoinPaprikaApi
import com.plcoding.cryptocurrencyappyt.data.repository.CoinRepositoryImp
import com.plcoding.cryptocurrencyappyt.domin.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providerApiPaprika():CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }
    @Provides
    @Singleton
    fun providerRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImp(api)
    }
}