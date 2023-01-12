package com.example.myapplication.myapplicationtabactivity.data.repository.datasource

import com.example.myapplication.myapplicationtabactivity.data.model.Article
import com.example.myapplication.myapplicationtabactivity.data.model.SourceDetails
import kotlinx.coroutines.flow.Flow

interface NewsArticleLocalDataSource {
    suspend fun saveArticleToDB(article: Article)
    fun getSavedArticles(): Flow<List<Article>>
    suspend fun deleteArticlesFromDB(article: Article)

    suspend fun saveSourceToDB(sourceDetails: SourceDetails)
    fun getSavedSources(): Flow<List<SourceDetails>>
}