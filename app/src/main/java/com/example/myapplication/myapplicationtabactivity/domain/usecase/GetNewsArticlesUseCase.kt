package com.example.myapplication.myapplicationtabactivity.domain.usecase

import com.example.myapplication.myapplicationtabactivity.data.model.ArticlesList
import com.example.myapplication.myapplicationtabactivity.domain.repository.NewsArticleRepository

class GetNewsArticlesUseCase(private val newsArticleRepository: NewsArticleRepository) {

    suspend fun execute(country : String): ArticlesList{
        return newsArticleRepository.getNewsArticles(country)
    }
}