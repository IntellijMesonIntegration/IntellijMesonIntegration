package com.nonnulldinu.clionmeson.runconfigurations.clion

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.configurations.RunConfigurationOptions
import com.intellij.openapi.project.Project

class CLionMesonConfigurationFactory(configurationType: CLionMesonConfigurationType) : ConfigurationFactory(configurationType) {
    companion object {
        const val FACTORY_ID = "CLionMesonBuildRunConfigurationFactory"
    }
    override fun createTemplateConfiguration(project: Project): RunConfiguration {
        return CLionMesonRunConfiguration(project, CLionMesonConfigurationFactory(CLionMesonConfigurationType), "Meson Run Configuration Template")
    }

    override fun getId(): String {
        return FACTORY_ID
    }

    override fun getOptionsClass(): Class<out RunConfigurationOptions> {
        return CLionMesonRunConfigurationOptions::class.java
    }
}
