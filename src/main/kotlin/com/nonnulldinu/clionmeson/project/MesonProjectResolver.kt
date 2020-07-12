package com.nonnulldinu.clionmeson.project

import com.intellij.openapi.externalSystem.model.DataNode
import com.intellij.openapi.externalSystem.model.ProjectKeys
import com.intellij.openapi.externalSystem.model.project.ProjectData
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskId
import com.intellij.openapi.externalSystem.model.task.ExternalSystemTaskNotificationListener
import com.intellij.openapi.externalSystem.service.project.ExternalSystemProjectResolver
import com.jetbrains.cidr.external.system.service.ExternalTaskDisposableCancellationService
import java.io.File

class MesonProjectResolver : ExternalSystemProjectResolver<MesonExecutionSettings> {
    override fun cancelTask(taskId: ExternalSystemTaskId, listener: ExternalSystemTaskNotificationListener): Boolean {
        return ExternalTaskDisposableCancellationService.getInstance().cancel(taskId)
    }

    override fun resolveProjectInfo(id: ExternalSystemTaskId, projectPath: String, isPreviewMode: Boolean, settings: MesonExecutionSettings?, listener: ExternalSystemTaskNotificationListener): DataNode<ProjectData>? {
        return doResolveProjectInfo(id, projectPath, settings, listener)

//        return super.resolveProjectInfo(id, projectPath, isPreviewMode, settings, listener)
    }

    private fun doResolveProjectInfo(id: ExternalSystemTaskId, projectPath: String, settings: MesonExecutionSettings?, listener: ExternalSystemTaskNotificationListener): DataNode<ProjectData>? {
        val projectPathIO = File(projectPath)
        val projectDirIO = if (projectPathIO.isDirectory) projectPathIO else projectPathIO.parentFile
        val projectName = projectDirIO.name
        val projectData = ProjectData(MesonProjectUtil.ID, projectName, projectDirIO.path, projectDirIO.path)
        val projectNode = DataNode<ProjectData>(ProjectKeys.PROJECT, projectData, null)

        return projectNode
    }
}