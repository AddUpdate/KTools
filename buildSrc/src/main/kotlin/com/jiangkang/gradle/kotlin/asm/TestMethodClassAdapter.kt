package com.jiangkang.gradle.kotlin.asm

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.Opcodes.*

class TestMethodClassAdapter : ClassVisitor, Opcodes {

    constructor(classVisitor: ClassVisitor) : super(ASM7, classVisitor)

    override fun visitMethod(access: Int, name: String?, descriptor: String?, signature: String?, exceptions: Array<out String>?): MethodVisitor {
        val methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions)
        return TestMethodVisitor(methodVisitor)
    }

}

class TestMethodVisitor(methodVisitor: MethodVisitor) : MethodVisitor(ASM7, methodVisitor) {

    override fun visitMethodInsn(opcode: Int, owner: String?, name: String?, descriptor: String?, isInterface: Boolean) {
        println("opcode:$opcode,owner:$owner,name:$name,descriptor:$descriptor,isInterface:$isInterface")
        mv.visitLdcInsn(" before method exec")
        mv.visitLdcInsn(" [ASM 测试] method in $owner ,name=$name")
        mv.visitMethodInsn(INVOKESTATIC,
                "android/util/Log", "i", "(Ljava/lang/String;Ljava/lang/String;)I", false)
        mv.visitInsn(POP)
        
        super.visitMethodInsn(opcode, owner, name, descriptor, isInterface)

        //方法执行之后打印
        mv.visitLdcInsn(" after method exec")
        mv.visitLdcInsn(" method in $owner ,name=$name")
        mv.visitMethodInsn(INVOKESTATIC,
                "android/util/Log", "i", "(Ljava/lang/String;Ljava/lang/String;)I", false)
        mv.visitInsn(POP)

    }
}
