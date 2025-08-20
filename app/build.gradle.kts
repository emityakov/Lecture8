plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler) // ✅ Обязательно для Kotlin 2.0+
}

android {
    namespace = "com.example.lecture8"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.lecture8"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    // ✅ ОБЯЗАТЕЛЬНО: Включить Compose
    buildFeatures {
        compose = true
    }

    // ✅ ОБЯЗАТЕЛЬНО: Указать версию компилятора
    composeOptions {
        kotlinCompilerExtensionVersion = "1.7.4"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.5")
    implementation("androidx.activity:activity-compose:1.9.3")

    // Compose BOM — управляет версиями
    implementation(platform("androidx.compose:compose-bom:2024.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3") // ✅ Только Material3

    /// ✅ Unit-тесты
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")

    // ✅ UI-тесты
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.7.4")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.7.4")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}