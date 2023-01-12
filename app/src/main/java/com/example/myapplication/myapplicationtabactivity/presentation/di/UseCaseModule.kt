package com.example.myapplication.myapplicationtabactivity.presentation.di

import com.example.myapplication.myapplicationtabactivity.domain.repository.NewsArticleRepository
import com.example.myapplication.myapplicationtabactivity.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetNewsheadLinesUseCase(
        newsRepository: NewsArticleRepository
    ):GetNewsArticlesUseCase{
        return GetNewsArticlesUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideSaveNewsUseCase(
        newsRepository: NewsArticleRepository
    ):SaveNewsArticleUseCase{
        return SaveNewsArticleUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideGetSavedNewsUseCase(
        newsRepository: NewsArticleRepository
    ): GetSavedNewsUseCase {
        return GetSavedNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideDeleteSavedNewsUseCase(
        newsRepository: NewsArticleRepository
    ):DeleteSavedNewsArticleUseCase{
        return DeleteSavedNewsArticleUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideGetSourcesUseCase(
        newsRepository: NewsArticleRepository
    ):GetSourcesUseCase{
        return GetSourcesUseCase(newsRepository)
    }
}