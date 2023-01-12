package com.example.myapplication.myapplicationtabactivity.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.myapplication.myapplicationtabactivity.data.database.NewsArticleDAO
import com.example.myapplication.myapplicationtabactivity.data.database.NewsArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideNewsDatabase(app: Application): NewsArticleDatabase {
        return Room.databaseBuilder(app, NewsArticleDatabase::class.java, "news_articles_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsDao(articleDatabase: NewsArticleDatabase): NewsArticleDAO {
        return articleDatabase.getNewsArticleDao()
    }
}