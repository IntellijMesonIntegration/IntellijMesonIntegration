package com.nonnulldinu.clionmeson.project

import com.intellij.openapi.externalSystem.settings.AbstractExternalSystemSettings
import com.intellij.openapi.externalSystem.settings.ExternalSystemSettingsListener
import com.intellij.openapi.project.Project
import com.intellij.util.messages.Topic

class MesonSettings(project: Project) : AbstractExternalSystemSettings<MesonSettings, MesonProjectSettings, MesonSettingsListener>(MesonSettingsListener.TOPIC, project) {
    override fun checkSettings(old: MesonProjectSettings, current: MesonProjectSettings) {
        TODO("Not yet implemented")
    }

    override fun copyExtraSettingsFrom(settings: MesonSettings) {
        TODO("Not yet implemented")
    }

    override fun subscribe(listener: ExternalSystemSettingsListener<MesonProjectSettings>) {
        TODO("Not yet implemented")
    }

}
