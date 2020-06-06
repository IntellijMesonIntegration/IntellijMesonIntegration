// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.nonnulldinu.clionmeson.build.psi.MesonBuildNumLiteralUnary
import com.nonnulldinu.clionmeson.build.psi.MesonBuildTypes
import com.nonnulldinu.clionmeson.build.psi.MesonBuildVisitor

class MesonBuildNumLiteralUnaryImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildNumLiteralUnary {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitNumLiteralUnary(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val binnum: PsiElement?
        get() = findChildByType<PsiElement>(MesonBuildTypes.Companion.BINNUM)

    override val decnum: PsiElement?
        get() = findChildByType<PsiElement>(MesonBuildTypes.Companion.DECNUM)

    override val hexnum: PsiElement?
        get() = findChildByType<PsiElement>(MesonBuildTypes.Companion.HEXNUM)

    override val octnum: PsiElement?
        get() = findChildByType<PsiElement>(MesonBuildTypes.Companion.OCTNUM)
}