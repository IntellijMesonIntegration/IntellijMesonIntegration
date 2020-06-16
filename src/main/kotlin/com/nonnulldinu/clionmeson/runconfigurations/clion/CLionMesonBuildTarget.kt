package com.nonnulldinu.clionmeson.runconfigurations.clion

import com.intellij.icons.AllIcons
import com.intellij.openapi.project.Project
import com.jetbrains.cidr.execution.CidrBuildTarget
import com.nonnulldinu.clionmeson.icons.PluginIcons
import javax.swing.Icon

class CLionMesonBuildTarget(private val _projectName: String, private val _name: String, private val project: Project) : CidrBuildTarget<CLionMesonBuildConfiguration> {
    override fun getIcon(): Icon? = AllIcons.Actions.Compile

    override fun getName(): String = _name

    override fun getProjectName(): String = _projectName

    override fun isExecutable(): Boolean = true

    override fun getBuildConfigurations(): List<CLionMesonBuildConfiguration> = CLionMesonBuildConfigurationProvider().getBuildableConfigurations(project)

}
