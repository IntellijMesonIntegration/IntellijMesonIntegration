// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import com.nonnulldinu.clionmeson.build.psi.MesonBuildFuncArg
import com.nonnulldinu.clionmeson.build.psi.MesonBuildKeywordElem
import com.nonnulldinu.clionmeson.build.psi.MesonBuildPositionalFuncArg
import com.nonnulldinu.clionmeson.build.psi.MesonBuildVisitor

class MesonBuildFuncArgImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildFuncArg {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitFuncArg(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val keywordElem: MesonBuildKeywordElem?
        get() = findChildByClass(MesonBuildKeywordElem::class.java)

    override val positionalFuncArg: MesonBuildPositionalFuncArg?
        get() = findChildByClass(MesonBuildPositionalFuncArg::class.java)
}