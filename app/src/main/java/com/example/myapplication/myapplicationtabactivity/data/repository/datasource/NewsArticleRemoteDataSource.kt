package com.example.myapplication.myapplicationtabactivity.data.repository.datasource

import com.example.myapplication.myapplicationtabactivity.data.model.ArticlesList
import com.example.myapplication.myapplicationtabactivity.data.model.SourcesList

interface NewsArticleRemoteDataSource {
    suspend fun getTopHeadlines(country : String): ArticlesList
    suspend fun getTopHeadlinesSources(country : String): SourcesList
}