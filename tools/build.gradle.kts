plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
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
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0") {
        exclude("com.android.support","support-annotations")
    }
    testImplementation("junit:junit:4.13")
    testImplementation("org.mockito:mockito-core:3.3.3")

    implementation("com.google.zxing:core:3.4.0")

    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxjava:2.2.9")

    implementation("com.squareup.okhttp3:okhttp:4.4.0")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.2.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.2.0")

    implementation("androidx.annotation:annotation:1.1.0")
    implementation("androidx.appcompat:appcompat:1.1.0")

    implementation("com.orhanobut:logger:2.2.0")
    implementation("com.github.bumptech.glide:glide:4.10.0")


    
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.72")
    implementation("org.jetbrains.anko:anko:0.10.8")
//    testImplementation("com.google.android:android:4.1.1.4")
}
repositories {
    jcenter()
    mavenCentral()
    google()
}
