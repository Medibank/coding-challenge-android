package com.medibank.articlesheadlines.domain.repository

import com.medibank.articlesheadlines.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface ArticlesRepository {
    suspend fun getHeadlines(sources: List<String>): Result<List<Article>>
}
