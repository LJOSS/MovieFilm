# MovieFilm Application

Application include two screens. First one is list of the movies and the second one is movie details.

## Project architecture

The project is following the Clean architecture principles. There are 4 modules that refers to
architecture layers:

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
