
plugins {
    id(AppDependencies.Plugins.android)
    id(AppDependencies.Plugins.kotlinAndroid)
    id(AppDependencies.Plugins.navigationSafeargs)
}

android {
    namespace = "com.example.movie_project"
    buildToolsVersion = AndroidBuildConfig.buildToolsVersion
    compileSdk = AndroidBuildConfig.compileSdk

    defaultConfig {
        applicationId = "com.example.movie_project"
        // release and test apks are build using Bitrise CI. The versionCode calculation and versionName calculation
        // is found in the first two scripts of the pipeline using VERSION_MAJOR, VERSION_MINOR, VERSION_PATCH env. variables.
        versionCode = 1
        versionName = "1"
        minSdk = AndroidBuildConfig.minSdk
        targetSdk = AndroidBuildConfig.targetSdk

        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // Base dependencies
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(AppDependencies.Kotlin.kotlinStdlib)
    implementation(project(":data"))
    implementation(project(":common"))

    // Lifecycle
    implementation(AppDependencies.Lifecycle.viewmodel)
    implementation(AppDependencies.Lifecycle.livedata)
    implementation(AppDependencies.Lifecycle.runtime)
    implementation(AppDependencies.Lifecycle.commonJava8)
    implementation(AppDependencies.Lifecycle.process)

    implementation(AppDependencies.AndroidX.constraintlayout)
    implementation(AppDependencies.AndroidX.core)
    implementation(AppDependencies.AndroidX.appcompat)
    implementation(AppDependencies.AndroidX.activity)
    implementation(AppDependencies.View.material)

    implementation(AppDependencies.AndroidX.navigationFragment)
    implementation(AppDependencies.AndroidX.navigationUI)

    // Network - I recommend not updating retrofit and okhttp as it might result in issues that I've experienced
    implementation(AppDependencies.Networking.Retrofit.retrofit)
    implementation(AppDependencies.Networking.Retrofit.retrofitCoroutines)
    implementation(AppDependencies.Networking.Retrofit.retrofitMoshi)
    implementation(AppDependencies.Networking.OkHttp.okhttpLogging)
    implementation(AppDependencies.Networking.OkHttp.okhttp)

    // Using moshi for response de-serialization and kotlin serialization for Room
    implementation(AppDependencies.Moshi.moshiAdapters)
    implementation(AppDependencies.Moshi.moshiKotlin)

    // Koin
    implementation(AppDependencies.Koin.koinCore)
    implementation(AppDependencies.Koin.koinAndroid)

    // Coroutines
    implementation(AppDependencies.KotlinX.coroutinesCore)
    implementation(AppDependencies.KotlinX.coroutinesAndroid)
    implementation(AppDependencies.KotlinX.coroutinesPlayServices)

    // View
    implementation(AppDependencies.AndroidX.fragment)
    implementation(AppDependencies.AndroidX.recyclerview)

    // Other
    implementation(AppDependencies.AndroidX.multidex)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    implementation ("com.github.bumptech.glide:glide:4.14.2")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.14.2")
}
