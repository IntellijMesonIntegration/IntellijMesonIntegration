package com.nonnulldinu.clionmeson.build.language.completions.basic

import com.intellij.codeInsight.completion.CompletionType
import com.nonnulldinu.clionmeson.build.language.completions.MesonBuildCompletionCoreObject

abstract class MesonBuildCompletionBasicObject : MesonBuildCompletionCoreObject() {
    protected override val type: CompletionType
        protected get() = CompletionType.BASIC
}