package com.nonnulldinu.clionmeson.project

import com.intellij.openapi.externalSystem.settings.DelegatingExternalSystemSettingsListener
import com.intellij.openapi.externalSystem.settings.ExternalSystemSettingsListener

class MesonDelegatingSettingsAdapter(listener: ExternalSystemSettingsListener<MesonProjectSettings>) : DelegatingExternalSystemSettingsListener<MesonProjectSettings>(listener), MesonSettingsListener {
    override fun onToolchainChanged(oldToolchainName: String?, newToolchainName: String?) {}
}