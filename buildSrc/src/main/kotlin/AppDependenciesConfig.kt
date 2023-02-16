object AndroidBuildConfig {
    const val compileSdk = 33
    const val minSdk = 26
    const val targetSdk = 33
}

object AppDependencies {

    const val gradle = "com.android.tools.build:gradle:7.3.0"
    const val timber = "com.jakewharton.timber:timber:5.0.1"

    object Plugins {
        const val android = "com.android.application"
        const val androidLibrary = "com.android.library"
        const val jetbrainsKotlinAndroid = "org.jetbrains.kotlin.android"
        const val kotlinAndroid = "kotlin-android"
        const val navigationSafeargs = "androidx.navigation.safeargs"
        const val kotlinter = "org.jmailen.kotlinter"
    }

    object View {
        const val material =
            "com.google.android.material:material:1.5.0"
    }

    object Kotlin {
        const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:1.7.10"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20"
        const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:1.7.10"
    }

    object Moshi {
        private const val moshi = "1.8.0"
        const val moshiLibrary = "com.squareup.moshi:moshi:$moshi"
        const val moshiAdapters = "com.squareup.moshi:moshi-adapters:$moshi"
        const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:$moshi"
    }

    object Networking {
        object Retrofit {
            const val retrofit = "com.squareup.retrofit2:retrofit:2.5.0"
            const val retrofitCoroutines =
                "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
            const val retrofitMoshi = "com.squareup.retrofit2:converter-moshi:2.7.2"
        }

        object OkHttp {
            const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:3.12.1"
            const val okHttp = "com.squareup.okhttp3:okhttp:3.12.1"
        }
    }

    object Koin {
        private const val koin = "3.1.5"
        const val koinCore = "io.insert-koin:koin-core:$koin"
        const val koinAndroid = "io.insert-koin:koin-android:$koin"
    }

    object KotlinX {
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0"
    }

    object AndroidX {
        private const val navigation = "2.5.2"

        const val core = "androidx.core:core-ktx:1.9.0"
        const val appCompat = "androidx.appcompat:appcompat:1.5.1"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$navigation"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:$navigation"
        const val activity = "androidx.activity:activity-ktx:1.6.0"
        const val swipeRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"

        const val navigationSafeArgs =
            "androidx.navigation:navigation-safe-args-gradle-plugin:$navigation"
        const val recyclerView = "androidx.recyclerview:recyclerview:1.2.1"
    }

    object Lifecycle {
        const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"
    }

    object Glide {
        private const val glideVersion = "4.14.2"
        const val glide = "com.github.bumptech.glide:glide:$glideVersion"
        const val glideCompiler = "com.github.bumptech.glide:compiler:$glideVersion"
    }
}