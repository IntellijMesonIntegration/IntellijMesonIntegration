package com.nonnulldinu.clionmeson.settings

import com.intellij.openapi.components.*

@State(
        name = "com.nonnulldinu.clionmeson.settings.MesonPluginSettingsState",
        storages = [Storage("MesonIntegrationPlugin.xml")]
)
class MesonPluginSettingsState : PersistentStateComponent<MesonPluginSettingsState.State> {
    companion object {
        const val MesonPath = "meson.executable.path"

        fun getInstance(): MesonPluginSettingsState {
            return ServiceManager.getService(MesonPluginSettingsState::class.java)
        }
    }

    class State {
        var data = HashMap<String, String>()
    }

    var _state = State()

    override fun getState(): State? = _state

    override fun loadState(state: State) {
        _state = state
    }

    fun getValue(key: String): String? = _state.data[key]

    fun setValue(key: String, value: String) {
        _state.data[key] = value
    }
}