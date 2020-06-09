package com.nonnulldinu.clionmeson.notifications

import com.intellij.notification.Notification
import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationType
import com.intellij.openapi.actionSystem.AnAction

object MesonBuildNotifications {
    private val notificationGroup = NotificationGroup("Meson Build", NotificationDisplayType.BALLOON, true)

    fun errNotify(content: String, vararg actions: AnAction): Notification {
        return createNotify(content, NotificationType.ERROR, actions)
    }

    fun infoNotify(content: String, vararg actions: AnAction): Notification {
        return createNotify(content, NotificationType.INFORMATION, actions)
    }

    private fun createNotify(content: String, notificationType: NotificationType, actions: Array<out AnAction>): Notification {
        val notification : Notification = notificationGroup.createNotification(content, notificationType)
        for (action : AnAction in actions) {
            notification.addAction(action)
        }
        return notification
    }
}