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
    val environment: CPPEnvironment = createEnvironment(project, null, EnvironmentProblems(), true, null)!!

    override fun createEnvironment(project: Project?, toolchainNameOrNullForDefault: String?, problems: EnvironmentProblems, checkIfFunctional: Boolean, onMissingToolchain: Runnable?): CPPEnvironment? {
        val env = CPPToolchains.createCPPEnvironment(project, this.projectPath.toFile(), toolchainNameOrNullForDefault, problems, checkIfFunctional, onMissingToolchain) ?: return null
        return env
    }

    companion object {
        fun getInstance(project: Project): MesonWorkspace? = project.getComponent(MesonWorkspace::class.java)
    }
}