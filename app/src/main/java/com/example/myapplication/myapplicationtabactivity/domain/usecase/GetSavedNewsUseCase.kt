package com.example.myapplication.myapplicationtabactivity.domain.usecase

import com.example.myapplication.myapplicationtabactivity.data.model.Article
import com.example.myapplication.myapplicationtabactivity.domain.repository.NewsArticleRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsArticleRepository: NewsArticleRepository) {
    fun execute(): Flow<List<Article>> {
        return newsArticleRepository.getSavedNewsArticles()
    }
}