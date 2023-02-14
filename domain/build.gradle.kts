plugins {
    id(AppDependencies.Plugins.androidLibrary)
    id(AppDependencies.Plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.example.domain"
    compileSdk = AndroidBuildConfig.compileSdk

    defaultConfig {
        minSdk = AndroidBuildConfig.minSdk
        targetSdk = AndroidBuildConfig.targetSdk

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {

    implementation(project(":data"))

    implementation(AppDependencies.Kotlin.kotlinStdlib)
    implementation(AppDependencies.KotlinX.coroutinesCore)
}