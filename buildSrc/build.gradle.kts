plugins {
    `kotlin-dsl`
}

dependencies {
//    implementation(gradleApi())
    implementation("com.android.tools.build:gradle:4.0.0")
    implementation(kotlin("gradle-plugin", version = "1.3.72"))
//    implementation(gradleApi())
//    implementation(localGroovy())
//    implementation("org.ow2.asm:asm:7.1")
//    implementation("javassist:javassist:3.12.1.GA")
}
//buildscript {
//    repositories {
//        mavenCentral()
//        jcenter()
//        google()
//    }
//    dependencies {
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
//    }
//}
repositories {
    mavenCentral()
    jcenter()
    google()
}