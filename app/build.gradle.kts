import com.algokelvin.buildsrc.*

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion (CoreAndroid.compileVersion)
    buildToolsVersion = CoreAndroid.buildVersion
    defaultConfig {
        applicationId = CoreAndroid.IdApps
        minSdkVersion (Sdk.minSdk)
        targetSdkVersion (Sdk.targetSdk)
        versionCode = Version.code
        versionName = Version.versionName
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = CoreAndroid.testInstrumentationRunner
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation (Kotlin.jetbrains)
    implementation (Design.material)
    implementation (Design.constraintLayout)
    implementation (AndroidX.lifecycle)

    implementation (project(Module.utils))
}
