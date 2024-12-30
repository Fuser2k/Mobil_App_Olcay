plugins {
    alias(libs.plugins.android.application) // Android Uygulama Eklentisi
    alias(libs.plugins.kotlin.android) // Kotlin Android Eklentisi
}

android {
    namespace = "com.example.mobil_app" // Doğru namespace tanımı (mobil_app)
    compileSdk = 35 // SDK Sürümü

    defaultConfig {
        applicationId = "com.example.mobil_app" // Uygulama ID
        minSdk = 24 // Minimum Desteklenen SDK
        targetSdk = 35 // Hedef SDK Sürümü
        versionCode = 1 // Versiyon Kodu
        versionName = "1.0" // Versiyon Adı

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false // Obfuscation kapalı
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11 // Java Sürümü
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11" // JVM Hedef Sürümü
    }
}

dependencies {
    implementation(libs.androidx.core.ktx) // AndroidX KTX
    implementation(libs.androidx.appcompat) // AppCompat
    implementation(libs.material) // Material Components
    implementation(libs.androidx.activity) // Activity Kütüphanesi
    implementation(libs.androidx.constraintlayout) // ConstraintLayout
    testImplementation(libs.junit) // JUnit
    implementation("androidx.fragment:fragment-ktx:1.6.1")
    androidTestImplementation(libs.androidx.junit) // Android JUnit
    androidTestImplementation(libs.androidx.espresso.core) // Espresso
}
