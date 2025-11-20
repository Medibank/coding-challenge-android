package com.medibank.articlesheadlines.data.model

/**
 * Represents a news article.
 * 
 * This model matches the structure returned by NewsAPI and is used
 * throughout the app for displaying article information.
 * 
 * @property title The headline/title of the article
 * @property description A brief description or excerpt
 * @property author The author of the article
 * @property url The URL to the full article
 * @property urlToImage URL to the article's thumbnail image
 * @property publishedAt ISO 8601 timestamp when article was published
 * @property source The source/publication of the article
 */
data class Article(
    val title: String,
    val description: String?,
    val author: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val source: Source
)

/**
 * Represents the source/publication of an article.
 * 
 * @property id Unique identifier for the source (may be null)
 * @property name Display name of the source (e.g., "BBC News", "TechCrunch")
 */
data class Source(
    val id: String?,
    val name: String
)
