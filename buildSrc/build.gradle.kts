import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

repositories {
    google()
    maven("https://plugins.gradle.org/m2/")
    mavenCentral()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.3.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")
    implementation("org.jmailen.gradle:kotlinter-gradle:3.13.0")
}
