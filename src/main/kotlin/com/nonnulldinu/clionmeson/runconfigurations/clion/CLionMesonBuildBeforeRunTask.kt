package com.nonnulldinu.clionmeson.runconfigurations.clion

import com.intellij.execution.BeforeRunTask
import com.intellij.openapi.util.Key

class CLionMesonBuildBeforeRunTask(providerId: Key<CLionMesonBuildBeforeRunTask>) : BeforeRunTask<CLionMesonBuildBeforeRunTask>(providerId) {
    init {
        isEnabled = true
    }
}