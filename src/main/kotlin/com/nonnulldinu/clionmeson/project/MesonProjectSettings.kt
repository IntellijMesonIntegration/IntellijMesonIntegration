package com.nonnulldinu.clionmeson.project

import com.intellij.openapi.externalSystem.settings.ExternalProjectSettings

class MesonProjectSettings : ExternalProjectSettings() {
    companion object {
        fun default() : MesonProjectSettings = MesonProjectSettings()
    }
    override fun clone(): ExternalProjectSettings {
        return MesonProjectSettings()
    }
}
