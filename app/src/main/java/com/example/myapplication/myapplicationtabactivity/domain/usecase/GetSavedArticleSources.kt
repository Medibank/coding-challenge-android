package com.example.myapplication.myapplicationtabactivity.domain.usecase

import com.example.myapplication.myapplicationtabactivity.data.model.SourceDetails
import com.example.myapplication.myapplicationtabactivity.domain.repository.NewsArticleRepository
import kotlinx.coroutines.flow.Flow

class GetSavedArticleSources(private val newsArticleRepository: NewsArticleRepository) {
    fun execute(): Flow<List<SourceDetails>> {
        return newsArticleRepository.getSavedSources()
    }
}