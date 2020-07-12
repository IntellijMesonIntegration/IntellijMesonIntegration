package com.nonnulldinu.clionmeson.project

import com.intellij.openapi.externalSystem.model.Key
import com.jetbrains.cidr.external.system.model.ExternalModule

class MesonStateData {

    companion object {
        val STATE_DATA_KEY = Key.create(MesonStateData::class.java, ExternalModule.OC_MODULE_KEY.processingWeight + 1)
    }

}
