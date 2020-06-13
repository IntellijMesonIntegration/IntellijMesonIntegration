package com.nonnulldinu.clionmeson.runconfigurations.clion

import com.intellij.openapi.roots.ProjectModelExternalSource
import com.jetbrains.cidr.execution.CidrBuildConfiguration

class CLionMesonBuildConfiguration : CidrBuildConfiguration {
    override fun getName(): String = "Meson Build Configuration"
}
