package com.nonnulldinu.clionmeson.project

import com.intellij.openapi.externalSystem.settings.ExternalProjectSettings

class MesonProjectSettings : ExternalProjectSettings() {
    override fun clone(): ExternalProjectSettings {
        return MesonProjectSettings()
    }
}
