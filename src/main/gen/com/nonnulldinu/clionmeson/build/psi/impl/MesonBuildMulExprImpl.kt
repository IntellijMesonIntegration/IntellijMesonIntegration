// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.util.PsiTreeUtil
import com.nonnulldinu.clionmeson.build.psi.MesonBuildAtom
import com.nonnulldinu.clionmeson.build.psi.MesonBuildMulExpr
import com.nonnulldinu.clionmeson.build.psi.MesonBuildMulOp
import com.nonnulldinu.clionmeson.build.psi.MesonBuildVisitor

class MesonBuildMulExprImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildMulExpr {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitMulExpr(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val atomList: List<MesonBuildAtom>
        get() = PsiTreeUtil.getChildrenOfTypeAsList(this, MesonBuildAtom::class.java)

    override val mulOpList: List<MesonBuildMulOp>
        get() = PsiTreeUtil.getChildrenOfTypeAsList(this, MesonBuildMulOp::class.java)
}