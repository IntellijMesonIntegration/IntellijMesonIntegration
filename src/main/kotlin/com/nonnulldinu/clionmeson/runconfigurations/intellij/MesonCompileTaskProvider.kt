package com.nonnulldinu.clionmeson.runconfigurations.intellij

import com.intellij.execution.BeforeRunTaskProvider
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.project.guessProjectDir
import com.intellij.openapi.util.Key
import com.nonnulldinu.clionmeson.settings.MesonPluginSettingsState
import java.io.File
import javax.swing.Icon

class MesonCompileTaskProvider : BeforeRunTaskProvider<MesonCompileTask>() {
    companion object {
        const val NAME = "Build Meson"
        val KeyId = Key<MesonCompileTask>("MesonCompileTaskId")
    }

    override fun getIcon(): Icon? = AllIcons.Actions.Compile

    override fun getName(): String = NAME

    override fun getId(): Key<MesonCompileTask> = KeyId

    override fun getDescription(task: MesonCompileTask?): String = "Compile Meson target"

    override fun createTask(runConfiguration: RunConfiguration): MesonCompileTask? {
        if (runConfiguration.type.id != MesonConfigurationType.ID) return null
        return MesonCompileTask(id)
    }

    override fun executeTask(context: DataContext, configuration: RunConfiguration, environment: ExecutionEnvironment, task: MesonCompileTask): Boolean {
        val p: Process = ProcessBuilder(MesonPluginSettingsState.getInstance().getValue(MesonPluginSettingsState.MesonPath), "compile", "-C", "build").directory(File(context.getData(CommonDataKeys.PROJECT)!!.guessProjectDir()!!.canonicalPath!!)).start()
        p.waitFor()
        return p.exitValue() == 0
    }

}