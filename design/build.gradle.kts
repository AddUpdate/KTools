plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
}

android {

    //仅仅在编译的时候起作用，建议总是使用最新版本，值是一个API Level
    compileSdkVersion(vCompileSdkVersion)

    //构建工具的版本，在build-tools中的那些(aapt,dexdump,zipalign,apksigner)，一般是API-Level.x.x
    buildToolsVersion(vBuildToolsVersion)

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
        ndk {
            abiFilters("arm64-v8a")
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation("androidx.appcompat:appcompat:1.1.0")
    testImplementation("junit:junit:4.13")
    androidTestImplementation("androidx.test:runner:1.2.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.72")

    implementation("androidx.constraintlayout:constraintlayout:1.1.3")

    implementation("com.airbnb.android:lottie:3.4.1")
    implementation(project(":tools"))

}

repositories {
    jcenter()
    google()
    mavenCentral()
}