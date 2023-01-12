package com.example.myapplication.myapplicationtabactivity.presentation.di

import android.app.Application
import com.example.myapplication.myapplicationtabactivity.domain.usecase.*
import com.example.myapplication.myapplicationtabactivity.presentation.viewmodel.MyViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        application: Application,
        getNewsArticlesUseCase: GetNewsArticlesUseCase,
        saveNewsArticleUseCase: SaveNewsArticleUseCase,
        getSavedNewsUseCase: GetSavedNewsUseCase,
        deleteSavedNewsArticleUseCase: DeleteSavedNewsArticleUseCase,
        getSourcesUseCase: GetSourcesUseCase
    ): MyViewModelFactory{
        return MyViewModelFactory(
            application,
            getNewsArticlesUseCase,
            saveNewsArticleUseCase,
            getSavedNewsUseCase,
            deleteSavedNewsArticleUseCase,
            getSourcesUseCase
        )
    }
}