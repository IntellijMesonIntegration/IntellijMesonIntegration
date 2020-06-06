// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.util.PsiTreeUtil
import com.nonnulldinu.clionmeson.build.psi.MesonBuildAddExpr
import com.nonnulldinu.clionmeson.build.psi.MesonBuildMulExpr
import com.nonnulldinu.clionmeson.build.psi.MesonBuildVisitor

class MesonBuildAddExprImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildAddExpr {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitAddExpr(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val mulExprList: List<MesonBuildMulExpr>
        get() = PsiTreeUtil.getChildrenOfTypeAsList(this, MesonBuildMulExpr::class.java)
}