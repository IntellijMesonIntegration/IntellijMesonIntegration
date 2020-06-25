package com.nonnulldinu.clionmeson.buildsystem.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import com.nonnulldinu.clionmeson.buildsystem.MesonBuildSystem

class MesonOpenProject : AnAction("Add meson to project") {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        openProject(project)
    }

    fun openProject(project: Project) {
        println(project.toString())
        MesonBuildSystem.openOn(project)
    }
}