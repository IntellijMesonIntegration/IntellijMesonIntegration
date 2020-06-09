package com.nonnulldinu.clionmeson.runconfigurations

import com.intellij.execution.Executor
import com.intellij.execution.configurations.RunConfigurationBase
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.configurations.RuntimeConfigurationException
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.project.Project


class MesonConfiguration(
        project: Project,
        configurationFactory: MesonConfigurationFactory,
        name: String
) : RunConfigurationBase<MesonConfigurationData>(project, configurationFactory, name) {

    override fun getConfigurationEditor(): MesonConfigurationEditor {
        return MesonConfigurationEditor(project)
    }

    @Throws(RuntimeConfigurationException::class)
    override fun checkConfiguration() {
    }

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState? {
        return MesonRunProfileState(state!!, environment)
    }

}