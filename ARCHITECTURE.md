# Architecture Overview

This document provides a visual overview of the app's architecture.

## Current Architecture (Phase 1: Headlines Screen)

```
┌─────────────────────────────────────────────────────────────────────┐
│                          PRESENTATION LAYER                          │
├─────────────────────────────────────────────────────────────────────┤
│                                                                      │
│  ┌────────────────────────────────────────────────────────────┐    │
│  │                      MainActivity                           │    │
│  │  (Hilt Android Entry Point)                                │    │
│  │                                                             │    │
│  │  ┌──────────────────────────────────────────────────────┐  │    │
│  │  │           Bottom Navigation Bar                       │  │    │
│  │  │   [Headlines] [Sources] [Saved]                       │  │    │
│  │  └──────────────────────────────────────────────────────┘  │    │
│  │                                                             │    │
│  │  ┌──────────────────────────────────────────────────────┐  │    │
│  │  │              Navigation Host                          │  │    │
│  │  │                                                        │  │    │
│  │  │  Route: /headlines ────► HeadlinesScreen ✅           │  │    │
│  │  │  Route: /sources   ────► SourcesScreen   ⏳           │  │    │
│  │  │  Route: /saved     ────► SavedScreen     ⏳           │  │    │
│  │  │                                                        │  │    │
│  │  └──────────────────────────────────────────────────────┘  │    │
│  └────────────────────────────────────────────────────────────┘    │
│                                                                      │
│  ┌────────────────────────────────────────────────────────────┐    │
│  │                  HeadlinesScreen.kt ✅                     │    │
│  │  (Composable UI)                                           │    │
│  │                                                             │    │
│  │  Composables:                                              │    │
│  │  • HeadlinesScreen()      - Main screen composable         │    │
│  │  • ArticlesList()         - LazyColumn container           │    │
│  │  • ArticleItem()          - Individual article card        │    │
│  │                                                             │    │
│  │  State:                                                     │    │
│  │  • Observes HeadlinesUiState via StateFlow                 │    │
│  │  • Handles loading, error, and success states              │    │
│  │                                                             │    │
│  │  User Actions:                                             │    │
│  │  • Click article  → onArticleClick(article)                │    │
│  │  • Click save     → viewModel.saveArticle(article)         │    │
│  └────────────────────────────────────────────────────────────┘    │
│                                                                      │
└─────────────────────────────────────────────────────────────────────┘
                                  │
                                  │ Observes StateFlow
                                  │
                                  ▼
┌─────────────────────────────────────────────────────────────────────┐
│                         BUSINESS LOGIC LAYER                         │
├─────────────────────────────────────────────────────────────────────┤
│                                                                      │
│  ┌────────────────────────────────────────────────────────────┐    │
│  │               HeadlinesViewModel.kt ✅                     │    │
│  │  (@HiltViewModel)                                          │    │
│  │                                                             │    │
│  │  State Management:                                         │    │
│  │  • private val _uiState: MutableStateFlow                  │    │
│  │  • val uiState: StateFlow<HeadlinesUiState>                │    │
│  │                                                             │    │
│  │  Data Model:                                               │    │
│  │  • HeadlinesUiState(articles, isLoading, error)            │    │
│  │                                                             │    │
│  │  Functions:                                                │    │
│  │  • init { loadSampleData() }        [Currently active]     │    │
│  │  • loadSampleData()                 [Currently active]     │    │
│  │  • saveArticle(article)             [TODO: implement]      │    │
│  │                                                             │    │
│  │  Future Integration Points:                                │    │
│  │  • ArticleRepository injection      [TODO]                 │    │
│  │  • loadArticles() from API          [TODO]                 │    │
│  │  • Error handling & retry           [TODO]                 │    │
│  └────────────────────────────────────────────────────────────┘    │
│                                                                      │
└─────────────────────────────────────────────────────────────────────┘
                                  │
                                  │ Will use (Future)
                                  │
                                  ▼
┌─────────────────────────────────────────────────────────────────────┐
│                            DATA LAYER                                │
├─────────────────────────────────────────────────────────────────────┤
│                                                                      │
│  ┌────────────────────────────────────────────────────────────┐    │
│  │                   Article.kt ✅                            │    │
│  │  (Data Models)                                             │    │
│  │                                                             │    │
│  │  data class Article(                                       │    │
│  │    title: String,                                          │    │
│  │    description: String?,                                   │    │
│  │    author: String?,                                        │    │
│  │    url: String,                                            │    │
│  │    urlToImage: String?,                                    │    │
│  │    publishedAt: String,                                    │    │
│  │    source: Source                                          │    │
│  │  )                                                          │    │
│  │                                                             │    │
│  │  data class Source(id: String?, name: String)              │    │
│  └────────────────────────────────────────────────────────────┘    │
│                                                                      │
│  ┌────────────────────────────────────────────────────────────┐    │
│  │              Repository Layer (TODO) ⏳                    │    │
│  │                                                             │    │
│  │  • ArticleRepository                                       │    │
│  │    - getArticles(sources): Flow<List<Article>>             │    │
│  │    - saveArticle(article)                                  │    │
│  │    - getSavedArticles(): Flow<List<Article>>               │    │
│  │    - deleteArticle(article)                                │    │
│  └────────────────────────────────────────────────────────────┘    │
│                                                                      │
│  ┌───────────────────────┐      ┌───────────────────────────┐      │
│  │   Remote Data Source  │      │   Local Data Source       │      │
│  │        (TODO) ⏳      │      │       (TODO) ⏳           │      │
│  │                       │      │                           │      │
│  │  • NewsApiService     │      │  • ArticleDao (Room)      │      │
│  │  • Retrofit           │      │  • ArticleDatabase        │      │
│  │  • OkHttp             │      │  • SourcesDataStore       │      │
│  └───────────────────────┘      └───────────────────────────┘      │
│                                                                      │
└─────────────────────────────────────────────────────────────────────┘
```

## Dependency Injection (Hilt)

```
┌─────────────────────────────────────────────────────────────┐
│                  ArticlesApplication ✅                     │
│                  (@HiltAndroidApp)                          │
└─────────────────────────────────────────────────────────────┘
                            │
                            │ Provides dependencies to
                            │
        ┌───────────────────┼───────────────────┐
        │                   │                   │
        ▼                   ▼                   ▼
┌──────────────┐  ┌──────────────────┐  ┌─────────────┐
│  MainActivity│  │ HeadlinesViewModel│  │ Future:     │
│  (@AndroidEn-│  │  (@HiltViewModel) │  │ Repositories│
│   tryPoint)  │  │                   │  │ DataSources │
└──────────────┘  └──────────────────┘  └─────────────┘

Future DI Modules (TODO):
┌────────────────────────────────────────────────────────┐
│  @Module                                               │
│  @InstallIn(SingletonComponent::class)                 │
│                                                         │
│  object NetworkModule {                                │
│    @Provides fun provideRetrofit(): Retrofit           │
│    @Provides fun provideNewsApi(): NewsApiService      │
│  }                                                      │
│                                                         │
│  object DatabaseModule {                               │
│    @Provides fun provideDatabase(): ArticleDatabase    │
│    @Provides fun provideArticleDao(): ArticleDao       │
│  }                                                      │
│                                                         │
│  object DataStoreModule {                              │
│    @Provides fun provideDataStore(): DataStore         │
│  }                                                      │
└────────────────────────────────────────────────────────┘
```

## Navigation Flow

```
App Launch
    │
    ▼
MainActivity
    │
    └──► Bottom Navigation Bar
            │
            ├──► Tab 1: Headlines ✅ (Default)
            │       │
            │       └──► HeadlinesScreen
            │               │
            │               ├──► Click Article → (TODO: WebView)
            │               │
            │               └──► Click Save → saveArticle()
            │
            ├──► Tab 2: Sources ⏳
            │       │
            │       └──► SourcesScreen (Placeholder)
            │
            └──► Tab 3: Saved ⏳
                    │
                    └──► SavedScreen (Placeholder)
```

## Data Flow (Current Implementation)

```
User Opens App
      │
      ▼
MainActivity starts
      │
      ▼
HeadlinesScreen composable renders
      │
      ▼
HeadlinesViewModel initialized (via Hilt)
      │
      ▼
loadSampleData() called in init block
      │
      ▼
_uiState updated with sample articles
      │
      ▼
StateFlow emits new state
      │
      ▼
HeadlinesScreen recomposes with articles
      │
      ▼
ArticlesList shows 5 article cards
      │
      │
User Clicks Article                    User Clicks Save
      │                                       │
      ▼                                       ▼
onArticleClick(article)              viewModel.saveArticle(article)
      │                                       │
      ▼                                       ▼
(TODO: Navigate to WebView)         (TODO: Save to Room DB)
```

## Future Data Flow (With API & Database)

```
User Opens App
      │
      ▼
HeadlinesViewModel.init
      │
      ├──► Load selected sources from DataStore
      │       │
      │       ▼
      ├──► Fetch articles from NewsAPI (Retrofit)
      │       │
      │       ├──► Success → Update _uiState with articles
      │       │
      │       └──► Error → Update _uiState with error message
      │
      └──► UI recomposes automatically via StateFlow

User Clicks Save
      │
      ▼
viewModel.saveArticle(article)
      │
      └──► ArticleRepository.saveArticle()
               │
               └──► Room DAO.insert(articleEntity)
                        │
                        └──► Success → Show "Article saved" toast
```

## Legend

- ✅ = Implemented
- ⏳ = Planned/TODO
- → = Data/control flow
- ▼ = Flow direction

## Package Structure

```
com.medibank.articlesheadlines/
│
├── data/                          (Data Layer)
│   ├── model/                     ✅ Article, Source
│   ├── local/                     ⏳ Room entities, DAOs
│   ├── remote/                    ⏳ API service, DTOs
│   └── repository/                ⏳ Repository implementations
│
├── di/                            ⏳ Hilt modules
│
├── navigation/                    ✅ Navigation setup
│   ├── Screen.kt
│   └── AppNavigation.kt
│
├── ui/                            (Presentation Layer)
│   ├── headlines/                 ✅ Headlines screen & ViewModel
│   ├── sources/                   ⏳ Sources screen
│   ├── saved/                     ⏳ Saved screen
│   ├── detail/                    ⏳ Article detail WebView
│   └── theme/                     ✅ Material theming
│
├── util/                          ⏳ Extension functions, helpers
│
├── ArticlesApplication.kt         ✅ Hilt application
└── MainActivity.kt                ✅ Main activity
```
