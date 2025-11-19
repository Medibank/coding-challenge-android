package com.medibank.articlesheadlines.ui.headlines

import app.cash.turbine.test
import com.medibank.articlesheadlines.domain.model.Article
import com.medibank.articlesheadlines.domain.repository.ArticlesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class HeadlinesViewModelTest {

    private lateinit var repository: ArticlesRepository
    private lateinit var viewModel: HeadlinesViewModel
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        repository = mock()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state is loading`() = runTest {
        val articles = listOf(createTestArticle())
        whenever(repository.getHeadlines(listOf("bbc-news")))
            .thenReturn(Result.success(articles))

        viewModel = HeadlinesViewModel(repository)

        viewModel.uiState.test {
            val initialState = awaitItem()
            assertTrue(initialState.isLoading)
            assertEquals(emptyList(), initialState.articles)
            assertNull(initialState.error)

            testDispatcher.scheduler.advanceUntilIdle()

            val loadedState = awaitItem()
            assertFalse(loadedState.isLoading)
            assertEquals(articles, loadedState.articles)
            assertNull(loadedState.error)
        }
    }

    @Test
    fun `loadHeadlines success updates state correctly`() = runTest {
        val articles = listOf(createTestArticle())
        whenever(repository.getHeadlines(listOf("bbc-news")))
            .thenReturn(Result.success(articles))

        viewModel = HeadlinesViewModel(repository)
        testDispatcher.scheduler.advanceUntilIdle()

        viewModel.uiState.test {
            val state = awaitItem()
            assertFalse(state.isLoading)
            assertEquals(articles, state.articles)
            assertNull(state.error)
        }
    }

    @Test
    fun `loadHeadlines failure updates state with error`() = runTest {
        val errorMessage = "Network error"
        whenever(repository.getHeadlines(listOf("bbc-news")))
            .thenReturn(Result.failure(Exception(errorMessage)))

        viewModel = HeadlinesViewModel(repository)
        testDispatcher.scheduler.advanceUntilIdle()

        viewModel.uiState.test {
            val state = awaitItem()
            assertFalse(state.isLoading)
            assertEquals(emptyList(), state.articles)
            assertEquals(errorMessage, state.error)
        }
    }

    @Test
    fun `onArticleClick updates selected article`() = runTest {
        val articles = listOf(createTestArticle())
        whenever(repository.getHeadlines(listOf("bbc-news")))
            .thenReturn(Result.success(articles))

        viewModel = HeadlinesViewModel(repository)
        testDispatcher.scheduler.advanceUntilIdle()

        val article = articles.first()
        viewModel.onArticleClick(article)

        viewModel.uiState.test {
            val state = awaitItem()
            assertNotNull(state.selectedArticle)
            assertEquals(article, state.selectedArticle)
        }
    }

    @Test
    fun `onWebViewClosed clears selected article`() = runTest {
        val articles = listOf(createTestArticle())
        whenever(repository.getHeadlines(listOf("bbc-news")))
            .thenReturn(Result.success(articles))

        viewModel = HeadlinesViewModel(repository)
        testDispatcher.scheduler.advanceUntilIdle()

        viewModel.onArticleClick(articles.first())
        viewModel.onWebViewClosed()

        viewModel.uiState.test {
            val state = awaitItem()
            assertNull(state.selectedArticle)
        }
    }

    private fun createTestArticle() = Article(
        id = "1",
        sourceId = "bbc-news",
        sourceName = "BBC News",
        author = "Test Author",
        title = "Test Title",
        description = "Test Description",
        url = "https://test.com",
        imageUrl = "https://test.com/image.jpg",
        publishedAt = "2024-01-01T00:00:00Z",
        content = "Test Content"
    )
}
