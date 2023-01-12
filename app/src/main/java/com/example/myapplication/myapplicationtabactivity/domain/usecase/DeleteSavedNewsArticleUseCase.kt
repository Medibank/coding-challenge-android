package com.example.myapplication.myapplicationtabactivity.domain.usecase

import com.example.myapplication.myapplicationtabactivity.data.model.Article
import com.example.myapplication.myapplicationtabactivity.domain.repository.NewsArticleRepository

class DeleteSavedNewsArticleUseCase(private val newsArticleRepository: NewsArticleRepository) {
    suspend fun execute(article: Article) = newsArticleRepository.deleteNewsArticle(article)
}