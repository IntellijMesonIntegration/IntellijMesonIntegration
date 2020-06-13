package com.nonnulldinu.clionmeson.errorHandler

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class TriggerErrorAction : AnAction("Error Reporting: Trigger Exception") {
    override fun actionPerformed(e: AnActionEvent) {
        throw StackOverflowError("This is an artificial bug!")
    }
}