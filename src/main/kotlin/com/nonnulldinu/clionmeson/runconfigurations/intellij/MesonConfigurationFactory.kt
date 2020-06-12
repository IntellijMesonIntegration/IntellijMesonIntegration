package com.nonnulldinu.clionmeson.runconfigurations.intellij

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.components.BaseState
import com.intellij.openapi.project.Project

open class MesonConfigurationFactory(configurationType: ConfigurationType) : ConfigurationFactory(configurationType) {
    companion object {
        const val FACTORY_NAME = "Meson Build System Run/Debug Configuration Factory"
        const val FACTORY_ID = "MesonBuildSystemConfigurationFactory"
    }

    override fun createTemplateConfiguration(project: Project): RunConfiguration {
        return MesonConfiguration(project, this, "Unnamed")
    }

    override fun getName(): String {
        return FACTORY_NAME
    }

    override fun getId(): String {
        return FACTORY_ID
    }

    override fun getOptionsClass(): Class<out BaseState>? {
        return MesonConfigurationOptions::class.java
    }
}
