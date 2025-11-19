# Articles Headlines App - First Screen Implementation

This is the implementation of the first screen (Headlines Screen) for the Articles Headlines Android application.

## What's Implemented

### 1. Project Structure
- ✅ Android project with Jetpack Compose
- ✅ MVVM architecture
- ✅ Hilt for dependency injection
- ✅ Gradle build configuration

### 2. Headlines Screen
- ✅ Display list of articles from NewsAPI
- ✅ Each article shows: title, description, author, thumbnail
- ✅ Click on article opens WebView with full article
- ✅ Save button on each article (UI ready, persistence pending)
- ✅ Loading, error, and empty states
- ✅ Pull-to-refresh functionality

### 3. Architecture Components
- ✅ Domain models (Article)
- ✅ Data layer with Repository pattern
- ✅ Retrofit integration for NewsAPI
- ✅ ViewModel with StateFlow for reactive UI
- ✅ Dependency injection with Hilt

### 4. Testing
- ✅ Unit tests for HeadlinesViewModel
- ✅ Test coverage for success, error, and loading states

## Setup Instructions

### 1. API Key Configuration
You need to get a free API key from [NewsAPI](https://newsapi.org/):

1. Sign up at https://newsapi.org/register
2. Copy your API key
3. Open `app/src/main/java/com/medibank/articlesheadlines/data/repository/ArticlesRepositoryImpl.kt`
4. Replace `YOUR_API_KEY_HERE` with your actual API key

### 2. Build the Project
```bash
./gradlew build
```

### 3. Run the App
```bash
./gradlew installDebug
```

Or open the project in Android Studio and run it.

## What's Working

- **Headlines Screen**: Displays articles from BBC News as a default source
- **Article List**: Shows title, description, author, and thumbnail image
- **WebView Integration**: Click on any article to view it in a WebView
- **Error Handling**: Displays error message with retry button if API call fails
- **Loading State**: Shows loading indicator while fetching data
- **Material Design 3**: Modern UI with Material 3 components

## Next Steps (Not Yet Implemented)

The following features are planned but not yet implemented:

1. **Sources Screen**: List of available sources with selection capability
2. **Saved Screen**: Display saved articles with delete functionality
3. **Room Database**: Persist saved articles
4. **DataStore**: Persist selected sources
5. **Bottom Navigation**: Navigate between Headlines, Sources, and Saved tabs
6. **Full Navigation**: Jetpack Navigation Component integration

## Technical Stack

- **Language**: Kotlin
- **UI**: Jetpack Compose + Material 3
- **Architecture**: MVVM
- **DI**: Hilt
- **Networking**: Retrofit + OkHttp
- **Image Loading**: Coil
- **WebView**: Accompanist WebView
- **Testing**: JUnit, Mockito, Turbine
- **Async**: Coroutines + StateFlow

## Project Structure

```
app/src/main/java/com/medibank/articlesheadlines/
├── data/
│   ├── model/          # DTOs for API responses
│   ├── remote/         # Retrofit service interfaces
│   └── repository/     # Repository implementations
├── domain/
│   ├── model/          # Domain models
│   └── repository/     # Repository interfaces
├── ui/
│   ├── headlines/      # Headlines screen and ViewModel
│   └── theme/          # Compose theme files
├── di/                 # Hilt modules
├── MainActivity.kt     # Main activity
└── ArticlesHeadlinesApp.kt  # Application class
```

## Notes

- The app currently uses BBC News as the default source
- You'll need a valid NewsAPI key to fetch real data
- The save functionality UI is implemented but persistence is not yet added
- This represents a solid foundation for the complete app
