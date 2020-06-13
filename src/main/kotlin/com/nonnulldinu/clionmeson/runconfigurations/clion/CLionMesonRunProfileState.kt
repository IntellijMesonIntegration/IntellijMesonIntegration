package com.nonnulldinu.clionmeson.runconfigurations.clion

import com.intellij.execution.ExecutionException
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessHandlerFactory
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment
import com.jetbrains.cidr.execution.CidrCommandLineState
import com.nonnulldinu.clionmeson.buildsystem.target.MesonBuildTarget
import java.io.File

class CLionMesonRunProfileState(val target: MesonBuildTarget, environment: ExecutionEnvironment, val runConfig: CLionMesonRunConfiguration) : CidrCommandLineState(environment, CLionMesonLauncher(environment.project)) {
    @Throws(ExecutionException::class)
    override fun startProcess(): ProcessHandler {
        val commandLine = GeneralCommandLine(target.filename[0])
        commandLine.workDirectory = if (runConfig.workingDirectory == null) File(target.filename[0]).parentFile else File(runConfig.workingDirectory!!)
        val processHandler = ProcessHandlerFactory.getInstance().createColoredProcessHandler(commandLine)
        ProcessTerminatedListener.attach(processHandler)
        return processHandler
    }
}
