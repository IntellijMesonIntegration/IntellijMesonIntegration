package com.nonnulldinu.clionmeson.runconfigurations.clion

import com.jetbrains.cidr.execution.CidrBuildConfiguration
import com.nonnulldinu.clionmeson.buildsystem.target.MesonBuildTarget

class CLionMesonBuildConfiguration(val it: MesonBuildTarget) : CidrBuildConfiguration {
    override fun getName(): String = "Meson Build Configuration"
}
