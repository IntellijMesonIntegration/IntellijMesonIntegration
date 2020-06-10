package com.nonnulldinu.clionmeson.runconfigurations

import com.intellij.execution.ExecutionException
import com.intellij.execution.configurations.CommandLineState
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessHandlerFactory
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment
import java.io.File


class MesonRunProfileState(var configurationData: MesonConfigurationData, var environment_: ExecutionEnvironment) : CommandLineState(environment_) {
    @Throws(ExecutionException::class)
    override fun startProcess(): ProcessHandler {
        val commandLine = GeneralCommandLine(configurationData.target!!.filename[0])
        commandLine.workDirectory = if (configurationData.workingDirectory == "") File(configurationData.target!!.filename[0]).parentFile else File(configurationData.workingDirectory)
        val processHandler = ProcessHandlerFactory.getInstance().createColoredProcessHandler(commandLine)
        ProcessTerminatedListener.attach(processHandler)
        return processHandler
    }
}