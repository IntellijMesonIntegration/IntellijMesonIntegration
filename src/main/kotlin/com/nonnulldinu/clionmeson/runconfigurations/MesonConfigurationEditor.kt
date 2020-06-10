package com.nonnulldinu.clionmeson.runconfigurations

import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.options.ConfigurationException
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.ComboBoxWithWidePopup
import com.intellij.openapi.ui.LabeledComponent
import com.intellij.openapi.ui.TextBrowseFolderListener
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.uiDesigner.core.GridLayoutManager
import com.intellij.util.ui.JBUI
import com.nonnulldinu.clionmeson.buildsystem.MesonBuildSystem
import com.nonnulldinu.clionmeson.buildsystem.target.MesonBuildTarget
import java.awt.GridBagConstraints
import java.awt.GridLayout
import javax.swing.DefaultComboBoxModel
import javax.swing.JComponent
import javax.swing.JPanel

class MesonConfigurationEditor(val project: Project) : SettingsEditor<MesonConfiguration>() {
    private var panel: JPanel? = null
    private var target: LabeledComponent<ComboBoxWithWidePopup<*>>? = null
    private var targetsArray: Array<MesonBuildTarget>? = null

    private var workingDirectory: LabeledComponent<TextFieldWithBrowseButton>? = null

    override fun resetEditorFrom(config: MesonConfiguration) {
        target!!.component.selectedIndex = targetsArray!!.indexOf(config.state!!.target)
        workingDirectory!!.component.text = config.state!!.workingDirectory
    }

    @Throws(ConfigurationException::class)
    override fun applyEditorTo(config: MesonConfiguration) {
        config.state!!.target = targetsArray!![if (target!!.component.selectedIndex == -1) throw ConfigurationException("No target selected") else target!!.component.selectedIndex]
        config.state!!.workingDirectory = workingDirectory!!.component.text
    }

    override fun createEditor(): JComponent {
        panel = JPanel(GridLayout())
        createUIComponents()
        return panel!!
    }

    private fun createUIComponents() {
        target = LabeledComponent<ComboBoxWithWidePopup<*>>()
        target!!.text = "Target"
        target!!.component = ComboBoxWithWidePopup<String>()
        targetsArray = MesonBuildSystem.getBuildSystem(project).getTargets()
        val mesonTargetNames = Array(targetsArray!!.size) { i: Int -> targetsArray!![i].name + "(" + targetsArray!![i].id + ")" }
        target!!.component!!.model = DefaultComboBoxModel(mesonTargetNames)
        target!!.component.selectedIndex = 0
        target!!.component.selectedItem = targetsArray!![0]
        panel!!.add(target!!, GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START, 0, JBUI.emptyInsets(), 0, 0))

        workingDirectory = LabeledComponent()
        workingDirectory!!.text = "Working directory"
        workingDirectory!!.component = TextFieldWithBrowseButton()
        val desc = FileChooserDescriptor(false, true, false, false, false, false)
        workingDirectory!!.component.addBrowseFolderListener(TextBrowseFolderListener(desc))

        panel!!.add(workingDirectory!!, GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START, 0, JBUI.emptyInsets(), 0, 0))
    }
}
