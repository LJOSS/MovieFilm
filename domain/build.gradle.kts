plugins {
    id("kotlin")
    id(AppDependencies.Plugins.kotlinter) version "3.13.0"
}

dependencies {

    implementation(AppDependencies.Kotlin.kotlinStdlib)
    implementation(AppDependencies.KotlinX.coroutinesCore)
}
