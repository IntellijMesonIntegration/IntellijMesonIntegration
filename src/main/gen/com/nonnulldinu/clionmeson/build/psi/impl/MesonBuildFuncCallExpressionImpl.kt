// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import com.nonnulldinu.clionmeson.build.psi.MesonBuildFuncArgs
import com.nonnulldinu.clionmeson.build.psi.MesonBuildFuncCallExpression
import com.nonnulldinu.clionmeson.build.psi.MesonBuildFuncName
import com.nonnulldinu.clionmeson.build.psi.MesonBuildVisitor

class MesonBuildFuncCallExpressionImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildFuncCallExpression {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitFuncCallExpression(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val funcArgs: MesonBuildFuncArgs?
        get() = findChildByClass(MesonBuildFuncArgs::class.java)

    override val funcName: MesonBuildFuncName
        get() = findNotNullChildByClass(MesonBuildFuncName::class.java)
}