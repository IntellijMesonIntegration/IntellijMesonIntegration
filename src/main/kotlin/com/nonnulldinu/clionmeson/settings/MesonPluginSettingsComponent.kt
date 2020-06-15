package com.nonnulldinu.clionmeson.settings

import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.JComponent
import javax.swing.JPanel


class MesonPluginSettingsComponent {
    private var mainPanel: JPanel? = null
    private val mesonPath = TextFieldWithBrowseButton()

    init {
        mainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(JBLabel("Meson executable path: "), mesonPath, 1, false)
                .addComponentFillVertically(JPanel(), 0)
                .panel
    }

    fun getPanel(): JPanel? {
        return mainPanel
    }

    fun getPreferredFocusedComponent(): JComponent? {
        return mesonPath
    }

    fun getMesonPathText(): String {
        return mesonPath.text
    }

    fun setMesonPathText(newText: String) {
        mesonPath.text = newText
    }

    fun mesonPathNotInSettings() {
    }
}