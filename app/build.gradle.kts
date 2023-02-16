plugins {
    id(AppDependencies.Plugins.android)
    id(AppDependencies.Plugins.kotlinAndroid)
    id(AppDependencies.Plugins.jetbrainsKotlinAndroid)
    id(AppDependencies.Plugins.kotlinter)
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

        vectorDrawables.useSupportLibrary = true
    }

    signingConfigs {
        getByName("debug") {
            storeFile = file(property("KEYSTORE_FILE") as String)
            storePassword = property("KEYSTORE_PASSWORD") as String
            keyAlias = property("KEY_ALIAS") as String
            keyPassword = property("KEY_PASSWORD") as String
        }

        create("release") {
            storeFile = file(property("KEYSTORE_FILE") as String)
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
            applicationIdSuffix = ".prod"
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

    lint {
        abortOnError = true
        checkAllWarnings = true
        disable += setOf(
            "AllowBackup",
            "ContentDescription",
            "InvalidPackage",
            "SpUsage",
            "IconMissingDensityFolder",
            "SelectableText",
            "RtlCompat",
            "RtlEnabled",
            "RtlHardcoded",
            "RtlSymmetry",
            "MissingPrefix",
            "MissingRegistered",
            "LockedOrientationActivity",
        )
    }

    kotlinter {
        ignoreFailures = false
        reporters = arrayOf("checkstyle", "plain")
        experimentalRules = false
        disabledRules = emptyArray()
    }
}

dependencies {

    implementation(project(":data"))
    implementation(project(":presentation"))
    implementation(project(":domain"))

    implementation(AppDependencies.Kotlin.kotlinStdlib)
    implementation(AppDependencies.KotlinX.coroutinesCore)
    implementation(AppDependencies.Koin.koinCore)
    implementation(AppDependencies.Koin.koinAndroid)
}
