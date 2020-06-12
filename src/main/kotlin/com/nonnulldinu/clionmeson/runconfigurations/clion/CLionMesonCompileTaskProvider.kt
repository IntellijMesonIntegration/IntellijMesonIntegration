package com.nonnulldinu.clionmeson.runconfigurations.clion

import com.intellij.execution.BeforeRunTask
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

class CLionMesonCompileTaskProvider : CidrBuildBeforeRunTaskProvider() {
    companion object {
        val KeyId = Key<CLionMesonBuildBeforeRunTask>("MesonBuildBeforeRunTaskId")
    }

    override fun executeTask(context: DataContext, configuration: RunConfiguration, environment: ExecutionEnvironment, task: BeforeRunTask<out BeforeRunTask<*>>): Boolean {
        val project: Project = context.getData(PlatformDataKeys.PROJECT)!!
        println(configuration.toString())
        if (configuration !is CLionMesonRunConfiguration) return false
        val target: MesonBuildTarget = MesonBuildSystem.getBuildSystem(project).getTargets().find { it.id == configuration.data?.target?.targetName!! }
                ?: return false
        val result = MesonBuildSystem.getBuildSystem(project).compile(target)
        return result.succeeded
    }

    override fun getIcon(): Icon? {
        return PluginIcons.MESON_BUILD_ICON
    }

    override fun getTaskIcon(task: BeforeRunTask<out BeforeRunTask<*>>?): Icon? {
        return AllIcons.Actions.Compile
    }

    override fun getDescription(task: BeforeRunTask<out BeforeRunTask<*>>?): String {
        return "Build Meson Target"
    }

    override fun createTask(runConfiguration: RunConfiguration): BeforeRunTask<out BeforeRunTask<*>>? {
        if (runConfiguration !is CLionMesonRunConfiguration) return null
        return CLionMesonBuildBeforeRunTask(KeyId)
    }
}