package com.nonnulldinu.clionmeson.runconfigurations.intellij

import com.intellij.execution.BeforeRunTask
import com.intellij.openapi.util.Key

class MesonCompileTask(providerId: Key<MesonCompileTask>) : BeforeRunTask<MesonCompileTask>(providerId) {
    init {
        isEnabled = true
    }
}
