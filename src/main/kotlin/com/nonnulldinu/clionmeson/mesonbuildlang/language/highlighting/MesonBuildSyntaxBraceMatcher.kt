package com.nonnulldinu.clionmeson.mesonbuildlang.language.highlighting

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.nonnulldinu.clionmeson.mesonbuildlang.psi.MesonBuildTypes

private val PAIRS = arrayOf(
        BracePair(MesonBuildTypes.BRACE_BEGIN, MesonBuildTypes.BRACE_END, true),
        BracePair(MesonBuildTypes.CURLY_BRACE_BEGIN, MesonBuildTypes.CURLY_BRACE_END, true),
        BracePair(MesonBuildTypes.PAREN_BEGIN, MesonBuildTypes.PAREN_END, true)
)

class MesonBuildSyntaxBraceMatcher : PairedBraceMatcher {
    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int = openingBraceOffset
    override fun getPairs(): Array<BracePair> = PAIRS
    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean = true
}