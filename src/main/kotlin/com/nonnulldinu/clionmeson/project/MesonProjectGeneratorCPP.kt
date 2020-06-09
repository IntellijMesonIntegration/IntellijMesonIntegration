package com.nonnulldinu.clionmeson.project

import com.intellij.ide.util.projectWizard.AbstractNewProjectStep
import com.intellij.openapi.module.Module
import com.intellij.openapi.progress.PerformInBackgroundOption
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.Task
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Ref
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.wm.impl.welcomeScreen.AbstractActionWithPanel
import com.intellij.platform.DirectoryProjectGenerator
import com.intellij.platform.GeneratorPeerImpl
import com.intellij.platform.ProjectGeneratorPeer
import com.nonnulldinu.clionmeson.buildsystem.MesonBuildSystem
import java.io.File
import java.io.FileOutputStream
import javax.swing.JPanel

class MesonProjectGeneratorCPP : MesonBasedProjectGenerator() {
    private var settingsStep: MesonProjectSettingsStepCPP? = null
    override fun createStep(projectGenerator: DirectoryProjectGenerator<Ref<Array<SettingsProperty>>>, callback: AbstractNewProjectStep.AbstractCallback<Ref<Array<SettingsProperty>>>): AbstractActionWithPanel {
        settingsStep = MesonProjectSettingsStepCPP(projectGenerator, callback)
        return settingsStep!!
    }

    override fun getName(): String {
        return "C++"
    }

    override fun getDescription(): String? {
        return "Meson-based C++ project"
    }

    override fun createPeer(): ProjectGeneratorPeer<Ref<Array<SettingsProperty>>> {
        return GeneratorPeerImpl(settingsStep!!.getSettings(), JPanel())
    }

    override fun generateProject(project: Project, baseDir: VirtualFile, settings: Ref<Array<SettingsProperty>>, module: Module) {
        doGenerateProject(project, settings, baseDir)
    }

    private fun doGenerateProject(project: Project,
                                  settings: Ref<Array<SettingsProperty>>,
                                  baseDir: VirtualFile) {
        val projRoot: String? = project.basePath
        val mesonBuildFile: String = projRoot!! + "/meson.build"
        val mainFile = "$projRoot/main.cpp"
        object : Task.Backgroundable(project, "Initializing project", false, PerformInBackgroundOption.DEAF) {
            override fun run(indicator: ProgressIndicator) {
                run {
                    val f = File(mesonBuildFile)
                    f.createNewFile()
                    val fs = FileOutputStream(f)
                    val cppStd = when (settings.get()[MesonProjectSettingsStepCPP.LANG_STD_INDEX].prop_value) {
                        "C++98" -> "c++98"
                        "C++11" -> "c++0x"
                        "C++14" -> "c++1y"
                        "C++17" -> "c++1z"
                        "C++20" -> "c++2a"
                        else -> ""
                    }
                    fs.write(("project ('" + project.name + "', 'cpp', version: '1.0', default_options: [\n" +
                            "                'cpp_std=$cppStd'\n" +
                            "])\n" +
                            "\n" +
                            "executable('" + project.name + "', files('main.cpp'))\n").toByteArray())
                    fs.close()
                }
                run {
                    val f = File(mainFile)
                    f.createNewFile()
                    val fs = FileOutputStream(f)
                    fs.write(("#include <iostream>\n" +
                            "\n" +
                            "int main()\n" +
                            "{\n" +
                            "\tstd::cout << \"Hello World!\\n\";\n" +
                            "\treturn 0;\n" +
                            "}").toByteArray())
                    fs.close()
                }
            }

            override fun onFinished() {
                MesonBuildSystem.createBuildSystem(project)
            }
        }.queue()
    }
}