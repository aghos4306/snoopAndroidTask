package com.aghogho.snoopandroidtask.di

import com.aghogho.snoopandroidtask.data.remote.CatApiService
import com.aghogho.snoopandroidtask.data.repository.CatRepositoryImpl
import com.aghogho.snoopandroidtask.domain.repository.CatRepository
import com.aghogho.snoopandroidtask.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCatApi(): CatApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCatRepository(catApiService: CatApiService): CatRepository {
        return CatRepositoryImpl(catApiService)
    }
}
