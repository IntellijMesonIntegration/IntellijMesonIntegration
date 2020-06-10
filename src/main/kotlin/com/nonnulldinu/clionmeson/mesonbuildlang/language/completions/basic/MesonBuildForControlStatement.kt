package com.nonnulldinu.clionmeson.mesonbuildlang.language.completions.basic

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement
import com.intellij.util.ProcessingContext
import com.nonnulldinu.clionmeson.languages.MesonBuildLang

class MesonBuildForControlStatement : MesonBuildCompletionBasicObject() {
    override val pattern: PsiElementPattern.Capture<PsiElement?>
        get() = PlatformPatterns.psiElement().withLanguage(MesonBuildLang) /*.withAncestor(2, PlatformPatterns.psiElement(MesonBuildTypes.FOR_STATEMENT_LIST))*/

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
        result.addElement(LookupElementBuilder.create("continue"))
        result.addElement(LookupElementBuilder.create("break"))
    }

    companion object {
        val INSTANCE = MesonBuildForControlStatement()
    }
}