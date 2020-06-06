// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.util.PsiTreeUtil
import com.nonnulldinu.clionmeson.build.psi.MesonBuildForStatement
import com.nonnulldinu.clionmeson.build.psi.MesonBuildForStatementList
import com.nonnulldinu.clionmeson.build.psi.MesonBuildVisitor

class MesonBuildForStatementListImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildForStatementList {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitForStatementList(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val forStatementList: List<MesonBuildForStatement>
        get() = PsiTreeUtil.getChildrenOfTypeAsList(this, MesonBuildForStatement::class.java)
}