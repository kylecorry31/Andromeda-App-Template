plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 33

    defaultConfig {
        vectorDrawables.useSupportLibrary = true
        applicationId = "com.kylecorry.andromeda_template"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "0.1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        viewBinding = true
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    testOptions {
        unitTests.all {
            it.useJUnitPlatform()
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    packagingOptions {
        resources.merges += "META-INF/LICENSE.md"
        resources.merges += "META-INF/LICENSE-notice.md"
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    lint {
        abortOnError = false
    }
    namespace = "com.kylecorry.andromeda_template"
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.10")
    implementation("androidx.appcompat:appcompat:1.6.0")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.flexbox:flexbox:3.0.0")
    implementation("androidx.gridlayout:gridlayout:1.0.0")
    implementation("androidx.preference:preference-ktx:1.2.0")
    implementation("androidx.work:work-runtime-ktx:2.7.1")
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-service:2.5.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.5.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    implementation("com.google.android.material:material:1.8.0")
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.0")

    // Room
    kapt("androidx.room:room-compiler:2.5.0")
    implementation("androidx.room:room-runtime:2.5.0")
    implementation("androidx.room:room-ktx:2.5.0")

    // Sol
    implementation("com.github.kylecorry31:sol:6.3.3")

    // Andromeda
    val andromedaVersion = "5.0.0-beta33"
    implementation("com.github.kylecorry31.andromeda:core:$andromedaVersion")
    implementation("com.github.kylecorry31.andromeda:fragments:$andromedaVersion")
    implementation("com.github.kylecorry31.andromeda:exceptions:$andromedaVersion")
    implementation("com.github.kylecorry31.andromeda:preferences:$andromedaVersion")
    implementation("com.github.kylecorry31.andromeda:permissions:$andromedaVersion")
    implementation("com.github.kylecorry31.andromeda:notify:$andromedaVersion")
    implementation("com.github.kylecorry31.andromeda:alerts:$andromedaVersion")
    implementation("com.github.kylecorry31.andromeda:pickers:$andromedaVersion")
    implementation("com.github.kylecorry31.andromeda:list:$andromedaVersion")
    implementation("com.github.kylecorry31.andromeda:files:$andromedaVersion")

    // Ceres
    implementation("com.github.kylecorry31:ceres:0.3.3")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.44.2")
    kapt("com.google.dagger:hilt-android-compiler:2.44.2")

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    testImplementation("org.junit.platform:junit-platform-runner:1.9.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}