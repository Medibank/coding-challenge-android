# Articles Headlines App

Create a proof of concept for an App that displays trending articles and allows the user to save the news for reading later.

## Requirements

### App Architecture
- Build the app using **Jetpack Compose** for UI, with **MVVM architecture** for clean separation of concerns.

### Main Navigation
- Use a bottom navigation bar with 3 tabs: **Headlines, Sources, Saved**.
  - **Headlines**: Screen to display a list of headlines based on user-selected sources, each item displaying (title, description, author, thumbnail picture).
    - Tapping on an item opens the headline URL to read the full article within the app using **Accompanist Webview**.
    - Allow users to save articles for later reading.
  - **Sources**: Screen to display a list of available sources for articles, allowing multiple selections with persistent user session storage using **DataStore**.
  - **Saved**: Screen to show a list of saved headlines. Tapping an item opens the article for reading, similar to the Headlines screen.
    - Enable deletion of saved articles.
    - Ensure persistence of saved articles across app launches using **Room Database**.

### API Integration
- Use [NewsAPI](https://newsapi.org/) API for fetching data. Use **Retrofit** for API calls, managed through **ViewModels** and observed using **LiveData** or **StateFlow**.

## Key Points Under Evaluation
- Design and implement an app that can achieve all of the goals described above
- Highly modular
- Use of modern Kotlin syntax
- Reuse of components
- Simple and concise code and project structure
- Unit testing, provide coverage of important areas in the code
- Use of modern Kotlin features and coroutines for asynchronous tasks.
- Implement navigation using the **Jetpack Navigation Component**.
- UI built entirely with **Jetpack Compose**.
- Effective use of **ViewModels and LiveData/StateFlow** for reactive UI updates.
- Reusable components in Jetpack Compose.
- Clear and concise code and project structure.
- Emphasis on a good user experience.
- Comprehensive unit testing with **JUnit** and **Espresso** for UI testing.
- Documentation of key architectural choices and code functionalities.
- Use **Hilt** for dependency injection to manage dependencies cleanly and effectively.

## Use of AI 
- You are free to use any tools you like, including AI code generators such as ChatGPT or GitHub Copilot. We encourage you to work however you’re most comfortable. Just be sure you understand your final solution — we’ll review and discuss your choices together in a live code review.


## Points of Consideration
- Pagination is not required, API will return only the latest 10 articles per source
- Documentation for the API [https://newsapi.org/#documentation](https://newsapi.org/#documentation)
- Filter sources to be only for the English language
- A note on the usage of certain Libraries, you can use libraries you would normally use in a real project, however, use good judgment when deciding which ones, for example, using a NewsAPI client is not acceptable

## Allocated Time
- Submission is due no more than 3 days after receipt.
- After completing the project, compress it and send it via email to your recruiter, ensuring to exclude redundant build or generated files to minimize the size of the compressed file.
