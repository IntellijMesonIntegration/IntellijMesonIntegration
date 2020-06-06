// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import com.nonnulldinu.clionmeson.build.psi.MesonBuildFuncName
import com.nonnulldinu.clionmeson.build.psi.MesonBuildIdExpression
import com.nonnulldinu.clionmeson.build.psi.MesonBuildVisitor

class MesonBuildFuncNameImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildFuncName {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitFuncName(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val idExpression: MesonBuildIdExpression
        get() = findNotNullChildByClass(MesonBuildIdExpression::class.java)
}