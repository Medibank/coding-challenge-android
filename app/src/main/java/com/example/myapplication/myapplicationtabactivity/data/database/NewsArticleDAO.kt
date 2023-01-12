package com.example.myapplication.myapplicationtabactivity.data.database

import androidx.room.*
import com.example.myapplication.myapplicationtabactivity.data.model.Article
import com.example.myapplication.myapplicationtabactivity.data.model.SourceDetails
import com.example.myapplication.myapplicationtabactivity.data.model.SourcesList
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsArticleDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNewsArticle(article: Article)

    @Query("SELECT * FROM articles_table")
    fun getAllNewsArticles(): Flow<List<Article>>

    @Delete
    suspend fun deleteNewsArticle(article: Article)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSelectedSource(sourceDetails: SourceDetails)

    @Query("SELECT * FROM sources_table")
    fun getSourcesList(): Flow<List<SourceDetails>>

}