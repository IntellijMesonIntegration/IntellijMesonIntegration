package com.nonnulldinu.clionmeson.project

import com.intellij.openapi.externalSystem.settings.ExternalSystemSettingsListener
import com.intellij.util.messages.Topic
import com.jetbrains.cidr.cpp.compdb.settings.CompDBSettingsListener

class MesonSettingsListener : ExternalSystemSettingsListener<MesonProjectSettings> {
    companion object{
        val TOPIC = Topic.create("Meson specific settings", CompDBSettingsListener::class.java)
    }
    override fun onBulkChangeEnd() {
        TODO("Not yet implemented")
    }

    override fun onProjectRenamed(oldName: String, newName: String) {
        TODO("Not yet implemented")
    }

    override fun onBulkChangeStart() {
        TODO("Not yet implemented")
    }

    override fun onProjectsLinked(settings: MutableCollection<MesonProjectSettings>) {
        TODO("Not yet implemented")
    }

    override fun onProjectsUnlinked(linkedProjectPaths: MutableSet<String>) {
        TODO("Not yet implemented")
    }
}