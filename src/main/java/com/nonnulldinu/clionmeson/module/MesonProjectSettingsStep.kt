package com.nonnulldinu.clionmeson.module

import com.intellij.ide.util.projectWizard.AbstractNewProjectStep.AbstractCallback
import com.intellij.ide.util.projectWizard.ProjectSettingsStepBase
import com.intellij.openapi.util.Ref
import com.intellij.platform.DirectoryProjectGenerator

abstract class MesonProjectSettingsStep(projectGenerator: DirectoryProjectGenerator<Ref<Array<String?>?>?>, callback: AbstractCallback<Ref<Array<String?>?>?>)
    : ProjectSettingsStepBase<Ref<Array<String?>?>?>(projectGenerator, callback) {
}