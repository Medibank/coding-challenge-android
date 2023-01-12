package com.example.myapplication.myapplicationtabactivity.presentation.di

import com.example.myapplication.myapplicationtabactivity.data.database.NewsArticleDAO
import com.example.myapplication.myapplicationtabactivity.data.repository.datasource.NewsArticleLocalDataSource
import com.example.myapplication.myapplicationtabactivity.data.repository.datasourceImpl.NewsArticleLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {
    @Singleton
    @Provides
    fun provideLocalDataSource(articleDAO: NewsArticleDAO):NewsArticleLocalDataSource{
        return NewsArticleLocalDataSourceImpl(articleDAO)
    }

}