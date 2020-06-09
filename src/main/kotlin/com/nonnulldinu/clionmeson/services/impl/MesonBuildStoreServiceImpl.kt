package com.nonnulldinu.clionmeson.services.impl

import com.intellij.openapi.project.Project
import com.nonnulldinu.clionmeson.services.MesonBuildStoreService

class MesonBuildStoreServiceImpl(project: Project?) : MesonBuildStoreService {
    private var state: MesonBuildStoreService.State = MesonBuildStoreService.State()
    override fun getState(): MesonBuildStoreService.State? {
        return state
    }
}