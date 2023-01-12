package com.example.myapplication.myapplicationtabactivity.data.model

import com.google.gson.annotations.SerializedName

data class SourcesList(
    @SerializedName("sources")
    val sources: List<SourceDetails>,

    @SerializedName("status")
    val status: String
)