package com.nonnulldinu.clionmeson.project

import com.intellij.openapi.project.Project
import com.intellij.openapi.project.guessProjectDir
import com.jetbrains.cidr.project.workspace.CidrWorkspace
import com.jetbrains.cidr.project.workspace.CidrWorkspaceProvider

class MesonWorkspaceProvider : CidrWorkspaceProvider {
    override fun getWorkspace(project: Project): CidrWorkspace? =
            if (project.guessProjectDir()?.findChild("meson.build")?.exists() == true)
                MesonWorkspace.getInstance(project)
            else null
}