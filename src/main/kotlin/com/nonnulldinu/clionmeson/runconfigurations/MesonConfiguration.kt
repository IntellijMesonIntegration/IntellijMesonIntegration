package com.nonnulldinu.clionmeson.runconfigurations

import com.intellij.execution.Executor
import com.intellij.execution.configurations.RunConfigurationBase
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.configurations.RuntimeConfigurationException
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.project.Project
import com.nonnulldinu.clionmeson.buildsystem.MesonBuildSystem
import com.nonnulldinu.clionmeson.buildsystem.target.MesonBuildTarget


class MesonConfiguration(
        project: Project,
        configurationFactory: MesonConfigurationFactory,
        name: String
) : RunConfigurationBase<MesonConfigurationOptions>(project, configurationFactory, name) {
    var target: MesonBuildTarget? = null

    override fun getConfigurationEditor(): MesonConfigurationEditor {
        return MesonConfigurationEditor(project)
    }

    @Throws(RuntimeConfigurationException::class)
    override fun checkConfiguration() {
        if (target == null) throw RuntimeConfigurationException("Target is null")
    }

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState? {
        return MesonRunProfileState(target!!, state!!, environment)
    }


    fun loadTargetFromBuildSystem(buildSystem: MesonBuildSystem) {
        target = buildSystem.getTargets().find { it.id == state!!.getTargetId() }
    }

}