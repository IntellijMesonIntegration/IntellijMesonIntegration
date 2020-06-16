package com.nonnulldinu.clionmeson.project

import com.intellij.ide.IdeBundle
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.ApplicationNamesInfo
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManager
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.util.Key
import com.intellij.openapi.util.Pair
import com.intellij.openapi.util.io.FileUtil
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VirtualFile
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
        return run {
            val var6 = util(vfile)
            if (!ApplicationManager.getApplication().isHeadlessEnvironment) {
                val var8 = ApplicationNamesInfo.getInstance().fullProductName
                val var11 = FileUtil.getRelativePath((var6.second as MesonOpenProjectSpec).generationDir, (var6.second as MesonOpenProjectSpec).sourceDir)
                if (Messages.showOkCancelDialog(projectToClose, "Selected directory contains generated CMake files.\nDo you want to open the source directory " + (var11
                                ?: (var6.second as MesonOpenProjectSpec).sourceDir) + "?\n", IdeBundle.message("title.open.project"), IdeBundle.message("button.yes"), IdeBundle.message("button.cancel"), Messages.getQuestionIcon()) != 0) {
                    return null
                }
            }
//            return ProjectManager.getInstance().loadAndOpenProject(VfsUtil.virtualToIoFile(virtualFile.findFileByRelativePath("/build/compile_commands.json")!!))
            projectOpenHelper.openProject((var6.first as VirtualFile), projectToClose, forceOpenInNewFrame, var6.second)
        }
    }

    private fun util(var0: VirtualFile): Pair<VirtualFile?, MesonOpenProjectSpec?> {
        val var3 = VfsUtilCore.virtualToIoFile(var0.parent)
        val var5: VirtualFile? = var0
        val var6: File = var3
        val var7: File? = null
        val var8: String? = null
        val var9: String? = null
        return Pair.create(var5, MesonOpenProjectSpec(var6, var7, var8, var9))
    }
}