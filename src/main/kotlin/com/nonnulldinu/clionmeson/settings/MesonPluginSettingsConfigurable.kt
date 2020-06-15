package com.nonnulldinu.clionmeson.settings

import com.intellij.openapi.options.Configurable
import com.intellij.openapi.options.ConfigurationException
import org.jetbrains.annotations.Nls
import java.io.File
import javax.swing.JComponent


class MesonPluginSettingsConfigurable : Configurable {
    private var mesonPluginSettingsComponent: MesonPluginSettingsComponent? = null

    @Nls(capitalization = Nls.Capitalization.Title)
    override fun getDisplayName(): String? {
        return "Meson"
    }

    override fun getPreferredFocusedComponent(): JComponent? {
        return mesonPluginSettingsComponent?.getPreferredFocusedComponent()
    }

    override fun createComponent(): JComponent? {
        mesonPluginSettingsComponent = MesonPluginSettingsComponent()
        return mesonPluginSettingsComponent?.getPanel()
    }

    override fun isModified(): Boolean {
        val settings: MesonPluginSettingsState = MesonPluginSettingsState.getInstance()
        return mesonPluginSettingsComponent?.getMesonPathText() != settings.getValue(MesonPluginSettingsState.MesonPath)
    }

    @Throws(ConfigurationException::class)
    override fun apply() {
        val settings: MesonPluginSettingsState = MesonPluginSettingsState.getInstance()
        val mesonExecPath = mesonPluginSettingsComponent!!.getMesonPathText()
        val mesonExecFile = File(mesonExecPath)
        if (!mesonExecFile.exists()) {
            throw ConfigurationException("Meson executable not found at given path")
        }
        if (!mesonExecFile.canExecute()) {
            throw ConfigurationException("Given Meson binary is not executable")
        }
        settings.setValue(MesonPluginSettingsState.MesonPath, mesonExecPath)
    }

    override fun reset() {
        val settings: MesonPluginSettingsState = MesonPluginSettingsState.getInstance()
        val mesonPath = settings.getValue(MesonPluginSettingsState.MesonPath)
        if (mesonPath == null) {
            mesonPluginSettingsComponent!!.mesonPathNotInSettings()
        } else {
            mesonPluginSettingsComponent!!.setMesonPathText(mesonPath)
        }
    }

    override fun disposeUIResources() {
        mesonPluginSettingsComponent = null
    }
}