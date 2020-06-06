// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.util.PsiTreeUtil
import com.nonnulldinu.clionmeson.build.psi.*

class MesonBuildTernaryExpressionImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildTernaryExpression {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitTernaryExpression(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val addExpr: MesonBuildAddExpr?
        get() = findChildByClass(MesonBuildAddExpr::class.java)

    override val conditionalOrExpression: MesonBuildConditionalOrExpression?
        get() = findChildByClass(MesonBuildConditionalOrExpression::class.java)

    override val fullExpressionList: List<MesonBuildFullExpression>
        get() = PsiTreeUtil.getChildrenOfTypeAsList(this, MesonBuildFullExpression::class.java)
}