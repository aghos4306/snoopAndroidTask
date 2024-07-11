# Catify Android App
## Overview
Catify is an Android application that displays a list of cat breeds with detailed information about each breed. Users can browse the list of cats, view detailed information about each cat, and mark their favorite cats. The application follows the clean architecture principles, using MVVM (Model-View-ViewModel) design pattern, Dagger-Hilt for dependency injection, and Retrofit for network requests.
## Features
- Display a list of cat breeds.
- View detailed information about each cat breed.
- Mark and unmark cats as favorites.
- Persist favorite status even after the app is closed and restarted.
- Clean architecture with MVVM design pattern.
- Use of Jetpack Compose for UI.
## Technologies Used
- Kotlin
- Jetpack Compose
- Dagger-Hilt
- Retrofit
- SharedPreferences
- Coil for image loading
- Coroutines and Flow
- JUnit and Mockito for testing
## Architecture
- **Presentation Layer**: Contains UI components and ViewModels.
- **Domain Layer**: Contains use cases and business logic.
- **Data Layer**: Contains repositories and data sources (local and remote).
## Getting Started
### Prerequisites
- Android Studio Bumblebee or higher
- Kotlin 1.5.21 or higher
- Gradle 7.0.2 or higher
### Installation
- Clone the repository

   ```sh
   git clone https://github.com/aghos4306/catify.git
   cd catify
- Open the project in Android Studio.
- Add your Cat API key in local.properties CAT_API_KEY=your_api_key_here
- Build and run the project
  ```sh
  ./gradlew build

### Run Test
- Run test using the command on Android studio
  ```sh
  ./gradlew test

### Assumption
- If it was a production app, I will write viewmodel test, end to end test

### Acknowledgement
- TheCatApi for providing the cat data


