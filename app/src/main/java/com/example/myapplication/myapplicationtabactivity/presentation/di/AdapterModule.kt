package com.example.myapplication.myapplicationtabactivity.presentation.di

import com.example.myapplication.myapplicationtabactivity.presentation.adapter.NewsArticleRecyclerViewAdapter
import com.example.myapplication.myapplicationtabactivity.presentation.adapter.SourcesRecyclerViewAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {
    @Singleton
    @Provides
    fun provideNewsAdapter() :NewsArticleRecyclerViewAdapter{
        return NewsArticleRecyclerViewAdapter()
    }

    @Singleton
    @Provides
    fun provideSourcesAdapter() : SourcesRecyclerViewAdapter {
        return SourcesRecyclerViewAdapter()
    }
}