package com.nonnulldinu.clionmeson.settings

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

@State(
        name = "com.nonnulldinu.clionmeson.settings.MesonPluginSettingsState",
        storages = [Storage("MesonIntegrationPlugin.xml")]
)
class MesonPluginSettingsState : PersistentStateComponent<MesonPluginSettingsState> {
    companion object {
        fun getInstance(): MesonPluginSettingsState {
            return ServiceManager.getService(MesonPluginSettingsState::class.java)
        }
    }

    override fun getState(): MesonPluginSettingsState? {
        return this
    }

    override fun loadState(state: MesonPluginSettingsState) {
        XmlSerializerUtil.copyBean(state, this)
    }
}