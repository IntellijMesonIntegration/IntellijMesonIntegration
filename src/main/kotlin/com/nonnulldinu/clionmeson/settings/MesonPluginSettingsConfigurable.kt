package com.nonnulldinu.clionmeson.settings

import com.intellij.openapi.options.Configurable
import com.intellij.openapi.options.ConfigurationException
import org.jetbrains.annotations.Nls
import javax.swing.JComponent


class MesonPluginSettingsConfigurable : Configurable {
    private var mySettingsComponent: MesonPluginSettingsComponent? = null

    // A default constructor with no arguments is required because this implementation
    // is registered as an applicationConfigurable EP

    // A default constructor with no arguments is required because this implementation
    // is registered as an applicationConfigurable EP
    @Nls(capitalization = Nls.Capitalization.Title)
    override fun getDisplayName(): String? {
        return "SDK: Application Settings Example"
    }

    override fun getPreferredFocusedComponent(): JComponent? {
        return mySettingsComponent?.getPreferredFocusedComponent()
    }

    override fun createComponent(): JComponent? {
        mySettingsComponent = MesonPluginSettingsComponent()
        return mySettingsComponent?.getPanel()
    }

    override fun isModified(): Boolean {
//        val settings: MesonPluginSettingsState = MesonPluginSettingsState.getInstance()
//        var modified: Boolean = mySettingsComponent?.getUserNameText() != settings.userId
//        modified = modified or (mySettingsComponent?.getIdeaUserStatus() !== settings.ideaStatus)
        return false // modified
    }

    @Throws(ConfigurationException::class)
    override fun apply() {
//        val settings: MesonPluginSettingsState = MesonPluginSettingsState.getInstance()
//        settings.userId = mySettingsComponent.getUserNameText()
//        settings.ideaStatus = mySettingsComponent.getIdeaUserStatus()
    }

    override fun reset() {
//        val settings: MesonPluginSettingsState = MesonPluginSettingsState.getInstance()
//        mySettingsComponent.setUserNameText(settings.userId)
//        mySettingsComponent.setIdeaUserStatus(settings.ideaStatus)
    }

    override fun disposeUIResources() {
        mySettingsComponent = null
    }
}