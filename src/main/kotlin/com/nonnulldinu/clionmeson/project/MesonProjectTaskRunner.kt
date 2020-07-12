package com.nonnulldinu.clionmeson.project

import com.intellij.openapi.project.Project
import com.intellij.task.ProjectTask
import com.intellij.task.ProjectTaskRunner

class MesonProjectTaskRunner : ProjectTaskRunner() {
    override fun canRun(project: Project, projectTask: ProjectTask): Boolean {
        val ws = MesonWorkspace.getInstance(project) ?: return false
        return ws.isInitialized && this.canRun(projectTask)
    }

    override fun canRun(projectTask: ProjectTask): Boolean {
        return false
    }
}