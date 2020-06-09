package com.nonnulldinu.clionmeson.mesonbuildlang.language.completions

import com.intellij.codeInsight.completion.CompletionContributor

class MesonBuildCompletionContributor : CompletionContributor() {
    init {
        for (obj in MesonBuildCompletionRegister.getCompletionObjects()!!) {
            extend(obj.type, obj.pattern, obj)
        }
    }
}