package com.example.myapplication.myapplicationtabactivity.data.repository

import com.example.myapplication.myapplicationtabactivity.data.model.Article
import com.example.myapplication.myapplicationtabactivity.data.model.ArticlesList
import com.example.myapplication.myapplicationtabactivity.data.model.SourceDetails
import com.example.myapplication.myapplicationtabactivity.data.model.SourcesList
import com.example.myapplication.myapplicationtabactivity.data.repository.datasource.NewsArticleLocalDataSource
import com.example.myapplication.myapplicationtabactivity.data.repository.datasource.NewsArticleRemoteDataSource
import com.example.myapplication.myapplicationtabactivity.domain.repository.NewsArticleRepository
import kotlinx.coroutines.flow.Flow

class NewsArticleRepositoryImpl(private val newsArticleRemoteDataSource: NewsArticleRemoteDataSource,
        private val newsArticleLocalDataSource: NewsArticleLocalDataSource): NewsArticleRepository {

        override suspend fun getNewsArticles(country: String): ArticlesList {
                return newsArticleRemoteDataSource.getTopHeadlines(country)
        }

        override suspend fun getNewsArticlesSources(country: String): SourcesList {
                return newsArticleRemoteDataSource.getTopHeadlinesSources(country)
        }

        override fun getSavedSources(): Flow<List<SourceDetails>> {
                return newsArticleLocalDataSource.getSavedSources()
        }

        override suspend fun saveNewsArticle(article: Article) {
                newsArticleLocalDataSource.saveArticleToDB(article)
        }

        override suspend fun deleteNewsArticle(article: Article) {
                newsArticleLocalDataSource.deleteArticlesFromDB(article)
        }

        override fun getSavedNewsArticles(): Flow<List<Article>> {
                return newsArticleLocalDataSource.getSavedArticles()
        }
}