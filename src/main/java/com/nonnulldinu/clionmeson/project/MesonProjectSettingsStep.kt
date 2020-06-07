package com.nonnulldinu.clionmeson.project

import com.intellij.ide.util.projectWizard.AbstractNewProjectStep
import com.intellij.ide.util.projectWizard.ProjectSettingsStepBase
import com.intellij.openapi.util.Ref
import com.intellij.platform.DirectoryProjectGenerator
import com.nonnulldinu.clionmeson.project.SettingsProperty

abstract class MesonProjectSettingsStep(
        projectGenerator: DirectoryProjectGenerator<Ref<Array<SettingsProperty>>>,
        callback: AbstractNewProjectStep.AbstractCallback<Ref<Array<SettingsProperty>>>
) : ProjectSettingsStepBase<Ref<Array<SettingsProperty>>>(projectGenerator, callback) {
    abstract fun getSettings(): Ref<Array<SettingsProperty>>
}