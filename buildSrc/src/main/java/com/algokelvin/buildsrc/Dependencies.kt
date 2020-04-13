package com.algokelvin.buildsrc

const val kotlin_version = "1.3.41"
const val gradle_version = "3.5.3"

object Sdk {
    val minSdk = 14
    val targetSdk = 29
}

object Version {
    val code = 1
    val versionName = "1.0.0"
}

object CoreAndroid {
    val compileVersion = 29
    val buildVersion = "29.0.2"
    val IdApps = "com.algokelvin.n_pocket"
}

object Kotlin {
    val jetbrains = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    val gradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
}

object GradleAndroid {
    val gradleTool = "com.android.tools.build:gradle:$gradle_version"
}

object AndroidX {
    val appCompat = "androidx.appcompat:appcompat:1.1.0"
    val core = "androidx.core:core-ktx:1.2.0"
}

object Design {
    val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
}

object Room {
    val runtime = "androidx.room:room-runtime:2.2.5"
}

object Module {
    val utils = ":utils"
}
