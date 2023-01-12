package com.example.myapplication.myapplicationtabactivity.presentation.di

import com.example.myapplication.myapplicationtabactivity.BuildConfig
import com.example.myapplication.myapplicationtabactivity.data.api.NewsArticleAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsAPIService(retrofit: Retrofit):NewsArticleAPIService{
        return retrofit.create(NewsArticleAPIService::class.java)
    }
}