val kotlin_version: String by extra
plugins {
    id("com.android.library")
    kotlin("android")
    id("maven-publish")
    id("signing")
}
apply {
    plugin("kotlin-android")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 23
        targetSdk = 32
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
}

dependencies {
    implementation("com.github.terrakok:modo:0.6.4")
    implementation("androidx.compose.ui:ui:1.1.1")
    implementation("androidx.compose.foundation:foundation:1.1.1")
    implementation("org.jetbrains.kotlin:kotlin-parcelize-runtime:1.6.10")
}
repositories {
    mavenCentral()
}