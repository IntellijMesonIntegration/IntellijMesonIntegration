package com.nonnulldinu.clionmeson.buildsystem

import com.intellij.openapi.progress.PerformInBackgroundOption
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.Task
import com.intellij.openapi.project.Project
import java.io.File

class MesonBuildSystem {
    companion object {
        fun createBuildSystem(project : Project) : MesonBuildSystem {
            object : Task.Backgroundable(project, "Initializing build system", false, PerformInBackgroundOption.DEAF) {
                override fun run(indicator : ProgressIndicator) {
                    val p : Process = ProcessBuilder().command("/usr/bin/meson", "build").directory(File(project.basePath!!)).start()
                    p.waitFor()
                }
                override fun onFinished() {
                }
            }.queue()
            return MesonBuildSystem()
        }
    }
}