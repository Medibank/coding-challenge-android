package com.example.myapplication.myapplicationtabactivity.data.repository.datasourceImpl

import com.example.myapplication.myapplicationtabactivity.data.api.NewsArticleAPIService
import com.example.myapplication.myapplicationtabactivity.data.model.ArticlesList
import com.example.myapplication.myapplicationtabactivity.data.model.SourcesList
import com.example.myapplication.myapplicationtabactivity.data.repository.datasource.NewsArticleRemoteDataSource

class NewsArticleRemoteDataSourceImpl(private val newsAPIService: NewsArticleAPIService): NewsArticleRemoteDataSource {
    override suspend fun getTopHeadlines(country: String): ArticlesList {
        return newsAPIService.getTopHeadlines(country)
    }

    override suspend fun getTopHeadlinesSources(country: String): SourcesList {
       return newsAPIService.getTopHeadlinesSources(country)
    }
}