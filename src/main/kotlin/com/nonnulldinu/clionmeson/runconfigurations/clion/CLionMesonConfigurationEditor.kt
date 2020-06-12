package com.nonnulldinu.clionmeson.runconfigurations.clion

import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.options.ConfigurationException
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.ComboBoxWithWidePopup
import com.intellij.openapi.ui.LabeledComponent
import com.intellij.openapi.ui.TextBrowseFolderListener
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.util.ui.JBUI
import com.jetbrains.cidr.execution.BuildTargetData
import com.jetbrains.cidr.execution.ExecutableData
import com.nonnulldinu.clionmeson.buildsystem.MesonBuildSystem
import com.nonnulldinu.clionmeson.buildsystem.target.MesonBuildTarget
import java.awt.GridBagConstraints
import java.awt.GridLayout
import javax.swing.DefaultComboBoxModel
import javax.swing.JComponent
import javax.swing.JPanel

class CLionMesonConfigurationEditor(val project: Project) : SettingsEditor<CLionMesonRunConfiguration>() {
    private var panel: JPanel? = null
    private var target: LabeledComponent<ComboBoxWithWidePopup<*>>? = null

    private var workingDirectory: LabeledComponent<TextFieldWithBrowseButton>? = null

    override fun resetEditorFrom(config: CLionMesonRunConfiguration) {
        val targets = MesonBuildSystem.getBuildSystem(config.project).getTargets()
        target!!.component.model = DefaultComboBoxModel(targets)
        println(config.data?.target?.targetName)
        target!!.component.selectedIndex = targets.indexOfFirst { it.id == config.data?.target?.targetName }
        workingDirectory!!.component.text = config.workingDirectory ?: ""
    }

    override fun createEditor(): JComponent {
        panel = JPanel(GridLayout(2, 2))
        createUIComponents()
        return panel!!
    }

    @Throws(ConfigurationException::class)
    override fun applyEditorTo(config: CLionMesonRunConfiguration) {
        if (target!!.component.selectedItem == null) throw ConfigurationException("No target selected")
        config.executableData = ExecutableData(BuildTargetData(CLionMesonBuildTarget(config.project.name, (target!!.component.selectedItem as MesonBuildTarget).id)))
        config.workingDirectory = workingDirectory!!.component.text
    }

    private fun createUIComponents() {
        target = LabeledComponent<ComboBoxWithWidePopup<*>>()
        target!!.text = "Target"
        target!!.component = ComboBoxWithWidePopup<MesonBuildTarget>()
        val targetsArray = MesonBuildSystem.getBuildSystem(project).getTargets()
        target!!.component!!.model = DefaultComboBoxModel(targetsArray)
        target!!.component.selectedIndex = 0
        target!!.component.selectedItem = targetsArray[0]
        panel!!.add(target!!, GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START, 0, JBUI.emptyInsets(), 0, 0))

        workingDirectory = LabeledComponent()
        workingDirectory!!.text = "Working directory"
        workingDirectory!!.component = TextFieldWithBrowseButton()
        val desc = FileChooserDescriptor(false, true, false, false, false, false)
        workingDirectory!!.component.addBrowseFolderListener(TextBrowseFolderListener(desc))

        panel!!.add(workingDirectory!!, GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START, 0, JBUI.emptyInsets(), 0, 0))
    }

}
