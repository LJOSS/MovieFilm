// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        maven("https://maven.fabric.io/public")
        maven("https://plugins.gradle.org/m2/")
        maven("https://jitpack.io")
        mavenCentral()
    }
    dependencies {
        classpath(AppDependencies.gradle)
        classpath(AppDependencies.Kotlin.kotlin)
        classpath(AppDependencies.Kotlin.kotlinSerialization)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
    }
}


tasks.register("clean", Delete::class.java) {
    doLast { }
    delete(rootProject.buildDir)
}