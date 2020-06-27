package com.nonnulldinu.clionmeson.runconfigurations.clion

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.MessageType
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.task.ProjectTaskContext
import com.intellij.task.ProjectTaskNotification
import com.jetbrains.cidr.cpp.execution.build.runners.CLionCompileTaskRunner

class CLionMesonCompileTaskRunner : CLionCompileTaskRunner<CLionMesonBuildConfiguration>() {
    override fun acceptConfiguration(file: VirtualFile?, configuration: CLionMesonBuildConfiguration?): Boolean {
//        println("Asked about ${file?.canonicalPath}")
        return false
    }

    override fun doBuild(project: Project, currentFile: VirtualFile, buildFile: VirtualFile, configuration: CLionMesonBuildConfiguration, context: ProjectTaskContext, callback: ProjectTaskNotification?, taskName: String, preBuildMessage: String) {
        TODO("Not yet implemented")
    }

    override fun doGetConfiguration(project: Project, file: VirtualFile): Pair<CLionMesonBuildConfiguration?, VirtualFile?> {
        TODO("Not yet implemented")
    }

    override fun showBuildNotification(project: Project, messageType: MessageType, message: String) {
        TODO("Not yet implemented")
    }
}