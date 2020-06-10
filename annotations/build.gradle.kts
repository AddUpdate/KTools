plugins {
    id("java-library")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    compileOnly("com.google.android:android:4.1.1.4")
    api("androidx.annotation:annotation:1.1.0")
}
