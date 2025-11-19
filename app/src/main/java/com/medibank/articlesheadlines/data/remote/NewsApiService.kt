package com.medibank.articlesheadlines.data.remote

import com.medibank.articlesheadlines.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String
    ): NewsResponse
}
