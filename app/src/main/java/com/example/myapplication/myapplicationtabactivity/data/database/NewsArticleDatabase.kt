package com.example.myapplication.myapplicationtabactivity.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myapplication.myapplicationtabactivity.data.model.Article
import com.example.myapplication.myapplicationtabactivity.data.model.SourceDetails

@Database(entities = [Article::class, SourceDetails::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class NewsArticleDatabase: RoomDatabase() {

    abstract fun getNewsArticleDao(): NewsArticleDAO

}