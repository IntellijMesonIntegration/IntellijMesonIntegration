// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import com.nonnulldinu.clionmeson.build.psi.*

class MesonBuildForStatementImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildForStatement {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitForStatement(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val assignmentStatement: MesonBuildAssignmentStatement?
        get() = findChildByClass(MesonBuildAssignmentStatement::class.java)

    override val controlStatement: MesonBuildControlStatement?
        get() = findChildByClass(MesonBuildControlStatement::class.java)

    override val funcCallStatement: MesonBuildFuncCallStatement?
        get() = findChildByClass(MesonBuildFuncCallStatement::class.java)

    override val methodCallStatement: MesonBuildMethodCallStatement?
        get() = findChildByClass(MesonBuildMethodCallStatement::class.java)

    override val repetitiveStatement: MesonBuildRepetitiveStatement?
        get() = findChildByClass(MesonBuildRepetitiveStatement::class.java)

    override val selectionStatementFor: MesonBuildSelectionStatementFor?
        get() = findChildByClass(MesonBuildSelectionStatementFor::class.java)
}