// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.util.PsiTreeUtil
import com.nonnulldinu.clionmeson.build.psi.MesonBuildConditionalAndExpression
import com.nonnulldinu.clionmeson.build.psi.MesonBuildConditionalOrExpression
import com.nonnulldinu.clionmeson.build.psi.MesonBuildVisitor

class MesonBuildConditionalOrExpressionImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildConditionalOrExpression {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitConditionalOrExpression(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val conditionalAndExpressionList: List<MesonBuildConditionalAndExpression>
        get() = PsiTreeUtil.getChildrenOfTypeAsList(this, MesonBuildConditionalAndExpression::class.java)
}