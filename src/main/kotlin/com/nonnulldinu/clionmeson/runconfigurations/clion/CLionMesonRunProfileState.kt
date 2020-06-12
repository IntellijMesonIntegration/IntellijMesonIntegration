package com.nonnulldinu.clionmeson.runconfigurations.clion

import com.intellij.execution.ExecutionException
import com.intellij.execution.configurations.CommandLineState
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessHandlerFactory
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment
import com.nonnulldinu.clionmeson.buildsystem.MesonBuildSystem
import java.io.File

class CLionMesonRunProfileState(val target: String, environment: ExecutionEnvironment, val runConfig: CLionMesonRunConfiguration) : CommandLineState(environment) {
    @Throws(ExecutionException::class)
    override fun startProcess(): ProcessHandler {
        val buildTarget = MesonBuildSystem.getBuildSystem(runConfig.project).getTargets().find { it.id == target }!!
        val commandLine = GeneralCommandLine(buildTarget.filename[0])
        commandLine.workDirectory = if (runConfig.workingDirectory == null) File(buildTarget.filename[0]).parentFile else File(runConfig.workingDirectory!!)
        val processHandler = ProcessHandlerFactory.getInstance().createColoredProcessHandler(commandLine)
        ProcessTerminatedListener.attach(processHandler)
        return processHandler
    }
}
