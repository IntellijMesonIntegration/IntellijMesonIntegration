// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.util.PsiTreeUtil
import com.nonnulldinu.clionmeson.build.psi.MesonBuildStatement
import com.nonnulldinu.clionmeson.build.psi.MesonBuildStatementList
import com.nonnulldinu.clionmeson.build.psi.MesonBuildVisitor

class MesonBuildStatementListImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildStatementList {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitStatementList(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val statementList: List<MesonBuildStatement>
        get() = PsiTreeUtil.getChildrenOfTypeAsList(this, MesonBuildStatement::class.java)
}