import com.algokelvin.buildsrc.*

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}
android {
    compileSdkVersion (CoreAndroid.compileVersion)
    buildToolsVersion = CoreAndroid.buildVersion


    defaultConfig {
        minSdkVersion (Sdk.minSdk)
        targetSdkVersion (Sdk.targetSdk)
        versionCode = Version.code
        versionName = Version.versionName

        testInstrumentationRunner = CoreAndroid.testInstrumentationRunner
        consumerProguardFiles (CoreAndroid.consumerRules)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

}

dependencies {
    implementation (AndroidX.appCompat)
    implementation (AndroidX.core)
    implementation (AndroidX.legacy)
    implementation (Room.runtime)
    kapt (Room.compilerRoom)
    implementation (Design.recyclerview)
}
