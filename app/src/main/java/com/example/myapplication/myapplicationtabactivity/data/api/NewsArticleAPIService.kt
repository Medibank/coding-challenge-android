package com.example.myapplication.myapplicationtabactivity.data.api

import com.example.myapplication.myapplicationtabactivity.BuildConfig
import com.example.myapplication.myapplicationtabactivity.data.model.ArticlesList
import com.example.myapplication.myapplicationtabactivity.data.model.SourcesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsArticleAPIService {

    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country")
        country:String,
        @Query("apiKey")
        apiKey:String = BuildConfig.NEWSAPI_KEY
    ): ArticlesList

    @GET("v2/top-headlines/sources")
    suspend fun getTopHeadlinesSources(
        @Query("country")
        country:String,
        @Query("apiKey")
        apiKey:String = BuildConfig.NEWSAPI_KEY
    ): SourcesList


}