package com.nonnulldinu.clionmeson.runconfigurations.clion

import com.intellij.openapi.project.Project
import com.jetbrains.cidr.cpp.execution.build.CLionBuildConfigurationProvider
import com.nonnulldinu.clionmeson.buildsystem.MesonBuildSystem

class CLionMesonBuildConfigurationProvider : CLionBuildConfigurationProvider {
    override fun getBuildableConfigurations(p0: Project): List<CLionMesonBuildConfiguration> {
        val buildSystem = MesonBuildSystem.getBuildSystem(p0)
        return buildSystem.getTargets().map { CLionMesonBuildConfiguration(it) }
    }
}