package com.nonnulldinu.clionmeson.mesonbuildlang.language.completions

internal object MesonBuildCompletionRegister {
    private val completionObjects: MutableList<MesonBuildCompletionCoreObject>? = null
    fun registerCompletion(completion: MesonBuildCompletionCoreObject) {
        completionObjects!!.add(completion)
    }

    fun getCompletionObjects(): List<MesonBuildCompletionCoreObject>? {
        return completionObjects
    }
}