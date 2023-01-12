package com.example.myapplication.myapplicationtabactivity.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "sources_table")
data class SourceDetails(

    @PrimaryKey(autoGenerate = true)
    val tableId : Int? = null,

    @SerializedName("category")
    val category: String,

    @SerializedName("country")
    val country: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("language")
    val language: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("isChecked")
    var isChecked: Boolean,

    @SerializedName("url")
    val url: String
): Serializable