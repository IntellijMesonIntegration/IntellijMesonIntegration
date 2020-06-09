package com.nonnulldinu.clionmeson.services

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.project.Project
import com.intellij.util.xmlb.XmlSerializerUtil

interface MesonBuildStoreService : PersistentStateComponent<MesonBuildStoreService.State> {
    data class State(var mesonBuildRoot: String = "")

    companion object {
        fun getInstance(project: Project): MesonBuildStoreService? {
            return ServiceManager.getService(project, MesonBuildStoreService::class.java)
        }
    }

    override fun loadState(state: State) {
        XmlSerializerUtil.copyBean(state, this)
    }
}