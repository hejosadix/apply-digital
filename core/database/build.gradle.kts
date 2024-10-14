plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.androidx.room)
    alias(libs.plugins.org.jetbrains.kotlin.kapt)
}

android {
    namespace = "com.hjsaraviad.core.database"
    compileSdk = 34
    room {
        schemaDirectory("$projectDir/schemas")
    }
    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //koin
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)
    //room
    implementation(libs.room)
    implementation(libs.roomKtx)
    implementation(libs.roomPaging)
    annotationProcessor(libs.roomCompiler)
    kapt(libs.roomCompiler)
    //moshi
    implementation(libs.moshi)
}