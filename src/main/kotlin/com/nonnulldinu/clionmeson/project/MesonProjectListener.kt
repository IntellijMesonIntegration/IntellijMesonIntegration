package com.nonnulldinu.clionmeson.project

import com.intellij.execution.RunManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener
import com.nonnulldinu.clionmeson.Meson
import com.nonnulldinu.clionmeson.buildsystem.MesonBuildSystem
import com.nonnulldinu.clionmeson.runconfigurations.clion.CLionMesonRunConfiguration
import com.nonnulldinu.clionmeson.runconfigurations.intellij.MesonConfiguration

class MesonProjectListener : ProjectManagerListener {
    override fun projectOpened(project: Project) {
        if (!Meson.isMesonProject(project)) return
        CMakeWorkspaceOverride.undoCMakeModifications(project)

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