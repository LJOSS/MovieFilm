plugins {
    id(AppDependencies.Plugins.kotlin)
    id(AppDependencies.Plugins.kotlinter)
}

extensions.configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
}

dependencies {

    implementation(AppDependencies.Kotlin.kotlinStdlib)
    implementation(AppDependencies.KotlinX.coroutinesCore)
}
