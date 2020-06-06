// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.util.PsiTreeUtil
import com.nonnulldinu.clionmeson.build.psi.MesonBuildFullExpression
import com.nonnulldinu.clionmeson.build.psi.MesonBuildSelectionStatement
import com.nonnulldinu.clionmeson.build.psi.MesonBuildStatementList
import com.nonnulldinu.clionmeson.build.psi.MesonBuildVisitor

class MesonBuildSelectionStatementImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildSelectionStatement {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitSelectionStatement(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val fullExpressionList: List<MesonBuildFullExpression>
        get() = PsiTreeUtil.getChildrenOfTypeAsList(this, MesonBuildFullExpression::class.java)

    override val statementListList: List<MesonBuildStatementList>
        get() = PsiTreeUtil.getChildrenOfTypeAsList(this, MesonBuildStatementList::class.java)
}