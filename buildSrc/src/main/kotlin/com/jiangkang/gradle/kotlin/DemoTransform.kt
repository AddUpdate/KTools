package com.jiangkang.gradle.kotlin

import com.android.build.api.transform.Format
import com.android.build.api.transform.QualifiedContent
import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformInvocation
import com.android.build.gradle.internal.pipeline.TransformManager
import com.jiangkang.gradle.kotlin.asm.TestMethodClassAdapter
import org.apache.commons.io.FileUtils
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class DemoTransform : Transform() {

    override fun getInputTypes(): MutableSet<QualifiedContent.ContentType> = TransformManager.CONTENT_CLASS

    override fun getScopes(): MutableSet<in QualifiedContent.Scope> = TransformManager.SCOPE_FULL_PROJECT

    override fun getName(): String = "DemoTransform"

    override fun isIncremental(): Boolean = false

    override fun transform(transformInvocation: TransformInvocation?) {
        transformInvocation?.let {
            it.inputs.forEach { input ->
                // 处理jar文件
                input.jarInputs.forEach { jarInput ->
                    val dst = it.outputProvider.getContentLocation(
                            jarInput.file.absolutePath,
                            jarInput.contentTypes,
                            jarInput.scopes,
                            Format.JAR
                    )
                    println("处理jar:${dst.name}")
                    transformJar(jarInput.file, dst)
                }
                input.directoryInputs.forEach { dirInput ->
                    val dstDir = it.outputProvider.getContentLocation(
                            dirInput.name,
                            dirInput.contentTypes,
                            dirInput.scopes,
                            Format.DIRECTORY
                    )
                    println("处理dir：${dstDir.name}")
//                    transformDir(dirInput.file, dstDir)
                }
            }

        }
    }

    private fun transformDir(sourceDir: File, dstDir: File) {
        if (dstDir.exists()){
            FileUtils.forceDelete(dstDir)
        }
        FileUtils.forceMkdir(dstDir)
        val srcPath = sourceDir.absolutePath
        val dstPath = dstDir.absolutePath
        sourceDir.listFiles { file, _ ->
            val dstFilePath = file.absolutePath.replace(srcPath,dstPath)
            val dstFile = File(dstFilePath)
            if (file.isDirectory){
                transformDir(file,dstFile)
            } else if (file.isFile) {
                FileUtils.touch(dstFile)
                transformSingleFile(file,dstFile)
            }
            return@listFiles true
        }
    }

    private fun transformSingleFile(sourceFile: File, dstFile: File) {
        println("transformSingleFile")
        injectCode(sourceFile.absolutePath,dstFile.absolutePath)
    }

    private fun injectCode(inputPath: String, outputPath: String) {
        val inputStream = FileInputStream(inputPath)
        val classReader = ClassReader(inputStream)
        val classWriter = ClassWriter(ClassWriter.COMPUTE_FRAMES)
        val adapter = TestMethodClassAdapter(classWriter)
        classReader.accept(adapter,0)
        val fileOutStream = FileOutputStream(outputPath)
        fileOutStream.write(classWriter.toByteArray())
        fileOutStream.close()
        inputStream.close()
    }

    private fun transformJar(file: File, dst: File) {
        FileUtils.copyFile(file, dst)
    }

}