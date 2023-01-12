package com.example.myapplication.myapplicationtabactivity.presentation.di

import com.example.myapplication.myapplicationtabactivity.data.api.NewsArticleAPIService
import com.example.myapplication.myapplicationtabactivity.data.repository.datasource.NewsArticleRemoteDataSource
import com.example.myapplication.myapplicationtabactivity.data.repository.datasourceImpl.NewsArticleRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(
        newsAPIService: NewsArticleAPIService
    ):NewsArticleRemoteDataSource{
        return NewsArticleRemoteDataSourceImpl(newsAPIService)
    }

}