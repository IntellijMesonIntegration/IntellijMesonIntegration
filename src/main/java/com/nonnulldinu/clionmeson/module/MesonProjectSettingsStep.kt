package com.nonnulldinu.clionmeson.module

import com.intellij.ide.util.projectWizard.AbstractNewProjectStep.AbstractCallback
import com.intellij.ide.util.projectWizard.ProjectSettingsStepBase
import com.intellij.openapi.ui.ComboBox
import com.intellij.openapi.util.Ref
import com.intellij.platform.DirectoryProjectGenerator
import com.intellij.util.ui.JBUI
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.event.ActionEvent
import javax.swing.*

class MesonProjectSettingsStep(projectGenerator: DirectoryProjectGenerator<Ref<Array<String?>?>?>, callback: AbstractCallback<Ref<Array<String?>?>?>)
    : ProjectSettingsStepBase<Ref<Array<String?>?>?>(projectGenerator, callback) {
    override fun createAdvancedSettings(): JPanel? {
        val jPanel = JPanel(GridBagLayout())
        jPanel.border = BorderFactory.createEmptyBorder(0, 0, 0, 0)

        // language label and combobox
        val languageLabel = JLabel("Language:")
        val languageCombobox = ComboBox(arrayOf("C", "C++", "Rust", "Java"))
        languageCombobox.selectedItem = "C++"
        jPanel.add(languageLabel, GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START, 0, JBUI.emptyInsets(), 0, 0))
        jPanel.add(languageCombobox, GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START, 0, JBUI.emptyInsets(), 0, 0))

        // standard label and combobox
        val standardLabel = JLabel("Language standard:")
        val standardCombobox = ComboBox<String>()
        jPanel.add(standardLabel, GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START, 0, JBUI.emptyInsets(), 0, 0))
        jPanel.add(standardCombobox, GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START, 0, JBUI.emptyInsets(), 0, 0))

        // create the spacer to push the items to the top left corner
        jPanel.add(Box.createGlue(), GridBagConstraints(2, 2, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, 0, JBUI.emptyInsets(), 0, 0))

        // listeners - see: https://stackoverflow.com/questions/58939/jcombobox-selection-change-listener
        languageCombobox.addActionListener { e: ActionEvent? ->
            val model: DefaultComboBoxModel<String> = when (languageCombobox.selectedIndex) {
                0 -> DefaultComboBoxModel(arrayOf("C90", "C99", "C11"))
                1 -> DefaultComboBoxModel(arrayOf("C++98", "C++11", "C++14", "C++17", "C++20"))
                2 -> DefaultComboBoxModel(arrayOf("Rust v1.38.0"))
                3 -> DefaultComboBoxModel(arrayOf("Java 8", "Java 11", "Java 14"))
                else -> DefaultComboBoxModel()
            }
            standardCombobox.model = model
            standardCombobox.setSelectedIndex(standardCombobox.model.size - 1)
        }

        // emit the signal update the standardCombobox
        languageCombobox.actionPerformed(null)
        return jPanel
    }
}