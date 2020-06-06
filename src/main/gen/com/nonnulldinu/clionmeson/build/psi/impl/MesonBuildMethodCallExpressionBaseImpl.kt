// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.nonnulldinu.clionmeson.build.psi.*

class MesonBuildMethodCallExpressionBaseImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildMethodCallExpressionBase {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitMethodCallExpressionBase(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val arrayLiteral: MesonBuildArrayLiteral?
        get() = findChildByClass(MesonBuildArrayLiteral::class.java)

    override val dictLiteral: MesonBuildDictLiteral?
        get() = findChildByClass(MesonBuildDictLiteral::class.java)

    override val funcCallExpression: MesonBuildFuncCallExpression?
        get() = findChildByClass(MesonBuildFuncCallExpression::class.java)

    override val numLiteralUnary: MesonBuildNumLiteralUnary?
        get() = findChildByClass(MesonBuildNumLiteralUnary::class.java)

    override val binnum: PsiElement?
        get() = findChildByType<PsiElement>(MesonBuildTypes.Companion.BINNUM)

    override val decnum: PsiElement?
        get() = findChildByType<PsiElement>(MesonBuildTypes.Companion.DECNUM)

    override val hexnum: PsiElement?
        get() = findChildByType<PsiElement>(MesonBuildTypes.Companion.HEXNUM)

    override val id: PsiElement?
        get() = findChildByType<PsiElement>(MesonBuildTypes.Companion.ID)

    override val octnum: PsiElement?
        get() = findChildByType<PsiElement>(MesonBuildTypes.Companion.OCTNUM)

    override val strmultiline: PsiElement?
        get() = findChildByType<PsiElement>(MesonBuildTypes.Companion.STRMULTILINE)

    override val strsimple: PsiElement?
        get() = findChildByType<PsiElement>(MesonBuildTypes.Companion.STRSIMPLE)
}