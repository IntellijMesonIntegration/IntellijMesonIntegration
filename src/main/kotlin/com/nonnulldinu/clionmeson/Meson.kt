package com.nonnulldinu.clionmeson

import com.intellij.openapi.project.Project
import com.intellij.openapi.project.guessProjectDir

object Meson {
    fun isMesonProject(project: Project): Boolean = project.guessProjectDir()?.findChild("meson.build") != null
    fun log(clazz: Class<*>, message: String) {
        println(clazz.name + ": " + message)
    }
}
