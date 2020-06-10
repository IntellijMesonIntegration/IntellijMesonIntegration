package com.nonnulldinu.clionmeson.project

import com.intellij.execution.RunManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener
import com.intellij.openapi.project.guessProjectDir
import com.nonnulldinu.clionmeson.buildsystem.MesonBuildSystem
import com.nonnulldinu.clionmeson.runconfigurations.MesonConfiguration
import java.util.logging.Level
import java.util.logging.Logger

class MesonProjectListener : ProjectManagerListener {
    override fun projectOpened(project: Project) {
        val mesonBuildVFile = project.guessProjectDir()!!.findFileByRelativePath("/meson.build") ?: return
        if (!mesonBuildVFile.isInLocalFileSystem) {
            return
        }

        val buildSystem: MesonBuildSystem = MesonBuildSystem.openOn(project)
        for (runConfig in RunManager.getInstance(project).allConfigurationsList) {
            Logger.getLogger("MesonProjectListener").log(Level.WARNING, "Found runconfig $runConfig")
            if (runConfig is MesonConfiguration) {
                runConfig.loadTargetFromBuildSystem(buildSystem)
                Logger.getLogger("MesonProjectListener").log(Level.WARNING, "Loaded runconfig $runConfig")
            }
        }
    }
}