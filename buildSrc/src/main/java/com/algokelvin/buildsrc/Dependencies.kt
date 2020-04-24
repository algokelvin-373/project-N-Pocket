package com.algokelvin.buildsrc

const val kotlin_version = "1.3.61"
const val room_version = "2.2.5"

object Sdk {
    const val minSdk = 14
    const val targetSdk = 29
}

object Version {
    const val code = 1
    const val versionName = "1.0.0"
}

object CoreAndroid {
    const val compileVersion = 29
    const val buildVersion = "29.0.2"
    const val IdApps = "com.algokelvin.n_pocket"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val consumerRules= "consumer-rules.pro"
}

object Kotlin {
    const val jetbrains = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
}

object AndroidX {
    const val appCompat = "androidx.appcompat:appcompat:1.1.0"
    const val core = "androidx.core:core-ktx:1.2.0"
    const val legacy = "androidx.legacy:legacy-support-v4:1.0.0"
    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:2.2.0"
}

object Design {
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
    const val material = "com.google.android.material:material:1.1.0"
    const val recyclerview = "androidx.recyclerview:recyclerview:1.1.0"
}

object Room {
    const val runtime = "androidx.room:room-runtime:$room_version"
    const val compilerRoom = "androidx.room:room-compiler:$room_version"
}

object Module {
    const val utils = ":utils"
}