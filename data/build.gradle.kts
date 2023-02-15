plugins {
    id(AppDependencies.Plugins.androidLibrary)
    id(AppDependencies.Plugins.jetbrainsKotlinAndroid)
    id(AppDependencies.Plugins.kotlinter) version "3.13.0"
}

android {
    namespace = "com.example.data"
    compileSdk = AndroidBuildConfig.compileSdk

    defaultConfig {
        minSdk = AndroidBuildConfig.minSdk
        targetSdk = AndroidBuildConfig.targetSdk
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
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(AppDependencies.Networking.Retrofit.retrofit)
    implementation(AppDependencies.Networking.Retrofit.retrofitCoroutines)
    implementation(AppDependencies.Networking.Retrofit.retrofitMoshi)
    implementation(AppDependencies.Networking.OkHttp.okHttpLogging)
    implementation(AppDependencies.Networking.OkHttp.okHttp)

    implementation(AppDependencies.Koin.koinCore)
    implementation(AppDependencies.Koin.koinAndroid)

    implementation(AppDependencies.KotlinX.coroutinesCore)

    implementation(AppDependencies.Moshi.moshiAdapters)
    implementation(AppDependencies.Moshi.moshiKotlin)
    implementation(AppDependencies.Moshi.moshiLibrary)
}
