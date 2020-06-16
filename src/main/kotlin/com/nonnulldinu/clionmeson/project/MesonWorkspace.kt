package com.nonnulldinu.clionmeson.project

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.service
import com.intellij.openapi.module.Module
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.pointers.VirtualFilePointer
import com.intellij.util.xmlb.XmlSerializerUtil
import com.jetbrains.cidr.lang.workspace.headerRoots.HeadersSearchPath
import com.jetbrains.cidr.lang.workspace.headerRoots.HeadersSearchRoot
import com.jetbrains.cidr.lang.workspace.headerRoots.HeadersSearchRootFactory
import com.jetbrains.cidr.project.workspace.CidrWorkspace
import com.jetbrains.cidr.project.workspace.OCRootsSynchronizer
import com.nonnulldinu.clionmeson.buildsystem.MesonBuildSystem
import java.io.File
import java.nio.file.Path
import java.nio.file.Paths


@State(name = "MesonWorkspace")
class MesonWorkspace(project: Project) : CidrWorkspace(project), PersistentStateComponent<MesonWorkspace> {
    companion object {
        fun getInstance(project: Project): MesonWorkspace {
            return project.service()
        }
    }

    /// From CidrWorkspace
    override fun collectRootsInfo(file: File?): OCRootsSynchronizer.RootsInfo {
//        CMakeWorkspace
        println(file?.path)
        val rootsInfo = OCRootsSynchronizer.RootsInfo()

        val buildSystem = MesonBuildSystem.getBuildSystem(project)
        val targets = buildSystem.getTargets()
        for (details in targets) {
            for (targetSourceSet in details.targetSources) {
                for (targetSource in targetSourceSet.sources) {
                    if (targetSource == file?.absolutePath) {
                        targetSourceSet.parameters.forEach {
                            if (it.startsWith("-I")) rootsInfo.headersSearchRoots.add(rootOf(it.substring(2), project))
                        }
                        targetSourceSet.sources.forEach {
                            rootsInfo.sourceFiles.add(File(it))
                        }
                        targetSourceSet.generatedSources.forEach {
                            rootsInfo.generatedSourceFiles.add(File(it))
                        }

                        return rootsInfo
                    }
                }
            }
        }

        return rootsInfo
    }

    private fun rootOf(path: String, project: Project): HeadersSearchRoot {
        return HeadersSearchRootFactory.createSearchRoot(HeadersSearchPath.includes(path), project) {
            VfsUtil.findFile(Paths.get(path, it), true) as @org.jetbrains.annotations.NotNull VirtualFilePointer
        }
    }

    override fun isLinked(): Boolean {
        return super.isLinked()
    }

    override fun outsideFilesExist(rootsInfo: OCRootsSynchronizer.RootsInfo): Boolean {
        return super.outsideFilesExist(rootsInfo)
    }

    override fun shouldEnableRootConfiguration(): Boolean {
        return super.shouldEnableRootConfiguration()
    }

    override fun getBaseState(): State {
        return super.getBaseState()
    }

    override fun shouldLoadWorkspaceForProject(): Boolean {
        return super.shouldLoadWorkspaceForProject()
    }

    override fun getProjectPath(): Path {
        return super.getProjectPath()
    }

    override fun beforeUpdateContentRoots(contentRoot: File?): File? {
        return super.beforeUpdateContentRoots(contentRoot)
    }

    override fun loadBaseState(state: State) {
        super.loadBaseState(state)
    }

    override fun getContentRoot(): File? {
        return super.getContentRoot()
    }

    override fun collectExcludeRoots(contentRoot: File?, includePotentialNotYetExistingExcludes: Boolean): MutableList<File> {
        return super.collectExcludeRoots(contentRoot, includePotentialNotYetExistingExcludes)
    }

    override fun afterUpdateContentRoots(rootsInfo: OCRootsSynchronizer.RootsInfo) {
        super.afterUpdateContentRoots(rootsInfo)
    }

    override fun initializeAndStart(): Boolean {
        return super.initializeAndStart()
    }

    override fun getProjectDir(): File {
        return super.getProjectDir()
    }

    override fun reportFilesOutsideContentRoot(message: String, toolWindowId: String?) {
        super.reportFilesOutsideContentRoot(message, toolWindowId)
    }

    override fun noStateLoaded() {
        super<CidrWorkspace>.noStateLoaded()
    }

    override fun getModule(): Module? {
        return super.getModule()
    }

    override fun getProjectSubDir(subdir: Path): Path {
        return super.getProjectSubDir(subdir)
    }

    override fun getProject(): Project {
        return super.getProject()
    }

    override fun unload(projectClosing: Boolean): Boolean {
        return super.unload(projectClosing)
    }

    override fun changeContentRoot(contentRoot: VirtualFile?) {
        super.changeContentRoot(contentRoot)
    }

    override fun getEffectiveContentRoot(): VirtualFile? {
        return super.getEffectiveContentRoot()
    }

    override fun load(projectOpening: Boolean): Boolean {
        return super.load(projectOpening)
    }


    /// From PersistentStateComponent

    override fun getState(): MesonWorkspace? {
        return this
    }

    override fun loadState(state: MesonWorkspace) {
        XmlSerializerUtil.copyBean(state, this)
    }
}