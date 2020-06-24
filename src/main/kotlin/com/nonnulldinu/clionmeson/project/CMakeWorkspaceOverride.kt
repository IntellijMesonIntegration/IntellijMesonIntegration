/*
 * Copyright 2018 The Bazel Authors. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.nonnulldinu.clionmeson.project

import com.intellij.ide.actions.ShowFilePathAction
import com.intellij.notification.*
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.openapi.roots.ModuleRootModificationUtil
import com.intellij.openapi.roots.impl.storage.ClassPathStorageUtil
import com.intellij.openapi.roots.impl.storage.ClasspathStorage
import com.nonnulldinu.clionmeson.Meson
import java.io.File
import java.util.*
import java.util.stream.Collectors
import javax.swing.event.HyperlinkEvent

/**
 * Notify users to convert old CMake+Blaze projects into pure Blaze projects, and avoid scanning
 * overly broad roots.
 *
 *
 * If CMake claims a module before Blaze is able to claim it with [ ] (old projects), then it may make modifications to
 * (1) the "classpath", and (2) content entries + libraries. The libraries may be okay, but the
 * content entries are likely too broad: b/79884939 and cause "Scanning files" to run ~forever.
 *
 *
 * #api181: After enough modules are migrated to BlazeCppModuleType, perhaps this will become
 * unnecessary. See EventLoggingService data to see how often this comes up.
 */
internal object CMakeWorkspaceOverride {
    fun undoCMakeModifications(project: Project) {
        if (!Meson.isMesonProject(project)) {
            return
        }
        var notified = false
        for (module in getCMakeModules(project)) {
            clearClasspath(module)
            clearContentRootsAndLibrariesIfModifiedForCMake(module)
            if (!notified) {
                suggestRemedies(project)
                notified = true
            }
        }
    }

    /** Get any modules marked with the CMake classpath  */
    private fun getCMakeModules(project: Project): List<Module> {
        // We could check for old CPP_MODULE type, but some modules are already partially migrated to
        // the new BLAZE_CPP_MODULE type. Instead, check for the CMake "classpath".
        return Arrays.stream(ModuleManager.getInstance(project).modules)
                .filter { module: Module? -> "CMake" == ClassPathStorageUtil.getStorageType(module!!) }
                .collect(Collectors.toList())
    }

    private fun clearClasspath(module: Module) {
        ClasspathStorage.setStorageType(
                ModuleRootManager.getInstance(module), ClassPathStorageUtil.DEFAULT_STORAGE)
        Logger.getInstance(CMakeWorkspaceOverride::class.java).warn("Had to clear CMake classpath")
        Meson.log(CMakeWorkspaceOverride::class.java, "cleared-cmake-classpath")
    }

    private fun clearContentRootsAndLibrariesIfModifiedForCMake(module: Module) {
        ModuleRootModificationUtil.updateModel(
                module
        ) { modifiableModel: ModifiableRootModel ->
            if (areLibrariesAndRootsModifiedByCMake(modifiableModel)) {
                // Nuke the roots from orbit.
                modifiableModel.clear()
            }
        }
    }

    private fun areLibrariesAndRootsModifiedByCMake(modifiableModel: ModifiableRootModel): Boolean {
        val table = modifiableModel.moduleLibraryTable
        return table.getLibraryByName("Header Search Paths") != null
    }

    private fun suggestRemedies(project: Project) {
        Logger.getInstance(CMakeWorkspaceOverride::class.java)
                .warn("Need to migrate hybrid CMake+Blaze project")
        Meson.log(
                CMakeWorkspaceOverride::class.java,
                "must-migrate-hybrid-cmake-blaze-project"
        )
        val projectFilePath = project.projectFilePath ?: return
        val projectFile = File(projectFilePath)
        val notificationGroup = NotificationGroup("Migrate CMake Module", NotificationDisplayType.STICKY_BALLOON, true)
        val notificationListener: NotificationListener = object : NotificationListener.Adapter() {
            override fun hyperlinkActivated(notification: Notification, event: HyperlinkEvent) {
                notification.expire()
                @Suppress("UnstableApiUsage")
                ShowFilePathAction.openFile(projectFile)
                Meson.log(
                        CMakeWorkspaceOverride::class.java,
                        "must-migrate-hybrid-cmake-blaze-opened-xml"
                )
            }
        }

        /// no idea what to do with this
        val notification = Notification(
                notificationGroup.displayId,
                "CMake -> Meson Conversion Required",
                "Detected old CMake project.<br>"
                        + "Please reimport the project. Or, try these manual steps:<br>"
                        + "<ul>"
                        + "  <li>Open <a href=\"open_project_xml\">"
                        + projectFile.name
                        + "</a>"
                        + "  <li>Close project"
                        + "  <li>Remove &lt;component name=\"CMakeWorkspace\" "
                        + "PROJECT_DIR=\"\$PROJECT_DIR$\" /&gt;"
                        + "  <li>Reopen project."
                        + "  <li>Re-run blaze sync."
                        + "</ul>",
                NotificationType.WARNING,
                notificationListener)
        notification.isImportant = true
        notification.notify(project)
    }
}