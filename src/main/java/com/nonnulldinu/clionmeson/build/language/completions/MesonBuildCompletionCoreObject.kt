package com.nonnulldinu.clionmeson.build.language.completions

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement

abstract class MesonBuildCompletionCoreObject protected constructor() : CompletionProvider<CompletionParameters?>() {
    abstract val type: CompletionType
    abstract val pattern: PsiElementPattern.Capture<PsiElement?>

    init {
        MesonBuildCompletionRegister.registerCompletion(this)
    }
}