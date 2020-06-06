// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.util.PsiTreeUtil
import com.nonnulldinu.clionmeson.build.psi.MesonBuildDictLiteral
import com.nonnulldinu.clionmeson.build.psi.MesonBuildKeywordElem
import com.nonnulldinu.clionmeson.build.psi.MesonBuildVisitor

class MesonBuildDictLiteralImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildDictLiteral {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitDictLiteral(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }

    override val keywordElemList: List<MesonBuildKeywordElem>
        get() = PsiTreeUtil.getChildrenOfTypeAsList(this, MesonBuildKeywordElem::class.java)
}