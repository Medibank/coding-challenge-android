# Articles Headlines App - Implementation

This is a proof of concept for an app that displays trending articles with the capability to save news for reading later.

## What's Implemented

### 1. Landing Screen - Headlines

The **Headlines screen** is the first landing screen of the app, displaying a list of article headlines. This implementation includes:

#### Features:
- **Article List Display**: Shows a scrollable list of article cards
- **Article Card Components**: Each article displays:
  - Title (truncated to 2 lines max)
  - Description (truncated to 2 lines max)
  - Author name
  - Source name with color highlighting
  - Thumbnail image loaded via Coil
  - Save button with bookmark icon
- **Sample Data**: Includes 5 sample articles to demonstrate the UI
- **Clickable Articles**: Articles can be clicked to open (navigation prepared for webview)
- **Save Functionality**: Save button prepared for persistence (Room database integration point ready)

#### Architecture:
- **MVVM Pattern**: 
  - `HeadlinesScreen` (View): Composable UI
  - `HeadlinesViewModel` (ViewModel): State management with StateFlow
  - `Article` (Model): Data model

- **Reactive UI**: Uses Kotlin Flow's StateFlow for reactive updates
- **State Management**: `HeadlinesUiState` manages loading, error, and success states

### 2. Navigation Structure

- **Bottom Navigation Bar** with 3 tabs:
  1. **Headlines** (implemented with full UI)
  2. **Sources** (placeholder screen)
  3. **Saved** (placeholder screen)

- **Jetpack Navigation Component** for tab navigation with state preservation

### 3. Technical Stack

#### Core Technologies:
- **Jetpack Compose**: Modern declarative UI framework
- **Material 3**: Latest Material Design components
- **Kotlin Coroutines & Flow**: Asynchronous programming
- **Hilt**: Dependency injection
- **ViewModel & StateFlow**: Reactive state management
- **Navigation Component**: App navigation

#### Libraries Configured:
- **Retrofit**: API calls (ready for NewsAPI integration)
- **Room**: Local database (configured for saved articles)
- **DataStore**: Preferences storage (for source selections)
- **Coil**: Image loading
- **Accompanist WebView**: Article reading

### 4. Code Structure

```
app/src/main/java/com/medibank/articlesheadlines/
├── ArticlesApplication.kt          # Hilt application class
├── MainActivity.kt                 # Main activity with bottom navigation
├── data/
│   └── model/
│       └── Article.kt              # Data models (Article, Source)
├── navigation/
│   ├── Screen.kt                   # Navigation destinations
│   └── AppNavigation.kt            # Navigation graph
├── ui/
│   ├── headlines/
│   │   ├── HeadlinesScreen.kt      # Headlines UI composables
│   │   └── HeadlinesViewModel.kt   # Headlines business logic
│   ├── sources/
│   │   └── SourcesScreen.kt        # Sources placeholder
│   ├── saved/
│   │   └── SavedScreen.kt          # Saved articles placeholder
│   └── theme/
│       ├── Color.kt                # Color palette
│       ├── Type.kt                 # Typography
│       └── Theme.kt                # App theme
```

### 5. Design Principles Applied

✅ **Modular**: Clear separation of concerns with distinct packages
✅ **Reusable Components**: `ArticleItem` composable can be reused
✅ **Modern Kotlin**: Uses Flow, coroutines, and modern syntax
✅ **MVVM Architecture**: Clean separation between UI and business logic
✅ **Dependency Injection**: Hilt configured for clean dependency management
✅ **Type Safety**: Sealed classes for navigation, data classes for models

## How to Build

### Prerequisites:
- Android Studio Hedgehog (2023.1.1) or later
- JDK 17
- Android SDK 34
- Gradle 8.2+

### Build Instructions:

1. Clone the repository
2. Open in Android Studio
3. Let Gradle sync complete
4. Run on an emulator or physical device (API 24+)

```bash
./gradlew assembleDebug
```

## Next Steps (Not Yet Implemented)

The following features are prepared for but not yet implemented:

1. **API Integration**: 
   - Connect to NewsAPI
   - Fetch real articles
   - Error handling and retry logic

2. **Sources Screen**:
   - Display available news sources
   - Multi-selection with checkboxes
   - Save selections to DataStore

3. **Saved Articles**:
   - Room database implementation
   - Save/delete operations
   - Offline-first architecture

4. **Article WebView**:
   - Accompanist WebView integration
   - Full article reading experience
   - Share functionality

5. **Unit Tests**:
   - ViewModel tests
   - Repository tests
   - UI tests with Espresso

## Sample Data

The Headlines screen currently displays 5 sample articles covering:
- Technology news
- Climate/environment
- Business/finance
- Health/medical
- Science/space

This demonstrates the UI layout and functionality before API integration.

## Key Implementation Details

### Headlines Screen Composable

The screen uses a `LazyColumn` for efficient scrolling and implements three states:
- Loading (shows progress indicator)
- Error (shows error message)
- Success (shows article list)

### Article Item Card

Each article card is a Material 3 `Card` with:
- 80x80dp thumbnail image
- Responsive layout
- Material elevation
- Clickable with ripple effect
- Icon button for saving

### ViewModel Pattern

The ViewModel exposes a single `StateFlow<HeadlinesUiState>` that the UI observes:
```kotlin
val uiState: StateFlow<HeadlinesUiState> = _uiState.asStateFlow()
```

This ensures a single source of truth and reactive UI updates.

## Screenshots

*Note: Screenshots will be available once the app is built and run on a device/emulator.*

The Headlines landing screen will display:
- App title bar
- Scrollable list of 5 article cards
- Bottom navigation with 3 tabs
- Material 3 theming with dynamic colors (Android 12+)
