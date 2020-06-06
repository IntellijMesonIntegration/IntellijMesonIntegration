// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.util.PsiTreeUtil
import com.nonnulldinu.clionmeson.build.psi.MesonBuildFuncArg
import com.nonnulldinu.clionmeson.build.psi.MesonBuildFuncArgs
import com.nonnulldinu.clionmeson.build.psi.MesonBuildVisitor

class MesonBuildFuncArgsImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildFuncArgs {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitFuncArgs(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val funcArgList: List<MesonBuildFuncArg>
        get() = PsiTreeUtil.getChildrenOfTypeAsList(this, MesonBuildFuncArg::class.java)
}