// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import com.nonnulldinu.clionmeson.build.psi.MesonBuildMulOp
import com.nonnulldinu.clionmeson.build.psi.MesonBuildVisitor

class MesonBuildMulOpImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildMulOp {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitMulOp(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }
}