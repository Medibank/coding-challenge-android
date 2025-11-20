package com.medibank.articlesheadlines.ui.headlines

import androidx.lifecycle.ViewModel
import com.medibank.articlesheadlines.data.model.Article
import com.medibank.articlesheadlines.data.model.Source
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class HeadlinesUiState(
    val articles: List<Article> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class HeadlinesViewModel @Inject constructor() : ViewModel() {
    
    private val _uiState = MutableStateFlow(HeadlinesUiState())
    val uiState: StateFlow<HeadlinesUiState> = _uiState.asStateFlow()
    
    init {
        loadSampleData()
    }
    
    private fun loadSampleData() {
        // Sample data for initial display
        val sampleArticles = listOf(
            Article(
                title = "Breaking: New Technology Advances in AI",
                description = "Scientists have made groundbreaking discoveries in artificial intelligence that could revolutionize the tech industry.",
                author = "Jane Smith",
                url = "https://example.com/article1",
                urlToImage = "https://picsum.photos/400/300?random=1",
                publishedAt = "2024-01-15T10:30:00Z",
                source = Source(id = "tech-news", name = "Tech News")
            ),
            Article(
                title = "Global Climate Summit Reaches Historic Agreement",
                description = "World leaders have agreed on new measures to combat climate change in a landmark international summit.",
                author = "John Doe",
                url = "https://example.com/article2",
                urlToImage = "https://picsum.photos/400/300?random=2",
                publishedAt = "2024-01-15T09:15:00Z",
                source = Source(id = "world-news", name = "World News")
            ),
            Article(
                title = "Stock Market Reaches All-Time High",
                description = "The stock market has hit record highs as investors show renewed confidence in the economy.",
                author = "Sarah Johnson",
                url = "https://example.com/article3",
                urlToImage = "https://picsum.photos/400/300?random=3",
                publishedAt = "2024-01-15T08:00:00Z",
                source = Source(id = "business", name = "Business Today")
            ),
            Article(
                title = "New Medical Breakthrough in Cancer Treatment",
                description = "Researchers announce a potential cure for certain types of cancer after years of clinical trials.",
                author = "Dr. Emily Brown",
                url = "https://example.com/article4",
                urlToImage = "https://picsum.photos/400/300?random=4",
                publishedAt = "2024-01-14T18:45:00Z",
                source = Source(id = "health", name = "Health Today")
            ),
            Article(
                title = "Space Mission Successfully Lands on Mars",
                description = "A historic space mission has successfully landed on Mars, marking a new era in space exploration.",
                author = "Michael Chen",
                url = "https://example.com/article5",
                urlToImage = "https://picsum.photos/400/300?random=5",
                publishedAt = "2024-01-14T16:20:00Z",
                source = Source(id = "science", name = "Science Daily")
            )
        )
        
        _uiState.value = HeadlinesUiState(articles = sampleArticles)
    }
    
    fun saveArticle(article: Article) {
        // TODO: Implement save functionality
    }
}
