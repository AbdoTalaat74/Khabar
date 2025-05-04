# KhaBar
## Overview
**NewsFlow** is a cutting-edge Android application that delivers the latest news from around the world directly to your fingertips. Powered by News API, this app ensures users stay informed with breaking headlines and top stories anytime, anywhere.
---
## Features
- **Real-time News Updates**: Access the latest news articles as they're published.
- **Customizable News Sources**: Choose from a variety of reputable news outlets.
- **Category Filtering**: Browse news by categories such as business, technology, sports, entertainment, and more.
- **Search Functionality**: Find specific news stories with powerful search capabilities.
- **Offline Reading**: Save articles for offline access when you're not connected.
- **Bookmarking**: Save your favorite articles for later reading.
- **Sleek User Interface**: Enjoy a modern, intuitive design built with Jetpack Compose.
- **Efficient Pagination**: Smoothly scroll through large sets of news articles.
---
## Tech Stack
### 🚠 Architectural Pattern
- **Clean Architecture**: 
  - Organized into Data, Domain, and Presentation layers.
  - Clear separation of concerns for improved maintainability and testability.
- **MVVM (Model-View-ViewModel)**: 
  - Separates UI from business logic.
  - Enables reactive UI updates based on state changes.
- **MVI (Model-View-Intent)**:
  - Ensures predictable and unidirectional data flow.
  - Efficiently manages complex UI states.

### 💻 UI Framework
- **Jetpack Compose**: 
  - For building a responsive, declarative, and modern UI.

### 📊 Data Management
- **Paging 3**: 
  - Efficiently handles large datasets with seamless pagination.
  - Improves app performance and user experience.
- **Room Database**: 
  - Provides robust local storage with SQLite abstraction.
  - Enables effective offline data handling.
- **DataStore Preferences**: 
  - Modern solution for storing key-value pairs.
  - Asynchronous data management.

### 🌐 Networking
- **Retrofit**: 
  - Type-safe HTTP client for Android.
  - Efficient API communication with News API.

### ⚙️ Dependency Injection
- **Dagger Hilt**: 
  - Simplifies dependency management.
  - Improves code modularity and testability.
---
## Installation
### Prerequisites
- Android Studio `Arctic Fox` or newer.
- Minimum Android SDK level: `21`.
### Steps to Run the App
1. Clone this repository.
2. Open the project in Android Studio.
3. Sync the project to download dependencies.
4. Run the app on an emulator or a physical device.
### Download
You can download the app directly from:
[NewsFlow App Download](https://drive.google.com/file/d/1DskOg-_iszg2mAzxPn8aMpqX6iB1jH5i/view)
---
## Folder Structure
```
├── data
│   ├── repository   # Data sources implementation
│   ├── remote       # API service and response models
│   ├── local        # Room database for caching
│   ├── paging       # Paging source implementations
├── domain
│   ├── model        # Business models
│   ├── repository   # Repository interfaces
│   ├── usecase      # Application business logic
├── presentation
│   ├── ui           # Composables and screens
│   ├── viewmodel    # State and logic management
│   ├── state        # UI state representations
│   ├── intent       # User actions/intents
├── di               # Dependency injection modules
└── utils            # Helper classes and functions
```

## Screenshots
<img src="https://github.com/user-attachments/assets/335bf5d4-a65e-4409-8298-f75d10c2e66a" alt="description" width="200"/>

<img src="https://github.com/user-attachments/assets/ce123db4-8ee4-4e12-9b46-d50154022c0d" alt="description" width="200"/>

<img src="https://github.com/user-attachments/assets/a2fab098-96be-4f7d-bd73-d5e945363e6f" alt="description" width="200"/>




---
## Acknowledgements
- **News Api**: For providing the food recipe API.
- **Google**: For Jetpack Compose and Android architecture guidelines.
---
## Contact
For any inquiries, please reach out to:
- **Abdelrahman Talaat**
- Email: abdelrahmant.dev@gmail.com
- GitHub: https://github.com/AbdoTalaat74
