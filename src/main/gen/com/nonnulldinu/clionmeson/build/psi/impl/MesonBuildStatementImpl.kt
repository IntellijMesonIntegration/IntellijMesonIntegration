// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import com.nonnulldinu.clionmeson.build.psi.*

class MesonBuildStatementImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildStatement {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitStatement(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val assignmentStatement: MesonBuildAssignmentStatement?
        get() = findChildByClass(MesonBuildAssignmentStatement::class.java)

    override val funcCallStatement: MesonBuildFuncCallStatement?
        get() = findChildByClass(MesonBuildFuncCallStatement::class.java)

    override val methodCallStatement: MesonBuildMethodCallStatement?
        get() = findChildByClass(MesonBuildMethodCallStatement::class.java)

    override val repetitiveStatement: MesonBuildRepetitiveStatement?
        get() = findChildByClass(MesonBuildRepetitiveStatement::class.java)

    override val selectionStatement: MesonBuildSelectionStatement?
        get() = findChildByClass(MesonBuildSelectionStatement::class.java)
}