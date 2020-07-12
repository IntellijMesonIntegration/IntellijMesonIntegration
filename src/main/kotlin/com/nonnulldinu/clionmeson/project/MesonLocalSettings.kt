package com.nonnulldinu.clionmeson.project

import com.intellij.openapi.externalSystem.settings.AbstractExternalSystemLocalSettings
import com.intellij.openapi.project.Project

class MesonLocalSettings(project: Project) : AbstractExternalSystemLocalSettings<MesonLocalSettingsState>(MesonProjectUtil.ID, project, MesonLocalSettingsState()) {
    companion object {
        fun from(project: Project) = MesonLocalSettings(project)
    }
}
