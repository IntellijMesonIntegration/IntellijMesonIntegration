package com.nonnulldinu.clionmeson.project

import com.intellij.openapi.externalSystem.model.Key
import com.intellij.openapi.externalSystem.service.project.manage.AbstractProjectDataService
import com.intellij.openapi.module.Module

class MesonProjectDataService : AbstractProjectDataService<MesonStateData, Module>() {
    override fun getTargetDataKey(): Key<MesonStateData> {
        return MesonStateData.STATE_DATA_KEY
    }
}