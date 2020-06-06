// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.util.PsiTreeUtil
import com.nonnulldinu.clionmeson.build.psi.*

class MesonBuildSubscriptMethodChainExprImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildSubscriptMethodChainExpr {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitSubscriptMethodChainExpr(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val addExprList: List<MesonBuildAddExpr>
        get() = PsiTreeUtil.getChildrenOfTypeAsList(this, MesonBuildAddExpr::class.java)

    override val funcCallExpressionList: List<MesonBuildFuncCallExpression>
        get() = PsiTreeUtil.getChildrenOfTypeAsList(this, MesonBuildFuncCallExpression::class.java)

    override val methodCallExpressionBase: MesonBuildMethodCallExpressionBase
        get() = findNotNullChildByClass(MesonBuildMethodCallExpressionBase::class.java)
}