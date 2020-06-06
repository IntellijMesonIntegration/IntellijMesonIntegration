// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import com.nonnulldinu.clionmeson.build.psi.MesonBuildFullExpression
import com.nonnulldinu.clionmeson.build.psi.MesonBuildPositionalFuncArg
import com.nonnulldinu.clionmeson.build.psi.MesonBuildVisitor

class MesonBuildPositionalFuncArgImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildPositionalFuncArg {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitPositionalFuncArg(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val fullExpression: MesonBuildFullExpression
        get() = findNotNullChildByClass(MesonBuildFullExpression::class.java)
}