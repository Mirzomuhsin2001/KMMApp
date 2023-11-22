plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("maven-publish")
}

group = "com.muhsin.mysharedlib"
version = "1.0.5"

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    android {
        publishLibraryVariants("release", "debug")
//        publishLibraryVariantsGroupedByFlavor = true
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
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
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
    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }
}
