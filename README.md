# MovieFilm Application

Application includes two screens: the first one is a list of movies and the second one is movie details.

## Project architecture

The project is following Clean architecture principles with Koin DI library.
There are 4 modules that represent architecture layers:

- app
- presentation
- domain
- data

## Project technologies

##### Core:

- Kotlin Coroutines
- Kotlin Flow
- Koin

##### DI:

- Koin

##### Data:

- OkHttp3
- Retrofit
- Moshi

##### UI and navigation:

- MVVM
- ViewBinding
- Navigation Component
- Glide
- Custom Pagination solution

##### Code checkers:

- kotlinter
- lint

## Building APK & AAB

For building Release APK and AAB call

`./gradlew clean assembleRelease bundleRelease`
