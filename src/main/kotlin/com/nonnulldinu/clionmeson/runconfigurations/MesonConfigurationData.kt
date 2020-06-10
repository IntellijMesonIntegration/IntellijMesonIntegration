package com.nonnulldinu.clionmeson.runconfigurations

import com.intellij.execution.configurations.RunConfigurationOptions
import com.intellij.execution.configurations.RunnerSettings
import com.nonnulldinu.clionmeson.buildsystem.target.MesonBuildTarget
import org.jdom.Element

class MesonConfigurationData : RunnerSettings, RunConfigurationOptions() {
    var target: MesonBuildTarget? = null
    var workingDirectory: String = ""
    override fun readExternal(element: Element?) {
        TODO("Implement")
    }

    override fun writeExternal(element: Element?) {
        if (target == null || element == null) return
        element.addContent(target!!.id)
    }
}