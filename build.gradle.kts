// Top-level build file where you can add configuration options common to all sub-projects/modules.
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
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
