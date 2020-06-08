package com.nonnulldinu.clionmeson.buildsystem

import com.intellij.notification.Notifications
import com.intellij.openapi.progress.PerformInBackgroundOption
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.Task
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import com.nonnulldinu.clionmeson.notifications.MesonBuildNotifications
import java.io.File

class MesonBuildSystem {
    companion object {
        fun createBuildSystem(project: Project) {
            object : Task.Backgroundable(project, "Initializing build system", false, PerformInBackgroundOption.DEAF) {
                override fun run(indicator: ProgressIndicator) {
                    val p: Process = ProcessBuilder().command("/usr/bin/meson", "build").directory(File(project.basePath!!)).start()
                    p.waitFor()
                    Notifications.Bus.notify(
                            when (p.exitValue()) {
                                0 -> MesonBuildNotifications.infoNotify(project, "Successfully created the build system")
                                else -> MesonBuildNotifications.errNotify(project, "Meson Build Failed")
                            }, project
                    )
                }

                override fun onFinished() {
                    project.putUserData(Key("MesonBuildSystemInstance"), MesonBuildSystem())
                }
            }.queue()
        }
    }
}