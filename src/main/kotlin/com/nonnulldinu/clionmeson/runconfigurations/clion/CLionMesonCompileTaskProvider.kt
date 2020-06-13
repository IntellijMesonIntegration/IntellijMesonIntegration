package com.nonnulldinu.clionmeson.runconfigurations.clion

import com.intellij.execution.BeforeRunTask
import com.intellij.execution.BeforeRunTaskProvider
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.actionSystem.PlatformDataKeys
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import com.jetbrains.cidr.execution.CidrBuildBeforeRunTaskProvider
import com.nonnulldinu.clionmeson.buildsystem.MesonBuildSystem
import com.nonnulldinu.clionmeson.buildsystem.target.MesonBuildTarget
import com.nonnulldinu.clionmeson.icons.PluginIcons
import javax.swing.Icon

class CLionMesonCompileTaskProvider : BeforeRunTaskProvider<CLionMesonBuildBeforeRunTask>() {
    companion object {
        val KeyId = Key<CLionMesonBuildBeforeRunTask>("MesonBuildBeforeRunTaskId")
    }

    override fun getIcon(): Icon? = PluginIcons.MESON_BUILD_ICON

    override fun createTask(runConfiguration: RunConfiguration): CLionMesonBuildBeforeRunTask? {
        if (runConfiguration !is CLionMesonRunConfiguration) return null
        return CLionMesonBuildBeforeRunTask(KeyId)
    }

    override fun executeTask(context: DataContext, configuration: RunConfiguration, environment: ExecutionEnvironment, task: CLionMesonBuildBeforeRunTask): Boolean {
        val project: Project = context.getData(PlatformDataKeys.PROJECT)!!
        println(configuration.toString())
        if (configuration !is CLionMesonRunConfiguration) return false
        val target: MesonBuildTarget = MesonBuildSystem.getBuildSystem(project).getTargets().find { it.id == configuration.getTargetId() }
                ?: return false
        val result = MesonBuildSystem.getBuildSystem(project).compile(target)
        return result.succeeded
    }

    override fun getName(): String = "Meson Compile"

    override fun getId(): Key<CLionMesonBuildBeforeRunTask> = KeyId
}