package com.medibank.articlesheadlines.data.repository

import com.medibank.articlesheadlines.data.model.ArticleDto
import com.medibank.articlesheadlines.data.remote.NewsApiService
import com.medibank.articlesheadlines.domain.model.Article
import com.medibank.articlesheadlines.domain.repository.ArticlesRepository
import java.util.UUID
import javax.inject.Inject

class ArticlesRepositoryImpl @Inject constructor(
    private val newsApiService: NewsApiService
) : ArticlesRepository {

    companion object {
        // For demo purposes, using a sample API key
        // In production, this should be stored securely
        private const val API_KEY = "YOUR_API_KEY_HERE"
    }

    override suspend fun getHeadlines(sources: List<String>): Result<List<Article>> {
        return try {
            val sourcesParam = sources.joinToString(",")
            val response = newsApiService.getTopHeadlines(sourcesParam, API_KEY)
            Result.success(response.articles.map { it.toArticle() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun ArticleDto.toArticle(): Article {
        return Article(
            id = UUID.randomUUID().toString(),
            sourceId = source.id,
            sourceName = source.name,
            author = author,
            title = title,
            description = description,
            url = url,
            imageUrl = urlToImage,
            publishedAt = publishedAt,
            content = content
        )
    }
}
