package com.nonnulldinu.clionmeson.runconfigurations.intellij

import com.intellij.execution.configurations.RunConfigurationOptions
import com.intellij.openapi.components.StoredProperty

class MesonConfigurationOptions : RunConfigurationOptions() {
    private val _targetId: StoredProperty<String?> = string("").provideDelegate(this, "targetId")
    private var workingDirectory: StoredProperty<String?> = string("").provideDelegate(this, "workingDirectory")

    fun getTargetId(): String? {
        return _targetId.getValue(this)
    }

    fun setTargetId(value: String) {
        _targetId.setValue(this, value)
    }

    fun getWorkingDirectory(): String? {
        return workingDirectory.getValue(this)
    }

    fun setWorkingDirectory(value: String?) {
        workingDirectory.setValue(this, value ?: "")
    }
}