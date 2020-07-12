package com.nonnulldinu.clionmeson.project

import com.intellij.openapi.externalSystem.settings.ExternalSystemSettingsListener
import com.intellij.util.messages.Topic

interface MesonSettingsListener : ExternalSystemSettingsListener<MesonProjectSettings> {
    companion object {
        val TOPIC = Topic.create("Meson specific settings", MesonSettingsListener::class.java)
    }

    fun onToolchainChanged(oldToolchainName: String?, newToolchainName: String?)
}