@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    alias(libs.plugins.kotlinxSerialization)
}

android {
    namespace = "ru.toxyxd.adguardhome.domain"
    compileSdk = 33

    defaultConfig {
        minSdk = 23
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    dependencies {
        implementation(libs.kotlinx.coroutines.core)
        implementation(libs.kotlinxSerializationJson)
        implementation(libs.javaInject)
    }
}
