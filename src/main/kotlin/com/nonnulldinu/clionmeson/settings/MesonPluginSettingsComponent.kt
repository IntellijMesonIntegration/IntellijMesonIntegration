package com.nonnulldinu.clionmeson.settings

import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.JComponent
import javax.swing.JPanel


class MesonPluginSettingsComponent {
    private var myMainPanel: JPanel? = null
    private val myUserNameText = JBTextField()
    private val myIdeaUserStatus = JBCheckBox("Do You Use IntelliJ IDEA? ")

    fun AppSettingsComponent() {
        myMainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(JBLabel("Enter User Name: "), myUserNameText, 1, false)
                .addComponent(myIdeaUserStatus, 1)
                .addComponentFillVertically(JPanel(), 0)
                .panel
    }

    fun getPanel(): JPanel? {
        return myMainPanel
    }

    fun getPreferredFocusedComponent(): JComponent? {
        return myUserNameText
    }

    fun getUserNameText(): String {
        return myUserNameText.text
    }

    fun setUserNameText(newText: String) {
        myUserNameText.text = newText
    }

    fun getIdeaUserStatus(): Boolean {
        return myIdeaUserStatus.isSelected
    }

    fun setIdeaUserStatus(newStatus: Boolean) {
        myIdeaUserStatus.isSelected = newStatus
    }
}