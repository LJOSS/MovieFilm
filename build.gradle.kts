buildscript {
    repositories {
        google()
        maven("https://plugins.gradle.org/m2/")
        mavenCentral()
    }
    dependencies {
        classpath(AppDependencies.gradle)
        classpath(AppDependencies.Kotlin.kotlin)
        classpath(AppDependencies.AndroidX.navigationSafeArgs)
        classpath(AppDependencies.Plugins.kotlinterPlugin)
    }
}

allprojects {
    repositories {
        google()
        maven("https://plugins.gradle.org/m2/")
        mavenCentral()
    }
}
