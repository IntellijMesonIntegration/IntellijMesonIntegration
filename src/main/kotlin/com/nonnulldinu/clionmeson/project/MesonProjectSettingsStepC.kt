package com.nonnulldinu.clionmeson.project

import com.intellij.ide.util.projectWizard.AbstractNewProjectStep
import com.intellij.openapi.ui.ComboBox
import com.intellij.openapi.util.Ref
import com.intellij.platform.DirectoryProjectGenerator
import com.intellij.util.ui.JBUI
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.event.ActionEvent
import javax.swing.*

class MesonProjectSettingsStepC(
        projectGenerator: DirectoryProjectGenerator<Ref<Array<SettingsProperty>>>,
        callback: AbstractNewProjectStep.AbstractCallback<Ref<Array<SettingsProperty>>>
) : MesonProjectSettingsStep(projectGenerator, callback) {
    companion object {
        const val LANG_STD_INDEX = 0
    }

    private var properties: Array<SettingsProperty> = arrayOf(SettingsProperty("LANG_STD", "C11"))

    override fun getSettings(): Ref<Array<SettingsProperty>> {
        return Ref<Array<SettingsProperty>>(properties)
    }

    override fun createAdvancedSettings(): JPanel? {
        val jPanel = JPanel(GridBagLayout())
        jPanel.border = BorderFactory.createEmptyBorder(0, 0, 0, 0)

        // language label and combobox
//        val languageLabel = JLabel("Language:")
//        val languageCombobox = ComboBox(arrayOf("C", "C++", "Rust", "Java"))
//        languageCombobox.selectedItem = "C++"
//        jPanel.add(languageLabel, GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START, 0, JBUI.emptyInsets(), 0, 0))
//        jPanel.add(languageCombobox, GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START, 0, JBUI.emptyInsets(), 0, 0))

        // standard label and combobox
        val standardLabel = JLabel("Language standard:")
        val standardCombobox = ComboBox<String>()
        jPanel.add(standardLabel, GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START, 0, JBUI.emptyInsets(), 0, 0))
        jPanel.add(standardCombobox, GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START, 0, JBUI.emptyInsets(), 0, 0))

        // create the spacer to push the items to the top left corner
        jPanel.add(Box.createGlue(), GridBagConstraints(2, 2, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, 0, JBUI.emptyInsets(), 0, 0))
        standardCombobox.model = DefaultComboBoxModel(arrayOf("C90", "C98", "C11"))
        standardCombobox.selectedIndex = standardCombobox.model.size - 1

        // listeners - see: https://stackoverflow.com/questions/58939/jcombobox-selection-change-listener
        standardCombobox.addActionListener {
            properties[LANG_STD_INDEX].set(standardCombobox.model.selectedItem as String)
        }

        return jPanel
    }
}