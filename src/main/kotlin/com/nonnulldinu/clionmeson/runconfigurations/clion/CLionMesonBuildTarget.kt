package com.nonnulldinu.clionmeson.runconfigurations.clion

import com.intellij.icons.AllIcons
import com.jetbrains.cidr.execution.CidrBuildTarget
import com.nonnulldinu.clionmeson.icons.PluginIcons
import javax.swing.Icon

class CLionMesonBuildTarget(private val _projectName: String, private val _name: String) : CidrBuildTarget<CLionMesonBuildConfiguration> {
    override fun getIcon(): Icon? {
        return AllIcons.Actions.Compile
    }

    override fun getName(): String {
        return _name
    }

    override fun getProjectName(): String {
        return _projectName
    }

    override fun isExecutable(): Boolean {
        return true
    }

    override fun getBuildConfigurations(): MutableList<CLionMesonBuildConfiguration> {
        return mutableListOf()
    }

}
