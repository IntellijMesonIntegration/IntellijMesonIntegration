package com.nonnulldinu.clionmeson.notifications

import com.intellij.notification.Notification
import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project

class MesonBuildNotification {
    companion object {
        val notificationGroup = NotificationGroup("Meson Build", NotificationDisplayType.BALLOON, true)
    }
    fun errNotify(content: String?): Notification {
        return errNotify(null, content)
    }

    fun errNotify(project: Project?, content: String?): Notification {
        val notification = notificationGroup.createNotification(content!!, NotificationType.ERROR)
        notification.notify(project)
        return notification
    }
}