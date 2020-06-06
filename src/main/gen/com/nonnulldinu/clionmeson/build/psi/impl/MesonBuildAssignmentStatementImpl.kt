// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.nonnulldinu.clionmeson.build.psi.*

class MesonBuildAssignmentStatementImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildAssignmentStatement {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitAssignmentStatement(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val atrop: MesonBuildAtrop
        get() = findNotNullChildByClass(MesonBuildAtrop::class.java)

    override val fullExpression: MesonBuildFullExpression?
        get() = findChildByClass(MesonBuildFullExpression::class.java)

    override val idExpression: MesonBuildIdExpression
        get() = findNotNullChildByClass(MesonBuildIdExpression::class.java)

    override val newline: PsiElement?
        get() = findChildByType<PsiElement>(MesonBuildTypes.Companion.NEWLINE)
}