// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import com.nonnulldinu.clionmeson.build.psi.*

class MesonBuildRepetitiveStatementImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildRepetitiveStatement {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitRepetitiveStatement(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val forStatementList: MesonBuildForStatementList?
        get() = findChildByClass(MesonBuildForStatementList::class.java)

    override val fullExpression: MesonBuildFullExpression?
        get() = findChildByClass(MesonBuildFullExpression::class.java)

    override val idList: MesonBuildIdList?
        get() = findChildByClass(MesonBuildIdList::class.java)
}