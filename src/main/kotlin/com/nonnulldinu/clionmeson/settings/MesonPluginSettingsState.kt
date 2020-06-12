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

    class State : BaseState(){
        val data : StoredProperty<MutableMap<String, String>> = map<String, String>().provideDelegate(this, "data")
    }

    var _state = State()

    override fun getState(): State? {
        return _state
    }

    override fun loadState(state: State) {
        _state = state
    }

    fun getValue(key: String): String? {
        return _state.data.getValue(_state)[key]
    }

    fun setValue(key: String, value: String) {
        _state.data.getValue(_state)[key] = value
    }
}