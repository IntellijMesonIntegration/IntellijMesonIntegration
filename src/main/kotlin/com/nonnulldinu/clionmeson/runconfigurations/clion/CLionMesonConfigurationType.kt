package com.nonnulldinu.clionmeson.runconfigurations.clion

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import com.nonnulldinu.clionmeson.icons.PluginIcons
import javax.swing.Icon

object CLionMesonConfigurationType : ConfigurationType {
    override fun getIcon(): Icon {
        return PluginIcons.MESON_BUILD_ICON
    }

    override fun getConfigurationTypeDescription(): String {
        return "Configuration from Meson target"
    }

    override fun getId(): String = "MesonBuildConfigurationId"

    override fun getDisplayName(): String {
        return "Meson Configuration"
    }

    override fun getConfigurationFactories(): Array<ConfigurationFactory> {
        return arrayOf(CLionMesonConfigurationFactory(this))
    }

}
