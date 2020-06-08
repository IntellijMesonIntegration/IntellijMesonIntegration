package com.nonnulldinu.clionmeson.notifications

import com.intellij.notification.Notification
import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project

object MesonBuildNotifications {
    private val notificationGroup = NotificationGroup("Meson Build", NotificationDisplayType.BALLOON, true)

    fun errNotify(content: String): Notification {
        return createNotify(content, NotificationType.ERROR)
    }

    fun infoNotify(content: String): Notification {
        return createNotify(content, NotificationType.INFORMATION)
    }

    private fun createNotify(content: String, notificationType: NotificationType): Notification {
        return notificationGroup.createNotification(content, notificationType)
    }
}