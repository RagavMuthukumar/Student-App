plugins {
    alias(libs.plugins.android.application)
    id("com.google.gms.google-services") // Add the Google Services plugin
}

android {
    namespace = "com.example.studentapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.studentapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
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
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // Firebase BOM (Bill of Materials)
    implementation(platform("com.google.firebase:firebase-bom:33.7.0"))

    // Firebase Analytics (version managed by BOM)
    implementation("com.google.firebase:firebase-analytics")

    // Firebase Database (version managed by BOM)
    implementation("com.google.firebase:firebase-database:20.0.3")

    // Firebase Authentication - included via the BOM, so no need to specify it again
    implementation("com.google.firebase:firebase-auth")

    implementation("com.sun.mail:javax.mail:1.6.2")
    implementation(libs.support.annotations)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}

// Apply Google Services plugin (at the end of the file)
apply(plugin = "com.google.gms.google-services")
