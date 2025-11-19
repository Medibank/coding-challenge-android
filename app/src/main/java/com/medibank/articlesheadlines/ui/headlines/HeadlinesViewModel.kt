package com.medibank.articlesheadlines.ui.headlines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medibank.articlesheadlines.domain.model.Article
import com.medibank.articlesheadlines.domain.repository.ArticlesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeadlinesViewModel @Inject constructor(
    private val articlesRepository: ArticlesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HeadlinesUiState())
    val uiState: StateFlow<HeadlinesUiState> = _uiState.asStateFlow()

    init {
        loadHeadlines()
    }

    fun loadHeadlines() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            
            // Using BBC News as default source for demo
            val result = articlesRepository.getHeadlines(listOf("bbc-news"))
            
            result.fold(
                onSuccess = { articles ->
                    _uiState.update {
                        it.copy(
                            articles = articles,
                            isLoading = false,
                            error = null
                        )
                    }
                },
                onFailure = { exception ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = exception.message ?: "Unknown error occurred"
                        )
                    }
                }
            )
        }
    }

    fun onArticleClick(article: Article) {
        _uiState.update { it.copy(selectedArticle = article) }
    }

    fun onWebViewClosed() {
        _uiState.update { it.copy(selectedArticle = null) }
    }

    fun onSaveArticle(article: Article) {
        // TODO: Implement save functionality
    }
}

data class HeadlinesUiState(
    val articles: List<Article> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val selectedArticle: Article? = null
)
