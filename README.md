# MovieFilm Application

Application include two screens, First one is list of the movies and the one is MovieDetails.

## Project architecture

The project is following the Clean architecture principles with Koin DI Library. There are 3 packages that refers to
architecture layers:

- data
- common
- app

## Project technologies

##### Core:

- Kotlin Coroutines
- Kotlin Flow
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
- Custom Paggination solution

## Flavors

There are 2 flavors defined in gradle:

- dev
- prod

## Making APK&AAB

For building APK and AAB call

`./gradlew clean assembleRelease bundleRelease`
