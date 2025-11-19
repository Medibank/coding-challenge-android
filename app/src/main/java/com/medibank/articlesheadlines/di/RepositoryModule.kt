package com.medibank.articlesheadlines.di

import com.medibank.articlesheadlines.data.repository.ArticlesRepositoryImpl
import com.medibank.articlesheadlines.domain.repository.ArticlesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindArticlesRepository(
        articlesRepositoryImpl: ArticlesRepositoryImpl
    ): ArticlesRepository
}
