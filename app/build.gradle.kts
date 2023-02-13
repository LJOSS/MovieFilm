import java.io.FileInputStream
import java.util.Properties

plugins {
    id(AppDependencies.Plugins.android)
    id(AppDependencies.Plugins.kotlinAndroid)
    id(AppDependencies.Plugins.navigationSafeargs)
}

val configProps = Properties()

configProps.load(FileInputStream(rootProject.file("project.properties")))

android {
    namespace = "com.example.movie_project"
    compileSdk = AndroidBuildConfig.compileSdk

    defaultConfig {
        applicationId = "com.example.movie_project"

        versionCode = 1
        versionName = "1"
        minSdk = AndroidBuildConfig.minSdk
        targetSdk = AndroidBuildConfig.targetSdk

        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    signingConfigs {
        getByName("debug") {
            storeFile = file("KS_Movie.jks")
            storePassword = configProps.getProperty("KEYSTORE_PASSWORD")
            keyAlias = configProps.getProperty("KEY_ALIAS")
            keyPassword = configProps.getProperty("KEY_PASSWORD")
        }

        create("release") {
            storeFile = file("KS_Movie.jks")
            storePassword = configProps.getProperty("KEYSTORE_PASSWORD")
            keyAlias = configProps.getProperty("KEY_ALIAS")
            keyPassword = configProps.getProperty("KEY_PASSWORD")
        }
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(AppDependencies.Kotlin.kotlinStdlib)
    implementation(project(":data"))
    implementation(project(":common"))

    // Lifecycle
    implementation(AppDependencies.Lifecycle.viewmodel)
    implementation(AppDependencies.Lifecycle.livedata)
    implementation(AppDependencies.Lifecycle.runtime)

    implementation(AppDependencies.AndroidX.constraintlayout)
    implementation(AppDependencies.AndroidX.core)
    implementation(AppDependencies.AndroidX.appcompat)
    implementation(AppDependencies.AndroidX.activity)
    implementation(AppDependencies.AndroidX.swipeRefresh)
    implementation(AppDependencies.View.material)

    implementation(AppDependencies.AndroidX.navigationFragment)
    implementation(AppDependencies.AndroidX.navigationUI)

    // Koin
    implementation(AppDependencies.Koin.koinCore)
    implementation(AppDependencies.Koin.koinAndroid)

    // Coroutines
    implementation(AppDependencies.KotlinX.coroutinesCore)

    // View
    implementation(AppDependencies.AndroidX.recyclerview)

    // Glide
    implementation (AppDependencies.Glide.glide)
    annotationProcessor (AppDependencies.Glide.glideCompiler)
}
