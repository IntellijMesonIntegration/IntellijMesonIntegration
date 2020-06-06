// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import com.nonnulldinu.clionmeson.build.psi.MesonBuildIdList
import com.nonnulldinu.clionmeson.build.psi.MesonBuildVisitor

class MesonBuildIdListImpl(node: ASTNode) : ASTWrapperPsiElement(node), MesonBuildIdList {
    fun accept(visitor: MesonBuildVisitor) {
        visitor.visitIdList(this)
    }

    override fun accept(visitor: PsiElementVisitor) {
        if (visitor is MesonBuildVisitor) accept(visitor) else super.accept(visitor)
    }
}