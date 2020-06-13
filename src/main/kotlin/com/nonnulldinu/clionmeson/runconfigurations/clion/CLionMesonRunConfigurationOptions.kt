package com.nonnulldinu.clionmeson.runconfigurations.clion

import com.intellij.execution.configurations.LocatableRunConfigurationOptions
import com.intellij.openapi.components.StoredProperty

class CLionMesonRunConfigurationOptions : LocatableRunConfigurationOptions() {
    private val _targetId: StoredProperty<String?> = string("").provideDelegate(this, "targetId")

    fun getTargetId(): String? = _targetId.getValue(this)

    fun setTargetId(value: String) {
        _targetId.setValue(this, value)
    }
}