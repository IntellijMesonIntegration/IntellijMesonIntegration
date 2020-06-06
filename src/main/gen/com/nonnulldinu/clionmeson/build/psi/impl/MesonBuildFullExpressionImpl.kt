// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import com.nonnulldinu.clionmeson.build.psi.*

class MesonBuildFullExpressionImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildFullExpression {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitFullExpression(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val addExpr: MesonBuildAddExpr?
        get() = findChildByClass(MesonBuildAddExpr::class.java)

    override val conditionalOrExpression: MesonBuildConditionalOrExpression?
        get() = findChildByClass(MesonBuildConditionalOrExpression::class.java)

    override val ternaryExpression: MesonBuildTernaryExpression?
        get() = findChildByClass(MesonBuildTernaryExpression::class.java)
}