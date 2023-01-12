package com.example.myapplication.myapplicationtabactivity.data.repository.datasourceImpl

import com.example.myapplication.myapplicationtabactivity.data.database.NewsArticleDAO
import com.example.myapplication.myapplicationtabactivity.data.model.Article
import com.example.myapplication.myapplicationtabactivity.data.model.SourceDetails
import com.example.myapplication.myapplicationtabactivity.data.repository.datasource.NewsArticleLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsArticleLocalDataSourceImpl(private val newsArticleDAO: NewsArticleDAO): NewsArticleLocalDataSource {
    override suspend fun saveArticleToDB(article: Article) {
        newsArticleDAO.insertNewsArticle(article)
    }

    override fun getSavedArticles(): Flow<List<Article>> {
        return newsArticleDAO.getAllNewsArticles()
    }

    override suspend fun deleteArticlesFromDB(article: Article) {
        newsArticleDAO.deleteNewsArticle(article)
    }

    override suspend fun saveSourceToDB(sourceDetails: SourceDetails) {
        newsArticleDAO.insertSelectedSource(sourceDetails)
    }

    override fun getSavedSources(): Flow<List<SourceDetails>> {
        return newsArticleDAO.getSourcesList()
    }

}