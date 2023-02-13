import Versions.activity_version
import Versions.detektVersion
import Versions.epoxy_version
import Versions.fragment_version
import Versions.koin
import Versions.lifecycle
import Versions.moshi
import Versions.navigation
import Versions.room
import org.gradle.internal.impldep.org.eclipse.jgit.lib.ObjectChecker.type

object AndroidBuildConfig {
    const val buildToolsVersion = "33.0.0"
    const val compileSdk = 33
    const val minSdk = 26
    const val targetSdk = 33
}

object Versions {
    const val koin = "3.1.5"
    const val lifecycle = "2.5.1"
    const val activity_version = "1.6.0"
    const val fragment_version = "1.5.3"
    const val room = "2.4.2"
    const val navigation = "2.5.2"
    const val epoxy_version = "4.6.3"
    const val moshi = "1.8.0"
    const val ben_manesVersion = "0.42.0"
    const val detektVersion = "1.21.0"
}

object AppDependencies {

    const val gradle = "com.android.tools.build:gradle:7.3.0"
    const val timber = "com.jakewharton.timber:timber:5.0.1"

    object Plugins {
        const val android = "com.android.application"
        const val androidLibrary = "com.android.library"
        const val jetbrainsKotlinAndroid = "org.jetbrains.kotlin.android"
        const val kotlinAndroid = "kotlin-android"
        const val kotlinAndroidExtensions = "kotlin-android-extensions"
        const val navigationSafeargs = "androidx.navigation.safeargs"
    }

    object View {
        const val material =
            "com.google.android.material:material:1.5.0"
    }

    object Kotlin {
        const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:1.6.10"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20"
        const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:1.6.10"
    }

    object Moshi {
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
            const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:3.12.1"
            const val okhttp = "com.squareup.okhttp3:okhttp:3.12.1"
        }
    }

    object Koin {
        const val koinCore = "io.insert-koin:koin-core:$koin"
        const val koinAndroid = "io.insert-koin:koin-android:$koin"
    }

    object KotlinX {
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0"
        const val coroutinesPlayServices =
            "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.6.0"
    }

    object AndroidX {
        const val core = "androidx.core:core-ktx:1.9.0"
        const val appcompat = "androidx.appcompat:appcompat:1.5.1"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.1.4"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$navigation"
        const val navigationUI = "androidx.navigation:navigation-ui-ktx:$navigation"
        const val activity = "androidx.activity:activity-ktx:$activity_version"
        const val fragment = "androidx.fragment:fragment-ktx:$fragment_version"

        const val navigationSafeArgs =
            "androidx.navigation:navigation-safe-args-gradle-plugin:$navigation"
        const val recyclerview = "androidx.recyclerview:recyclerview:1.2.1"
        const val multidex = "androidx.multidex:multidex:2.0.1"
    }

    object Lifecycle {
        const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle"
        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle"
        const val commonJava8 = "androidx.lifecycle:lifecycle-common-java8:$lifecycle"
        const val extensions = "androidx.lifecycle:lifecycle-extensions:2.2.0"
        const val process = "androidx.lifecycle:lifecycle-process:$lifecycle"
    }

    object Test {
        const val androidxTestExt_1_1_3 = "androidx.test.ext:junit:1.1.3"
        const val androidxTestExt_1_1_2 = "androidx.test.ext:junit:1.1.2"
        const val androidxTestEspresso = "androidx.test.espresso:espresso-core:3.3.0"
        const val robolectric = "org.robolectric:robolectric:4.3.1"
        const val core = "android.arch.core:core-testing:1.1.1"
        const val assertjCore = "org.assertj:assertj-core:3.11.1"
        const val mock = "io.mockk:mockk:1.12.0"
        const val koinTest = "io.insert-koin:koin-test:$koin"
        const val koinTestJUnit = "io.insert-koin:koin-test-junit4:$koin"
        const val mockwebserver = "com.squareup.okhttp3:mockwebserver:4.9.1"
        const val robolectricGroup = "com.google.auto.service"
        const val robolectricModule = "auto-service"
    }
}