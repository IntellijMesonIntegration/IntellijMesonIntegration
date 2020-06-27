package com.nonnulldinu.clionmeson.buildsystem

import com.google.gson.Gson
import com.intellij.notification.Notifications
import com.intellij.openapi.progress.PerformInBackgroundOption
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.Task
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import com.jetbrains.cidr.cpp.compdb.CompDBWorkspace
import com.jetbrains.cidr.execution.build.CidrBuildResult
import com.jetbrains.cidr.project.workspace.CidrWorkspaceManager
import com.nonnulldinu.clionmeson.buildsystem.actions.OpenMesonLog
import com.nonnulldinu.clionmeson.buildsystem.meta.MesonBuildMeta
import com.nonnulldinu.clionmeson.buildsystem.target.MesonBuildTarget
import com.nonnulldinu.clionmeson.buildsystem.utils.MesonBuildUtilCached
import com.nonnulldinu.clionmeson.notifications.MesonBuildNotifications
import com.nonnulldinu.clionmeson.settings.MesonPluginSettingsState
import io.netty.util.internal.UnstableApi
import java.io.File
import java.io.FileInputStream

class MesonBuildSystem(var basePath: String, var mesonBuildRoot: String) {
    private var cachedMeta: MesonBuildUtilCached<MesonBuildMeta>? = null
    private var cachedTargets: MesonBuildUtilCached<Array<MesonBuildTarget>>? = null

    companion object {
        private val mesonBuildSystemInstanceKey = Key<MesonBuildSystem>("MesonBuildSystemInstance")
        fun createBuildSystem(project: Project) {
            object : Task.Backgroundable(project, "Initializing build system", false, PerformInBackgroundOption.DEAF) {
                override fun run(indicator: ProgressIndicator) {
                    val p: Process = ProcessBuilder().command(MesonPluginSettingsState.getInstance().getValue(MesonPluginSettingsState.MesonPath), "build").directory(File(project.basePath!!)).start()
                    p.waitFor()
                    Notifications.Bus.notify(when (p.exitValue()) {
                        0 -> MesonBuildNotifications.infoNotify("Successfully created the build system")
                        else -> MesonBuildNotifications.errNotify("Meson Build failed with exit code " + p.exitValue(), OpenMesonLog())
                    })
                }

                override fun onFinished() {
                    openOn(project)
                }
            }.queue()
        }

        fun getBuildSystem(project: Project): MesonBuildSystem {
            return project.getUserData(mesonBuildSystemInstanceKey)
                    ?: throw IllegalStateException("no meson build system found in the project")
        }

        fun openOn(project: Project): MesonBuildSystem {
            val ws = CidrWorkspaceManager.getInstance(project).initializedWorkspaces.find { it is CompDBWorkspace }
            val root = (if (ws == null) project.basePath else ws.contentRoot!!.absolutePath + "/..")!!
            val buildSystem = MesonBuildSystem(root, "$root/build")
            project.putUserData(mesonBuildSystemInstanceKey, buildSystem)
            return buildSystem
        }

        fun openOnCombDBWorkspace(project: Project): MesonBuildSystem {
            val ws = CidrWorkspaceManager.getInstance(project).initializedWorkspaces.find { it is CompDBWorkspace }
                    ?: throw IllegalArgumentException("No Compilation Database workspace found in project")
            val root = ws.contentRoot!!.absolutePath
            val buildSystem = MesonBuildSystem(root, "$root/build")
            project.putUserData(mesonBuildSystemInstanceKey, buildSystem)
            return buildSystem
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

        val targetsFilePath = "$mesonBuildRoot/meson-info/" + (cachedMeta?.value?.introspection?.information?.targets?.file)
        val targetsFile = File(targetsFilePath)
        if (!targetsFile.exists()) throw IllegalStateException("Cannot find the targets json file \"$targetsFilePath\" from meson-info.json")
        var targetsFileContent: String
        run {
            val targetsFileReader = FileInputStream(targetsFile)
            targetsFileContent = String(targetsFileReader.readAllBytes())
        }
        cachedTargets = MesonBuildUtilCached(targetsFile, Gson().fromJson(targetsFileContent, Array<MesonBuildTarget>::class.java)!!)
    }

    private fun reCacheMeta(forced: Boolean) {
        if (!forced && cachedMeta != null && !cachedMeta!!.shouldReload()) return
        val metaFilePath = "$mesonBuildRoot/meson-info/meson-info.json"
        val metaFile = File(metaFilePath)
        var metaFileContent: String
        if (!metaFile.exists()) throw IllegalStateException("Cannot find meson-info.json at \"$metaFilePath\"")
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

    /**
     * Compile all targets in the project
     */
    fun compile(): CidrBuildResult {
        val started = System.nanoTime()
        val p: Process = ProcessBuilder().directory(File(basePath)).command(
                MesonPluginSettingsState.getInstance().getValue(MesonPluginSettingsState.MesonPath), // meson
                "compile",                                                                           // compile
                "-C", "build"                                                                        // -C build
        ).start()
        p.waitFor()
        return CidrBuildResult(p.exitValue() == 0, false, started, message = String(p.inputStream.readAllBytes()))
    }

    @UnstableApi
    fun compile(target: MesonBuildTarget): CidrBuildResult {
        /// this is supposed to compile only the target given parameter
        /// will be rewritten and stable when https://github.com/mesonbuild/meson/pull/7181
        /// makes it into upstream meson
        /// for now it just compiles everything
        return compile()
    }
}