package com.nonnulldinu.clionmeson.runconfigurations.intellij

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import com.nonnulldinu.clionmeson.icons.PluginIcons
import org.jetbrains.annotations.Nls
import javax.swing.Icon

class MesonConfigurationType : ConfigurationType {
    companion object {
        const val ID = "MesonBuildRunConfig"
    }

    override fun getDisplayName(): @Nls(capitalization = Nls.Capitalization.Title) String {
        return "Meson configuration"
    }

    override fun getConfigurationTypeDescription(): @Nls(capitalization = Nls.Capitalization.Sentence) String? {
        return "A configuration created from a meson target"
    }

    override fun getIcon(): Icon {
        return PluginIcons.MESON_BUILD_ICON
    }

    override fun getId(): String {
        return ID
    }

    override fun getConfigurationFactories(): Array<ConfigurationFactory> {
        return arrayOf(MesonConfigurationFactory(this))
    }
}