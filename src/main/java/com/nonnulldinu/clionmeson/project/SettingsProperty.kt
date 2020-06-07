package com.nonnulldinu.clionmeson.project

class SettingsProperty(prop_name: String, prop_default_value: String) {
    val prop_name: String = prop_name
    var prop_value: String = prop_default_value
    fun set(v: String) {
        prop_value = v
    }
}
