plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("maven-publish")
}

group = "com.muhsin.mysharedlib"
version = "1.0.0"

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    android {
        publishLibraryVariants("release", "debug")
    }
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
    }
}

publishing {
    repositories {
        maven {
            setUrl("https://maven.pkg.github.com/Mirzomuhsin2001/KMMApp")
            credentials {
                username = "Mirzomuhsin2001"
                password = "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"
            }
        }
    }
}

android {
    namespace = "com.example.kmmapp"
    compileSdk = 33
    defaultConfig {
        minSdk = 21
    }
}
