package com.nonnulldinu.clionmeson.project

import com.intellij.openapi.components.State
import com.intellij.openapi.project.Project
import com.jetbrains.cidr.cpp.toolchains.CPPEnvironment
import com.jetbrains.cidr.cpp.toolchains.CPPToolchains
import com.jetbrains.cidr.external.system.workspace.ExternalWorkspace
import com.jetbrains.cidr.toolchains.EnvironmentProblems

@State(name = "MesonWorkspace")
class MesonWorkspace(project: Project) : ExternalWorkspace(project) {
    override val clientKey: String = "MesonWorkspaceClientKey"

    override fun createEnvironment(project: Project?, toolchainNameOrNullForDefault: String?, problems: EnvironmentProblems, checkIfFunctional: Boolean, onMissingToolchain: Runnable?): CPPEnvironment? {
        return CPPToolchains.createCPPEnvironment(project, this.projectPath.toFile(), toolchainNameOrNullForDefault, problems, checkIfFunctional, onMissingToolchain)
    }

    companion object {
        fun getInstance(project: Project): MesonWorkspace = MesonWorkspace(project)
    }
}