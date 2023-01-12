package com.example.myapplication.myapplicationtabactivity.domain.usecase

import com.example.myapplication.myapplicationtabactivity.data.model.SourcesList
import com.example.myapplication.myapplicationtabactivity.domain.repository.NewsArticleRepository

class GetSourcesUseCase(private val repository: NewsArticleRepository) {

    suspend fun execute(country: String): SourcesList{
        return repository.getNewsArticlesSources(country)
    }
}