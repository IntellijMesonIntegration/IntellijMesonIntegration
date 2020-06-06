// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.util.PsiTreeUtil
import com.nonnulldinu.clionmeson.build.psi.*

class MesonBuildConditionalAndExpressionImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildConditionalAndExpression {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitConditionalAndExpression(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val addExprList: List<MesonBuildAddExpr>
        get() = PsiTreeUtil.getChildrenOfTypeAsList(this, MesonBuildAddExpr::class.java)

    override val fullExpressionList: List<MesonBuildFullExpression>
        get() = PsiTreeUtil.getChildrenOfTypeAsList(this, MesonBuildFullExpression::class.java)

    override val relationCheckList: List<MesonBuildRelationCheck>
        get() = PsiTreeUtil.getChildrenOfTypeAsList(this, MesonBuildRelationCheck::class.java)
}