package com.nonnulldinu.clionmeson.project

import com.intellij.DynamicBundle
import org.jetbrains.annotations.Nls

object MesonBundle : DynamicBundle("mesonbundle.MesonBundle") {
    fun message(name: String): @Nls String {
        return this.getMessage(name)
    }
}
