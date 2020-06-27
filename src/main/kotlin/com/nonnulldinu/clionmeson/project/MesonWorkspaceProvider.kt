package com.nonnulldinu.clionmeson.project

import com.intellij.openapi.project.Project
import com.jetbrains.cidr.project.workspace.CidrWorkspace
import com.jetbrains.cidr.project.workspace.CidrWorkspaceProvider

class MesonWorkspaceProvider : CidrWorkspaceProvider {
    override fun getWorkspace(project: Project): CidrWorkspace? {
        return MesonWorkspace.getInstance(project)
    }
}