package com.medibank.articlesheadlines.ui.headlines

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HeadlinesViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var viewModel: HeadlinesViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = HeadlinesViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state should contain sample articles`() = runTest {
        // When
        val uiState = viewModel.uiState.value

        // Then
        assertFalse(uiState.isLoading)
        assertNull(uiState.error)
        assertEquals(5, uiState.articles.size)
    }

    @Test
    fun `sample articles should have correct structure`() = runTest {
        // When
        val articles = viewModel.uiState.value.articles

        // Then
        articles.forEach { article ->
            assertNotNull(article.title)
            assertNotNull(article.url)
            assertNotNull(article.source)
            assertNotNull(article.source.name)
            assertNotNull(article.publishedAt)
        }
    }

    @Test
    fun `first article should be about AI technology`() = runTest {
        // When
        val firstArticle = viewModel.uiState.value.articles.first()

        // Then
        assertEquals("Breaking: New Technology Advances in AI", firstArticle.title)
        assertEquals("Tech News", firstArticle.source.name)
        assertEquals("Jane Smith", firstArticle.author)
    }

    @Test
    fun `all articles should have valid URLs`() = runTest {
        // When
        val articles = viewModel.uiState.value.articles

        // Then
        articles.forEach { article ->
            assert(article.url.startsWith("https://"))
        }
    }

    @Test
    fun `articles should have different sources`() = runTest {
        // When
        val articles = viewModel.uiState.value.articles
        val sourceNames = articles.map { it.source.name }.toSet()

        // Then
        assertEquals(5, sourceNames.size) // All articles have different sources
    }

    @Test
    fun `saveArticle should not throw exception`() = runTest {
        // Given
        val article = viewModel.uiState.value.articles.first()

        // When/Then (should not throw)
        viewModel.saveArticle(article)
    }
}
