package com.nonnulldinu.clionmeson.buildsystem

import com.google.gson.Gson
import com.intellij.notification.Notifications
import com.intellij.openapi.progress.PerformInBackgroundOption
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.Task
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.guessProjectDir
import com.intellij.openapi.util.Key
import com.intellij.openapi.vfs.VirtualFile
import com.nonnulldinu.clionmeson.buildsystem.actions.OpenMesonLog
import com.nonnulldinu.clionmeson.buildsystem.meta.MesonBuildMeta
import com.nonnulldinu.clionmeson.buildsystem.target.MesonBuildTarget
import com.nonnulldinu.clionmeson.buildsystem.target.MesonBuildTargets
import com.nonnulldinu.clionmeson.buildsystem.utils.MesonBuildUtilCached
import com.nonnulldinu.clionmeson.notifications.MesonBuildNotifications
import java.io.File
import java.io.FileInputStream

class MesonBuildSystem(var mesonBuildRoot: VirtualFile) {
    private var cachedMeta: MesonBuildUtilCached<MesonBuildMeta>? = null
    private var cachedTargets: MesonBuildUtilCached<Array<MesonBuildTarget>>? = null

    companion object {
        private val mesonBuildSystemInstanceKey = Key<MesonBuildSystem>("MesonBuildSystemInstance")
        fun createBuildSystem(project: Project) {
            object : Task.Backgroundable(project, "Initializing build system", false, PerformInBackgroundOption.DEAF) {
                override fun run(indicator: ProgressIndicator) {
                    val p: Process = ProcessBuilder().command("/usr/bin/meson", "build").directory(File(project.basePath!!)).start()
                    p.waitFor()
                    if (p.exitValue() == 0)
                        Notifications.Bus.notify(MesonBuildNotifications.infoNotify("Successfully created the build system", OpenMesonLog()))
                    else {
                        Notifications.Bus.notify(MesonBuildNotifications.errNotify("Meson Build Failed", OpenMesonLog()))
                    }
                }

                override fun onFinished() {
                    project.putUserData(mesonBuildSystemInstanceKey, MesonBuildSystem(project.guessProjectDir()!!.findChild("build")!!))
                }
            }.queue()
        }

        fun getBuildSystem(project: Project): MesonBuildSystem {
            return project.getUserData(mesonBuildSystemInstanceKey)
                    ?: throw IllegalStateException("no meson build system found in the project")
        }
    }

    fun getTargets(): Array<MesonBuildTarget> {
        reCacheTargets(cachedTargets == null)
        return cachedTargets!!.value!!
    }

    private fun reCacheTargets(forced: Boolean = false) {
        reCacheMeta(cachedMeta == null)
        if (!forced && cachedTargets != null && !cachedTargets!!.shouldReload()) return
        if (cachedMeta == null) return

        val virtTargetsFile = mesonBuildRoot.findFileByRelativePath("/meson-info/" + (cachedMeta?.value?.introspection?.information?.targets?.file ?: throw IllegalStateException("Cannot find the targets.json file from meson-info.json"))) ?: return
        val targetsFile = File(virtTargetsFile.canonicalPath!!)
        var targetsFileContent: String
        run {
            val targetsFileReader = FileInputStream(targetsFile)
            targetsFileContent = String(targetsFileReader.readAllBytes())
        }
        cachedTargets = MesonBuildUtilCached(targetsFile, Gson().fromJson(targetsFileContent, Array<MesonBuildTarget>::class.java)!!)
    }

    private fun reCacheMeta(forced: Boolean) {
        if (!forced && cachedMeta != null && !cachedMeta!!.shouldReload()) return
        val virtMetaFile = mesonBuildRoot.findFileByRelativePath("/meson-info/meson-info.json") ?: return
        val metaFile = File(virtMetaFile.canonicalPath!!)
        var metaFileContent: String
        run {
            val metaFileReader = FileInputStream(metaFile)
            metaFileContent = String(metaFileReader.readAllBytes())
        }
        cachedMeta = MesonBuildUtilCached(metaFile, Gson().fromJson(metaFileContent, MesonBuildMeta::class.java)!!)
    }

    private fun dropCachedTargets() {
        cachedTargets = null
    }

    private fun dropCachedMeta() {
        cachedMeta = null
    }

    fun dropCaches() {
        dropCachedTargets()
        dropCachedMeta()
    }
}