package com.nonnulldinu.clionmeson.build.language.completions.basic

import com.intellij.codeInsight.completion.CompletionType
import com.nonnulldinu.clionmeson.build.language.completions.MesonBuildCompletionCoreObject

abstract class MesonBuildCompletionBasicObject : MesonBuildCompletionCoreObject() {
    override val type: CompletionType
        get() = CompletionType.BASIC
}