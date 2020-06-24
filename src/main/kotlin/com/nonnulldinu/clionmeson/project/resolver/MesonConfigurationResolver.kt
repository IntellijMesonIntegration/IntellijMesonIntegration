package com.nonnulldinu.clionmeson.project.resolver

import com.intellij.openapi.project.Project
import com.nonnulldinu.clionmeson.buildsystem.MesonBuildSystem


class MesonConfigurationResolver(val project: Project) {
    fun update(buildSystem: MesonBuildSystem, oldResult: MesonConfigurationResolveResult): MesonConfigurationResolveResult? {
        return MesonConfigurationResolveResult()
    }

}