package com.nonnulldinu.clionmeson.runconfigurations.clion

import com.intellij.execution.configurations.CommandLineState
import com.intellij.execution.process.ProcessHandler
import com.intellij.openapi.project.Project
import com.intellij.xdebugger.XDebugSession
import com.jetbrains.cidr.execution.debugger.CidrDebugProcess
import com.jetbrains.cidr.execution.testing.CidrLauncher

class CLionMesonLauncher(private val project_: Project) : CidrLauncher() {
    override fun createDebugProcess(p0: CommandLineState, p1: XDebugSession): CidrDebugProcess {
        TODO("Not yet implemented")
    }

    override fun createProcess(p0: CommandLineState): ProcessHandler {
        TODO("Not yet implemented")
    }

    override fun getProject(): Project = project_

}
