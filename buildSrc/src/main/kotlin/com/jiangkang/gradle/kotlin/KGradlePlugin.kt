package com.jiangkang.gradle.kotlin

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project


class KGradlePlugin : Plugin<Project> {

    override fun apply(project: Project) {
        println("------------开始执行KGradlePlugin--------------")
        val android = project.extensions.getByType(AppExtension::class.java)
        android.registerTransform(DemoTransform())
    }

}