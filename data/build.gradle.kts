plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "ru.toxyxd.adguardhome.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 23
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.bundles.ktor)
    implementation(libs.kotlinxSerializationJson)

    implementation(libs.pagingCompose)

    implementation(libs.hiltAndroid)
    kapt(libs.hiltCompiler)

    implementation(project(":domain"))
}