// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import com.nonnulldinu.clionmeson.build.psi.MesonBuildRelationCheckOp
import com.nonnulldinu.clionmeson.build.psi.MesonBuildVisitor

class MesonBuildRelationCheckOpImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildRelationCheckOp {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitRelationCheckOp(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }
}