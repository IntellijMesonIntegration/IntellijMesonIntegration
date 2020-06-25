package com.nonnulldinu.clionmeson.project

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.LocalFileSystem
import com.jetbrains.cidr.cpp.compdb.CompDBWorkspace
import com.jetbrains.cidr.cpp.compdb.CompDBWorkspaceProvider
import com.jetbrains.cidr.project.workspace.CidrWorkspace
import com.jetbrains.cidr.project.workspace.CidrWorkspaceProvider

class MesonWorkspaceProvider : CidrWorkspaceProvider {
    override fun getWorkspace(project: Project): CidrWorkspace? {
        val workspace = CompDBWorkspaceProvider().getWorkspace(project)
        (workspace as CompDBWorkspace).changeContentRoot(LocalFileSystem.getInstance().findFileByIoFile(workspace.contentRoot?.parentFile!!))
        return workspace
    }
}