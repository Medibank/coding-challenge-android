# Headlines Screen - Architecture Overview

## Screen Features

The Headlines screen is the first screen of the Articles Headlines app and includes:

### UI Components
1. **Article List** - Scrollable list of news articles
   - Article thumbnail image (80dp, rounded corners)
   - Article title (max 2 lines)
   - Article description (max 2 lines)
   - Source name and author
   - Save button

2. **Loading State** - Circular progress indicator with loading text

3. **Error State** - Error icon, message, and retry button

4. **Empty State** - Message when no articles are available

5. **WebView** - Full-screen article reader with:
   - Back button
   - Article title in toolbar
   - Web content

### Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                      HeadlinesScreen                         │
│                    (Jetpack Compose UI)                      │
└────────────────────────┬────────────────────────────────────┘
                         │
                         │ observes StateFlow
                         │
┌────────────────────────▼────────────────────────────────────┐
│                   HeadlinesViewModel                         │
│                    (MVVM Pattern)                            │
│  - Manages UI state (loading, error, success)               │
│  - Exposes StateFlow<HeadlinesUiState>                      │
│  - Handles user interactions                                │
└────────────────────────┬────────────────────────────────────┘
                         │
                         │ calls repository
                         │
┌────────────────────────▼────────────────────────────────────┐
│               ArticlesRepository (Interface)                 │
│                   (Domain Layer)                             │
└────────────────────────┬────────────────────────────────────┘
                         │
                         │ implemented by
                         │
┌────────────────────────▼────────────────────────────────────┐
│            ArticlesRepositoryImpl                            │
│                (Data Layer)                                  │
│  - Transforms DTOs to domain models                         │
│  - Handles API errors                                       │
└────────────────────────┬────────────────────────────────────┘
                         │
                         │ uses
                         │
┌────────────────────────▼────────────────────────────────────┐
│                  NewsApiService                              │
│                 (Retrofit Interface)                         │
│  - Defines API endpoints                                    │
│  - Returns NewsResponse (DTOs)                              │
└─────────────────────────────────────────────────────────────┘
```

## Data Flow

### Success Flow
```
1. User opens app
2. HeadlinesViewModel.init() called
3. loadHeadlines() triggered
4. UI state updated: isLoading = true
5. Repository.getHeadlines(["bbc-news"]) called
6. NewsApiService makes HTTP GET request
7. Response transformed: ArticleDto → Article
8. UI state updated: articles = [...], isLoading = false
9. HeadlinesScreen renders article list
```

### Error Flow
```
1. User opens app
2. HeadlinesViewModel.init() called
3. loadHeadlines() triggered
4. UI state updated: isLoading = true
5. Repository.getHeadlines(["bbc-news"]) called
6. NewsApiService throws exception (network error, API error, etc.)
7. Exception caught in repository
8. UI state updated: error = "message", isLoading = false
9. HeadlinesScreen renders error state with retry button
```

### Article Click Flow
```
1. User taps article
2. HeadlinesViewModel.onArticleClick(article) called
3. UI state updated: selectedArticle = article
4. HeadlinesScreen observes state change
5. ArticleWebView rendered with article URL
6. User reads article in WebView
7. User taps back button
8. HeadlinesViewModel.onWebViewClosed() called
9. UI state updated: selectedArticle = null
10. HeadlinesScreen returns to article list
```

## Data Models

### Domain Model (Clean Architecture)
```kotlin
Article(
    id: String,              // Unique identifier
    sourceId: String?,       // Source ID (can be null)
    sourceName: String,      // Display name of source
    author: String?,         // Article author
    title: String,           // Article title
    description: String?,    // Brief description
    url: String,             // Full article URL
    imageUrl: String?,       // Thumbnail image URL
    publishedAt: String,     // Publication date
    content: String?,        // Article preview
    isSaved: Boolean         // Saved status (for future use)
)
```

### API DTO (Data Transfer Object)
```kotlin
NewsResponse(
    status: String,
    totalResults: Int,
    articles: List<ArticleDto>
)

ArticleDto(
    source: SourceDto,
    author: String?,
    title: String,
    description: String?,
    url: String,
    urlToImage: String?,
    publishedAt: String,
    content: String?
)
```

## Dependency Injection

Using Hilt for DI with two modules:

### NetworkModule
- Provides OkHttpClient with logging interceptor
- Provides Retrofit instance configured for NewsAPI
- Provides NewsApiService

### RepositoryModule
- Binds ArticlesRepositoryImpl to ArticlesRepository interface

## Testing Strategy

### Unit Tests (HeadlinesViewModelTest)
1. **Initial state test** - Verifies loading state on init
2. **Success scenario** - Validates articles loaded correctly
3. **Error scenario** - Validates error handling
4. **Article selection** - Tests state update on article click
5. **WebView dismissal** - Tests state reset on back

### Test Tools
- JUnit 4 for test framework
- Mockito for mocking dependencies
- Kotlin Test for assertions
- Turbine for Flow testing
- Coroutines Test for async testing

## Code Quality Features

1. **Separation of Concerns**
   - UI layer (Compose)
   - Presentation layer (ViewModel)
   - Domain layer (Models, Repository interfaces)
   - Data layer (Repository implementations, API service)

2. **Dependency Inversion**
   - ViewModel depends on repository interface, not implementation
   - Enables easy testing and swapping implementations

3. **Reactive UI**
   - StateFlow for state management
   - Composables automatically recompose on state changes

4. **Error Handling**
   - Result type for repository responses
   - Try-catch for API calls
   - User-friendly error messages

5. **Modern Kotlin**
   - Coroutines for async operations
   - Extension functions for DTO transformation
   - Data classes for immutability
   - Sealed classes/interfaces can be added for better type safety

## Future Enhancements

1. **Pagination** - Load more articles as user scrolls
2. **Source Selection** - Filter articles by selected sources
3. **Save Functionality** - Persist articles to Room database
4. **Pull to Refresh** - Manual refresh capability
5. **Search** - Search articles by keyword
6. **Offline Support** - Cache articles locally
7. **Dark Theme** - Support system dark mode
