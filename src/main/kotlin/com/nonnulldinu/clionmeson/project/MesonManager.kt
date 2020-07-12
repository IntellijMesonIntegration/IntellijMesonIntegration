package com.nonnulldinu.clionmeson.project

import com.intellij.execution.configurations.SimpleJavaParameters
import com.intellij.openapi.externalSystem.ExternalSystemManager
import com.intellij.openapi.externalSystem.model.ProjectSystemId
import com.intellij.openapi.externalSystem.service.project.ExternalSystemProjectResolver
import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Pair
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.util.Function

class MesonManager : ExternalSystemManager<MesonProjectSettings, MesonSettingsListener, MesonSettings, MesonLocalSettings, MesonExecutionSettings> {
    companion object {
        val FILE_CHOOSER_DESCRIPTOR = object : FileChooserDescriptor(true, false, false, false, false, false) {
            override fun isFileSelectable(file: VirtualFile): Boolean {
                return super.isFileSelectable(file) && isMesonBuildFile(file)
            }
        }

        private fun isMesonBuildFile(file: VirtualFile): Boolean {
            return !file.isDirectory && file.name == "meson.build"
        }
    }

    override fun enhanceRemoteProcessing(parameters: SimpleJavaParameters) {}

    override fun getProjectResolverClass(): Class<out ExternalSystemProjectResolver<MesonExecutionSettings>> =
            MesonProjectResolver::class.java

    override fun getSettingsProvider(): Function<Project, MesonSettings> {
        return Function { MesonSettings.from(it) }
    }

    override fun getExecutionSettingsProvider(): Function<Pair<Project, String>, MesonExecutionSettings> {
        return Function {
            null!!
        }
    }

    override fun getExternalProjectDescriptor(): FileChooserDescriptor = FILE_CHOOSER_DESCRIPTOR

    override fun getSystemId(): ProjectSystemId = MesonProjectUtil.ID

    override fun getTaskManagerClass() = MesonTaskManager::class.java

    override fun getLocalSettingsProvider(): Function<Project, MesonLocalSettings> {
        return Function { MesonLocalSettings.from(it); }
    }
}