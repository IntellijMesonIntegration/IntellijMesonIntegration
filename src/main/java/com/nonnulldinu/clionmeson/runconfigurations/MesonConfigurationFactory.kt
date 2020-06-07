package com.nonnulldinu.clionmeson.runconfigurations

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.project.Project

open class MesonConfigurationFactory(configurationType: ConfigurationType) : ConfigurationFactory(configurationType) {
    companion object {
        const val FACTORY_NAME = "Demo configuration factory"
    }

    override fun createTemplateConfiguration(project: Project): RunConfiguration {
        return MesonConfiguration(project, this, "Unnamed")
    }

    override fun getName(): String {
        return FACTORY_NAME
    }
}
