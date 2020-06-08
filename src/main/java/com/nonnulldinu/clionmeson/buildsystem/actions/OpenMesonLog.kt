package com.nonnulldinu.clionmeson.buildsystem.actions

import com.intellij.notification.Notification
import com.intellij.notification.NotificationAction
import com.intellij.notification.Notifications
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.guessProjectDir
import com.intellij.openapi.vfs.VirtualFile
import com.nonnulldinu.clionmeson.notifications.MesonBuildNotifications

class OpenMesonLog : NotificationAction("Open Meson Log") {
    override fun actionPerformed(e: AnActionEvent, notification: Notification) {
        notification.expire()
        val p: Project = e.project!!
        val virtualLogFile: VirtualFile? = p.guessProjectDir()?.findFileByRelativePath("/build/meson-logs/meson-log.txt")
        if (virtualLogFile != null) {
            FileEditorManager.getInstance(p).openFile(virtualLogFile, true)
        } else {
            Notifications.Bus.notify(MesonBuildNotifications.errNotify("Cannot find the meson log file at " + p.guessProjectDir()?.path.plus("/build/meson-logs/meson-log.txt")))
        }
    }
}