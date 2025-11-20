# Articles Headlines App - Developer Guide

## 📱 What Has Been Implemented

This repository contains the **initial implementation of the Headlines landing screen** for the Articles Headlines app, as described in the [original README](README.md).

### ✅ Completed Features

#### 1. Headlines Landing Screen (Main Feature)
The first screen users see when launching the app:
- **Article List**: Displays 5 sample articles in a scrollable list
- **Article Cards** with:
  - Title (max 2 lines)
  - Description (max 2 lines)
  - Author name
  - Source name (color-highlighted)
  - Thumbnail image (80x80dp)
  - Save button (bookmark icon)
- **Sample Data**: Pre-populated with diverse articles (tech, climate, business, health, science)
- **Click Handling**: Ready for navigation to article webview
- **Save Functionality**: Button ready for Room database integration

#### 2. App Navigation Structure
- **Bottom Navigation Bar** with 3 tabs:
  - 📰 **Headlines** (fully implemented)
  - 📋 **Sources** (placeholder)
  - 🔖 **Saved** (placeholder)
- **Jetpack Navigation Component** configured
- Tab state preservation on navigation

#### 3. Architecture & Code Quality
- ✅ **MVVM Architecture**: Clear separation of UI, ViewModel, and Data layers
- ✅ **Jetpack Compose**: Modern declarative UI
- ✅ **Material 3 Design**: Latest design system
- ✅ **Hilt DI**: Dependency injection configured
- ✅ **StateFlow**: Reactive state management
- ✅ **Kotlin Coroutines**: Async operation support
- ✅ **Clean Code**: Well-organized packages and reusable components

#### 4. Testing
- ✅ **Unit Tests**: 6 test cases for HeadlinesViewModel
- ✅ **Test Coverage**: Initial state, data structure, and business logic

#### 5. Documentation
- ✅ **IMPLEMENTATION.md**: Detailed implementation guide
- ✅ **UI_LAYOUT.md**: Visual layout with ASCII mockup
- ✅ **KDoc Comments**: On all major classes and functions
- ✅ **This File**: Developer setup guide

## 🏗️ Project Structure

```
coding-challenge-android/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/medibank/articlesheadlines/
│   │   │   │   ├── ArticlesApplication.kt        # Hilt Application
│   │   │   │   ├── MainActivity.kt               # Main entry point
│   │   │   │   ├── data/
│   │   │   │   │   └── model/
│   │   │   │   │       └── Article.kt            # Data models
│   │   │   │   ├── navigation/
│   │   │   │   │   ├── Screen.kt                 # Navigation routes
│   │   │   │   │   └── AppNavigation.kt          # NavHost setup
│   │   │   │   └── ui/
│   │   │   │       ├── headlines/
│   │   │   │       │   ├── HeadlinesScreen.kt    # Headlines UI ⭐
│   │   │   │       │   └── HeadlinesViewModel.kt # Headlines logic ⭐
│   │   │   │       ├── sources/
│   │   │   │       │   └── SourcesScreen.kt      # Placeholder
│   │   │   │       ├── saved/
│   │   │   │       │   └── SavedScreen.kt        # Placeholder
│   │   │   │       └── theme/
│   │   │   │           ├── Color.kt              # Color palette
│   │   │   │           ├── Type.kt               # Typography
│   │   │   │           └── Theme.kt              # App theme
│   │   │   ├── res/                              # Resources
│   │   │   └── AndroidManifest.xml
│   │   └── test/
│   │       └── java/.../HeadlinesViewModelTest.kt # Unit tests
│   └── build.gradle.kts                          # App dependencies
├── build.gradle.kts                              # Project config
├── settings.gradle.kts                           # Project settings
├── IMPLEMENTATION.md                             # Implementation details
├── UI_LAYOUT.md                                  # UI layout guide
└── README.md                                     # Original requirements
```

## 🚀 Quick Start

### Prerequisites
- **Android Studio**: Hedgehog (2023.1.1) or later
- **JDK**: 17 or later
- **Android SDK**: API 24+ (min), API 34 (target)
- **Gradle**: 8.2+

### Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/Medibank/coding-challenge-android.git
   cd coding-challenge-android
   ```

2. **Open in Android Studio**
   - File → Open → Select the project directory
   - Wait for Gradle sync to complete

3. **Build the project**
   ```bash
   ./gradlew assembleDebug
   ```

4. **Run tests**
   ```bash
   ./gradlew test
   ```

5. **Run on device/emulator**
   - Click the Run button in Android Studio
   - Or use: `./gradlew installDebug`

## 📸 Expected UI

See [UI_LAYOUT.md](UI_LAYOUT.md) for a detailed visual mockup.

The Headlines screen displays:
```
┌─────────────────────────────────────┐
│  [Image] Article Title             🔖│
│          Description excerpt...     │
│          Source • Author            │
└─────────────────────────────────────┘
```

With bottom navigation showing 3 tabs: Headlines | Sources | Saved

## 🧪 Running Tests

### Unit Tests
```bash
# Run all unit tests
./gradlew test

# Run specific test class
./gradlew test --tests HeadlinesViewModelTest

# Run with coverage
./gradlew testDebugUnitTest jacocoTestReport
```

### Test Coverage
Current tests cover:
- ✅ ViewModel initialization
- ✅ Sample data loading
- ✅ Article data structure validation
- ✅ Business logic (save article)

## 🔧 Tech Stack

### UI Layer
- **Jetpack Compose** - Declarative UI
- **Material 3** - Design system
- **Coil** - Image loading
- **Navigation Compose** - Navigation

### Business Logic Layer
- **ViewModel** - State holder
- **StateFlow** - Reactive streams
- **Kotlin Coroutines** - Async operations
- **Hilt** - Dependency injection

### Data Layer (Prepared)
- **Retrofit** - API calls (ready for NewsAPI)
- **Room** - Local database (ready for saved articles)
- **DataStore** - Preferences (ready for source selections)

### Testing
- **JUnit 4** - Test framework
- **Kotlin Coroutines Test** - Async testing
- **MockK** (ready to add) - Mocking

## 📝 Next Steps

To complete the app according to the original requirements:

### 1. API Integration
```kotlin
// TODO: Create NewsApiService interface
// TODO: Add API key configuration
// TODO: Create ArticleRepository
// TODO: Connect ViewModel to repository
```

### 2. Sources Screen
```kotlin
// TODO: Fetch sources from API
// TODO: Implement multi-selection UI
// TODO: Save selections to DataStore
// TODO: Filter articles by selected sources
```

### 3. Saved Articles
```kotlin
// TODO: Create Room database entities
// TODO: Implement DAO for CRUD operations
// TODO: Update HeadlinesViewModel.saveArticle()
// TODO: Implement SavedScreen with database query
```

### 4. Article WebView
```kotlin
// TODO: Create ArticleDetailScreen with WebView
// TODO: Add navigation argument passing
// TODO: Implement back navigation
```

### 5. Enhanced Testing
```kotlin
// TODO: Add Repository tests
// TODO: Add UI tests with Compose Testing
// TODO: Add integration tests
// TODO: Increase coverage to >80%
```

## 🎯 Code Highlights

### Reusable Components
The `ArticleItem` composable is designed to be reused across Headlines and Saved screens:
```kotlin
@Composable
fun ArticleItem(
    article: Article,
    onClick: () -> Unit,
    onSaveClick: () -> Unit
)
```

### State Management
Clean separation of UI state:
```kotlin
data class HeadlinesUiState(
    val articles: List<Article> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
```

### Dependency Injection
Hilt makes testing and modularization easy:
```kotlin
@HiltViewModel
class HeadlinesViewModel @Inject constructor(
    // Future: private val repository: ArticleRepository
) : ViewModel()
```

## 🤝 Contributing

When adding new features:

1. Follow the existing package structure
2. Add KDoc comments to public APIs
3. Write unit tests for business logic
4. Update this README with new capabilities
5. Keep components small and reusable

## 📚 Additional Documentation

- [IMPLEMENTATION.md](IMPLEMENTATION.md) - Detailed implementation notes
- [UI_LAYOUT.md](UI_LAYOUT.md) - Visual design guide
- [README.md](README.md) - Original requirements

## ⚠️ Known Limitations

- **Network Restrictions**: Build may fail if Google's Maven repository is blocked
- **No API Key**: NewsAPI integration requires adding an API key
- **Sample Data Only**: Currently shows hardcoded data
- **Placeholder Screens**: Sources and Saved tabs show placeholder text

## 📄 License

This is a coding challenge project for Medibank.

---

**Status**: ✅ Phase 1 Complete (Headlines Landing Screen)
**Next**: API Integration & Data Persistence
