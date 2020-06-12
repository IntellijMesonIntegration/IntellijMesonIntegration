package com.nonnulldinu.clionmeson.runconfigurations.clion

import com.jetbrains.cidr.execution.CidrBuildConfigurationHelper

class CLionMesonConfigurationHelper : CidrBuildConfigurationHelper<CLionMesonBuildConfiguration, CLionMesonBuildTarget>() {
    override fun getTargets(): MutableList<CLionMesonBuildTarget> {
        return mutableListOf()
    }
}
