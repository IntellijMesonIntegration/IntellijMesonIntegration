// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.nonnulldinu.clionmeson.build.psi.MesonBuildControlStatement
import com.nonnulldinu.clionmeson.build.psi.MesonBuildTypes
import com.nonnulldinu.clionmeson.build.psi.MesonBuildVisitor

class MesonBuildControlStatementImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildControlStatement {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitControlStatement(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val newline: PsiElement
        get() = findNotNullChildByType<PsiElement>(MesonBuildTypes.Companion.NEWLINE)
}