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
    testImplementation(junit)
    androidTestImplementation(AndroidX.espressoCore) {
        exclude("com.android.support","support-annotations")
    }
    implementation("com.squareup.okhttp3:okhttp:4.4.0")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.2.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.2.0")

    implementation("com.squareup.retrofit2:retrofit:2.6.1")
    implementation("com.squareup.retrofit2:converter-gson:2.6.1")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.6.1")

    implementation(project(":tools"))

    debugImplementation("com.readystatesoftware.chuck:library:1.1.0")
    releaseImplementation("com.readystatesoftware.chuck:library-no-op:1.1.0")

    implementation("com.facebook.stetho:stetho:1.5.1")
    implementation("com.facebook.stetho:stetho-okhttp3:1.5.1")
    implementation(kotlin("stdlib-jdk7"))


}
repositories {
    jcenter()
    google()
    mavenCentral()
}
