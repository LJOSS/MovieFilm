plugins {
    id(AppDependencies.Plugins.androidLibrary)
    id(AppDependencies.Plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.data"
    compileSdk = AndroidBuildConfig.compileSdk

    defaultConfig {
        minSdk = AndroidBuildConfig.minSdk
        targetSdk = AndroidBuildConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            buildConfigField("String", "API_URL", "\"https://api.themoviedb.org/\"")
            buildConfigField("String", "API_KEY", "\"c9856d0cb57c3f14bf75bdc6c063b8f3\"")
        }
        getByName("debug") {
            buildConfigField("String", "API_URL", "\"https://api.themoviedb.org/\"")
            buildConfigField("String", "API_KEY", "\"c9856d0cb57c3f14bf75bdc6c063b8f3\"")
        }
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}

dependencies {

    implementation(project(":common"))

    // Network - I recommend not updating retrofit and okhttp as it might result in issues that I've experienced
    implementation(AppDependencies.Networking.Retrofit.retrofit)
    implementation(AppDependencies.Networking.Retrofit.retrofitCoroutines)
    implementation(AppDependencies.Networking.Retrofit.retrofitMoshi)
    implementation(AppDependencies.Networking.OkHttp.okhttpLogging)
    implementation(AppDependencies.Networking.OkHttp.okhttp)

    // Koin
    implementation(AppDependencies.Koin.koinCore)
    implementation(AppDependencies.Koin.koinAndroid)
    implementation(AppDependencies.Koin.koinAndroidxNavigation)

    // Coroutines
    implementation(AppDependencies.KotlinX.coroutinesCore)
    implementation(AppDependencies.KotlinX.coroutinesAndroid)
    implementation(AppDependencies.KotlinX.coroutinesPlayServices)

    // Using moshi for response de-serialization and kotlin serialization for Room
    implementation(AppDependencies.Moshi.moshiAdapters)
    implementation(AppDependencies.Moshi.moshiKotlin)
    implementation(AppDependencies.Moshi.moshiLibrary)

}