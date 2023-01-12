package com.example.myapplication.myapplicationtabactivity.presentation.di

import com.example.myapplication.myapplicationtabactivity.data.repository.NewsArticleRepositoryImpl
import com.example.myapplication.myapplicationtabactivity.data.repository.datasource.NewsArticleLocalDataSource
import com.example.myapplication.myapplicationtabactivity.data.repository.datasource.NewsArticleRemoteDataSource
import com.example.myapplication.myapplicationtabactivity.domain.repository.NewsArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        newsRemoteDataSource: NewsArticleRemoteDataSource,
        newsLocalDataSource: NewsArticleLocalDataSource
    ): NewsArticleRepository {
        return NewsArticleRepositoryImpl(
            newsRemoteDataSource,
            newsLocalDataSource
        )
    }

}