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
        minSdkVersion(vMinSdkVersion)
        targetSdkVersion(vTargetSdkVersion)
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

    implementation(AndroidX.appcompat)
    implementation(AndroidX.constraintLayout)
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation(AndroidX.recyclerView)

    testImplementation(junit)
    androidTestImplementation(AndroidX.testRunner)
    androidTestImplementation(AndroidX.espressoCore)
    
    //ViewModel & LiveData
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.paging:paging-runtime:2.1.2")

    //support library
    implementation("androidx.lifecycle:lifecycle-runtime:2.2.0")

    implementation("androidx.room:room-runtime:2.2.5")
    kapt("androidx.room:room-compiler:2.2.5")
    implementation("androidx.room:room-rxjava2:2.2.5")

    implementation("androidx.work:work-runtime:2.3.4")
    implementation("androidx.navigation:navigation-ui:2.3.0-beta01")

    implementation(kotlin("stdlib-jdk7"))
    implementation("org.jetbrains.anko:anko:0.10.8")
    implementation(project(":storage"))
    implementation(project(":tools"))
    implementation(project(":requests"))

    implementation("com.google.code.gson:gson:2.8.6")


    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxjava:2.2.9")

    implementation(AndroidX.cardView)
    implementation("com.github.bumptech.glide:glide:4.11.0")

    implementation("com.squareup.okhttp3:okhttp:4.4.0")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.2.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.2.0")

    implementation("com.squareup.retrofit2:retrofit:2.6.1")
    implementation("com.squareup.retrofit2:converter-gson:2.6.1")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.6.1")
    implementation(project(":hybrid"))

}

repositories {
    jcenter()
    google()
    mavenCentral()
}
