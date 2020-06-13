package com.nonnulldinu.clionmeson.project

import com.intellij.execution.RunManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener
import com.intellij.openapi.project.guessProjectDir
import com.nonnulldinu.clionmeson.buildsystem.MesonBuildSystem
import com.nonnulldinu.clionmeson.runconfigurations.clion.CLionMesonRunConfiguration
import com.nonnulldinu.clionmeson.runconfigurations.intellij.MesonConfiguration

class MesonProjectListener : ProjectManagerListener {
    override fun projectOpened(project: Project) {
        val mesonBuildVFile = project.guessProjectDir()!!.findFileByRelativePath("/meson.build") ?: return
        if (!mesonBuildVFile.isInLocalFileSystem) {
            return
        }

        val buildSystem: MesonBuildSystem = MesonBuildSystem.openOn(project)
        for (runConfig in RunManager.getInstance(project).allConfigurationsList) {
            if (runConfig is MesonConfiguration) {
                runConfig.loadTargetFromBuildSystem(buildSystem)
            } else if (runConfig is CLionMesonRunConfiguration) {
                runConfig.loadTargetFromBuildSystem(buildSystem)
            }
        }
    }
}