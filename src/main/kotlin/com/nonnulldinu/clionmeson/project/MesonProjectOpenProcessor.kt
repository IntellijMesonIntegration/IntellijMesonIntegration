package com.nonnulldinu.clionmeson.project

import com.intellij.ide.IdeBundle
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.externalSystem.service.execution.ProgressExecutionMode
import com.intellij.openapi.externalSystem.util.ExternalSystemUtil
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.util.Key
import com.intellij.openapi.util.Pair
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.util.Consumer
import com.jetbrains.cidr.CidrProjectOpenProcessor
import com.jetbrains.cidr.ProjectOpenFileHelper
import java.io.File

class MesonProjectOpenProcessor : CidrProjectOpenProcessor("Meson Project", projectOpenHelper) {
    companion object {
        private val DATA_KEY = Key.create<MesonOpenProjectSpec>("MESON_FILE_TO_OPEN_KEY")
        private val SUPPORTED_FILES = listOf("meson.build")

        private val projectOpenHelper = ProjectOpenFileHelper(SUPPORTED_FILES, DATA_KEY)
    }

    class MesonOpenProjectSpec(
            val sourceDir: File,
            val generationDir: File?,
            val buildType: String?,
            val generator: String?)

    override fun canOpenProject(file: VirtualFile): Boolean {
        val vfile = projectOpenHelper.findSupportedSubFile(file)
        return if (vfile == null) false else super.canOpenProject(vfile)
    }

    override fun doOpenProject(virtualFile: VirtualFile, projectToClose: Project?, forceOpenInNewFrame: Boolean): Project? {
        // Taken mostly from CMakeProjectOpenProcessor
        val vfile = projectOpenHelper.findSupportedSubFile(virtualFile) ?: return null
        if (!ApplicationManager.getApplication().isHeadlessEnvironment) {
            if (Messages.showOkCancelDialog(projectToClose, "Selected directory looks like a meson project.\nDo you want to open it as one?\n",
                            IdeBundle.message("title.open.project"), IdeBundle.message("button.yes"),
                            IdeBundle.message("button.no"), Messages.getQuestionIcon()) != 0) {
                return null
            }
        }
        val v = util(vfile)
        val project = projectOpenHelper.openProject(v.first
                ?: virtualFile, projectToClose, forceOpenInNewFrame, v.second) ?: return null
        val resultListener = Consumer<Boolean> {
            val var10000 = MesonProjectUtil.LOG
            val var10001 = StringBuilder().append("Opening Meson \"").append(project.name).append("\" project ")
            var10000.debug(var10001.append(if (it!!) "finished successfully!" else "failed!").toString())
        }
        val settings = MesonProjectSettings.default()
        settings.externalProjectPath = vfile.parent.path
        ExternalSystemUtil.linkExternalProject(MesonProjectUtil.ID, settings, project, resultListener, false, if (ApplicationManager.getApplication().isUnitTestMode) ProgressExecutionMode.MODAL_SYNC else ProgressExecutionMode.IN_BACKGROUND_ASYNC)
        return project
    }

    private fun util(var0: VirtualFile): Pair<VirtualFile, MesonOpenProjectSpec> {
        val var3 = VfsUtil.virtualToIoFile(var0.parent)
        val var5: VirtualFile? = var0
        val var6: File = var3
        val var7: File? = null
        val var8: String? = null
        val var9: String? = null
        return Pair.create(var5, MesonOpenProjectSpec(var6, var7, var8, var9))
    }


    override fun isStrongProjectInfoHolder(): Boolean {
        return true
    }
}