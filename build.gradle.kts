buildscript {

    repositories {
        jcenter()
        mavenCentral()
        google()
    }
    
    dependencies {
        classpath("com.android.tools.build:gradle:4.0.0")
        classpath("org.greenrobot:greendao-gradle-plugin:3.2.2")
        classpath(kotlin("gradle-plugin", version = "1.3.72"))
    }


}

allprojects {
    repositories {
        jcenter()
        google()
    }
}

task("clean",Delete::class){
    delete(rootProject.buildDir)
}

tasks.withType(JavaCompile::class){
    options.compilerArgs = listOf(
            "-Xlint:all",
            "-Xlint:-serial",
            "-Xlint:-deprecation",
            "-Werror"
    )
}


