package com.example.myapplication.myapplicationtabactivity.domain.repository

import com.example.myapplication.myapplicationtabactivity.data.model.Article
import com.example.myapplication.myapplicationtabactivity.data.model.ArticlesList
import com.example.myapplication.myapplicationtabactivity.data.model.SourceDetails
import com.example.myapplication.myapplicationtabactivity.data.model.SourcesList
import kotlinx.coroutines.flow.Flow

interface NewsArticleRepository {

    suspend fun getNewsArticles(country : String): ArticlesList
    suspend fun saveNewsArticle(article: Article)
    suspend fun deleteNewsArticle(article: Article)
    fun getSavedNewsArticles(): Flow<List<Article>>

    suspend fun getNewsArticlesSources(country : String): SourcesList
    fun getSavedSources(): Flow<List<SourceDetails>>
}