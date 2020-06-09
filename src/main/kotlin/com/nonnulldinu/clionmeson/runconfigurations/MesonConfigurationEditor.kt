package com.nonnulldinu.clionmeson.runconfigurations

import com.intellij.openapi.options.ConfigurationException
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.ComboBoxWithWidePopup
import com.intellij.openapi.ui.LabeledComponent
import com.nonnulldinu.clionmeson.buildsystem.MesonBuildSystem
import com.nonnulldinu.clionmeson.buildsystem.target.MesonBuildTarget
import javax.swing.DefaultComboBoxModel
import javax.swing.JComponent
import javax.swing.JPanel

class MesonConfigurationEditor(val project: Project) : SettingsEditor<MesonConfiguration>() {
    private var panel: JPanel? = null
    private var target: LabeledComponent<ComboBoxWithWidePopup<*>>? = null
    private var targetsArray: Array<MesonBuildTarget>? = null

    override fun resetEditorFrom(config: MesonConfiguration) {
        target!!.component.selectedIndex = targetsArray!!.indexOf(config.state!!.target)
    }

    @Throws(ConfigurationException::class)
    override fun applyEditorTo(config: MesonConfiguration) {
        config.state!!.target = targetsArray!![if (target!!.component.selectedIndex == -1) 0 else target!!.component.selectedIndex]
    }

    override fun createEditor(): JComponent {
        panel = JPanel()
        createUIComponents()
        return panel!!
    }

    private fun createUIComponents() {
        target = LabeledComponent<ComboBoxWithWidePopup<*>>()
        target!!.component = ComboBoxWithWidePopup<String>()
        targetsArray = MesonBuildSystem.getBuildSystem(project).getTargets()
        val mesonTargetNames = Array(targetsArray!!.size) { i: Int -> targetsArray!![i].name + "(" + targetsArray!![i].id + ")" }
        target!!.component!!.model = DefaultComboBoxModel(mesonTargetNames)
        target!!.component.selectedIndex = 0
        target!!.component.selectedItem = targetsArray!![0]
        panel!!.add(target)
    }
}
