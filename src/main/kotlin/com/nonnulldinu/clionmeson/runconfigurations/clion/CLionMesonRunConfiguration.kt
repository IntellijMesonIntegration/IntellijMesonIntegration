package com.nonnulldinu.clionmeson.runconfigurations.clion

import com.intellij.execution.ExecutionTarget
import com.intellij.execution.Executor
import com.intellij.execution.configurations.CommandLineState
import com.intellij.execution.configurations.RuntimeConfigurationException
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.project.Project
import com.jetbrains.cidr.cpp.execution.CLionRunConfiguration
import com.jetbrains.cidr.execution.CidrBuildConfigurationHelper
import com.jetbrains.cidr.execution.ExecutableData
import com.jetbrains.cidr.lang.workspace.OCResolveConfiguration
import com.nonnulldinu.clionmeson.buildsystem.MesonBuildSystem

class CLionMesonRunConfiguration(project: Project, factory: CLionMesonConfigurationFactory, name: String) : CLionRunConfiguration<CLionMesonBuildConfiguration, CLionMesonBuildTarget>(project, factory, name) {
    var data: ExecutableData? = null

    @Throws(RuntimeConfigurationException::class)
    override fun checkConfiguration() {
        super.checkConfiguration()
        if (null == MesonBuildSystem.getBuildSystem(project).getTargets().find { it.id == data?.target?.targetName })
            throw RuntimeConfigurationException("Target doesn't exist")
    }

    override fun getHelper(): CidrBuildConfigurationHelper<CLionMesonBuildConfiguration, CLionMesonBuildTarget> {
        return CLionMesonConfigurationHelper()
    }

    override fun getResolveConfiguration(p0: ExecutionTarget): OCResolveConfiguration? {
        return null
    }

    override fun getConfigurationEditor(): CLionMesonConfigurationEditor {
        return CLionMesonConfigurationEditor(project)
    }

    override fun getState(p0: Executor, environment: ExecutionEnvironment): CommandLineState? {
        return CLionMesonRunProfileState(data?.target?.targetName!!, environment, this)
    }

    override fun getExecutableData(): ExecutableData? {
        return data
    }

    override fun setExecutableData(p0: ExecutableData?) {
        data = p0
    }
}