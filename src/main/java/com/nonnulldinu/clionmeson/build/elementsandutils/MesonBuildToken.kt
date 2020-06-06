package com.nonnulldinu.clionmeson.build.elementsandutils

import com.intellij.psi.tree.IElementType
import com.nonnulldinu.clionmeson.languages.MesonBuildLang
import org.jetbrains.annotations.NonNls

class MesonBuildToken
/**
 * Creates and registers a new element type for the specified language.
 */
(@NonNls debugName: String) : IElementType(debugName, MesonBuildLang) {
    override fun toString(): String {
        return "MesonBuildToken:\"" + super.toString() + "\""
    }
}