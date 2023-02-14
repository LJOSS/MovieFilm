plugins {
    id(AppDependencies.Plugins.android)
    id(AppDependencies.Plugins.kotlinAndroid)
    id(AppDependencies.Plugins.navigationSafeargs)
}

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

    signingConfigs {
        getByName("debug") {
            storeFile = file("KS_Movie.jks")
            storePassword = property("KEYSTORE_PASSWORD") as String
            keyAlias = property("KEY_ALIAS") as String
            keyPassword = property("KEY_PASSWORD") as String
        }

        create("release") {
            storeFile = file("KS_Movie.jks")
            storePassword = property("KEYSTORE_PASSWORD") as String
            keyAlias = property("KEY_ALIAS") as String
            keyPassword = property("KEY_PASSWORD") as String
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
        getByName("debug") {
            signingConfig = signingConfigs.getByName("debug")
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

    implementation(AppDependencies.timber)

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
    implementation(AppDependencies.Glide.glide)
    annotationProcessor(AppDependencies.Glide.glideCompiler)
}
