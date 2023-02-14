plugins {
    id(AppDependencies.Plugins.androidLibrary)
    id(AppDependencies.Plugins.jetbrainsKotlinAndroid)
    id(AppDependencies.Plugins.kotlinAndroid)
    id(AppDependencies.Plugins.navigationSafeargs)
}

android {
    namespace = "com.example.presentation"
    compileSdk = AndroidBuildConfig.compileSdk

    defaultConfig {
        minSdk = AndroidBuildConfig.minSdk
        targetSdk = AndroidBuildConfig.targetSdk

        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true
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
    implementation(project(":domain"))

    implementation(AppDependencies.timber)

    implementation(AppDependencies.Lifecycle.viewmodel)

    implementation(AppDependencies.AndroidX.constraintLayout)
    implementation(AppDependencies.AndroidX.core)
    implementation(AppDependencies.AndroidX.appCompat)
    implementation(AppDependencies.AndroidX.activity)
    implementation(AppDependencies.AndroidX.swipeRefresh)
    implementation(AppDependencies.View.material)

    implementation(AppDependencies.AndroidX.navigationFragment)
    implementation(AppDependencies.AndroidX.navigationUi)

    implementation(AppDependencies.Koin.koinCore)
    implementation(AppDependencies.Koin.koinAndroid)

    implementation(AppDependencies.KotlinX.coroutinesCore)

    implementation(AppDependencies.AndroidX.recyclerView)

    implementation(AppDependencies.Glide.glide)
    annotationProcessor(AppDependencies.Glide.glideCompiler)
}
