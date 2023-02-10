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
    const val libphonenumber = "com.googlecode.libphonenumber:libphonenumber:8.12.3"
    const val jwtDecode = "com.auth0.android:jwtdecode:2.0.1"
    const val mixpanel = "com.mixpanel.android:mixpanel-android:6.1.0"
    const val detektFormatting = "io.gitlab.arturbosch.detekt:detekt-formatting:${detektVersion}"

    object Plugins {
        const val android = "com.android.application"
        const val androidLibrary = "com.android.library"
        const val jetbrainsKotlinAndroid = "org.jetbrains.kotlin.android"
        const val kotlinAndroid = "kotlin-android"
        const val kotlinAndroidExtensions = "kotlin-android-extensions"
        const val kotlinKapt = "kotlin-kapt"
        const val navigationSafeargs = "androidx.navigation.safeargs"
        const val googleServices = "com.google.gms.google-services"
        const val crashlytics = "com.google.firebase.crashlytics"
        const val kotlinPluginSerialization = "org.jetbrains.kotlin.plugin.serialization"
        const val ben_manesVersions = "com.github.ben-manes.versions"
        const val detekt = "io.gitlab.arturbosch.detekt"
    }

    object Google {
        object Firebase {
            const val bom = "com.google.firebase:firebase-bom:29.2.0"
            const val analytics = "com.google.firebase:firebase-analytics-ktx"
            const val crashlytics = "com.google.firebase:firebase-crashlytics-ktx"
            const val crashlyticsGradle = "com.google.firebase:firebase-crashlytics-gradle:2.9.1"
            const val googleGMS = "com.google.gms:google-services:4.3.13"
            const val messaging = "com.google.firebase:firebase-messaging:23.0.6"
            const val location = "com.google.android.gms:play-services-location:19.0.1"
        }

        object Maps {
            const val androidMaps = "com.google.maps.android:maps-ktx:3.2.1"
            const val mapsServices = "com.google.android.gms:play-services-maps:18.1.0"
        }

        const val guava = "com.google.guava:guava:29.0-android"
        const val guavaAvoid =
            "com.google.guava:listenablefuture:9999.0-empty-to-avoid-conflict-with-guava"
    }

    object View {
        const val swipeLayout = "com.daimajia.swipelayout:library:1.2.0@aar"
        const val blurView = "com.eightbitlab:blurview:1.6.3"
        const val flexBox = "com.google.android:flexbox:2.0.1"
        const val scaleImage =
            "com.davemorrissey.labs:subsampling-scale-image-view:3.10.0"
        const val bouncycastle =
            "org.bouncycastle:bcprov-jdk14:1.70"
        const val material =
            "com.google.android.material:material:1.5.0"
    }

    object Kotlin {
        const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:1.6.10"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20"
        const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:1.6.10"
        const val kotlinXSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2"
    }

    object Autobindings {
        const val autobindingsRoom = "io.github.kaustubhpatange:autobindings-room:1.1-beta05"
        const val autobindingsCompiler =
            "io.github.kaustubhpatange:autobindings-compiler:1.1-beta05"
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

    object Airbnb {
        const val epoxy = "com.airbnb.android:epoxy:$epoxy_version"
        const val epoxyProcessor = "com.airbnb.android:epoxy-processor:$epoxy_version"
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
        const val splashScreen = "androidx.core:core-splashscreen:1.0.0"
        const val appcompat = "androidx.appcompat:appcompat:1.5.1"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.1.4"
        const val work = "androidx.work:work-runtime-ktx:2.7.1"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$navigation"
        const val navigationUI = "androidx.navigation:navigation-ui-ktx:$navigation"
        const val activity = "androidx.activity:activity-ktx:$activity_version"
        const val fragment = "androidx.fragment:fragment-ktx:$fragment_version"

        const val navigationSafeArgs =
            "androidx.navigation:navigation-safe-args-gradle-plugin:$navigation"
        const val roomRuntime = "androidx.room:room-runtime:$room"
        const val roomCompiler = "androidx.room:room-compiler:$room"
        const val roomKtx = "androidx.room:room-ktx:$room"
        const val recyclerview = "androidx.recyclerview:recyclerview:1.2.1"
        const val multidex = "androidx.multidex:multidex:2.0.1"
        const val excludeRoom = "org.xerial"
        const val sqliteJdbc = "org.xerial:sqlite-jdbc:3.36.0.3"
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