package com.nonnulldinu.clionmeson.mesonbuildlang.language.completions.basic

import com.intellij.codeInsight.completion.CompletionType
import com.nonnulldinu.clionmeson.mesonbuildlang.language.completions.MesonBuildCompletionCoreObject

abstract class MesonBuildCompletionBasicObject : MesonBuildCompletionCoreObject() {
    override val type: CompletionType
        get() = CompletionType.BASIC
}