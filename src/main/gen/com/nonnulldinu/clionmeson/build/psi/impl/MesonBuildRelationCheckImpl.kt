// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.util.PsiTreeUtil
import com.nonnulldinu.clionmeson.build.psi.MesonBuildAddExpr
import com.nonnulldinu.clionmeson.build.psi.MesonBuildRelationCheck
import com.nonnulldinu.clionmeson.build.psi.MesonBuildRelationCheckOp
import com.nonnulldinu.clionmeson.build.psi.MesonBuildVisitor

class MesonBuildRelationCheckImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildRelationCheck {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitRelationCheck(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val addExprList: List<MesonBuildAddExpr>
        get() = PsiTreeUtil.getChildrenOfTypeAsList(this, MesonBuildAddExpr::class.java)

    override val relationCheckOp: MesonBuildRelationCheckOp
        get() = findNotNullChildByClass(MesonBuildRelationCheckOp::class.java)
}