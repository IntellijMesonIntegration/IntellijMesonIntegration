package com.nonnulldinu.clionmeson.project

import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.externalSystem.model.ProjectSystemId

object MesonProjectUtil {
    val LOG: Logger = Logger.getInstance("meson_integration")
    val ID = ProjectSystemId("Meson", MesonBundle.message("external.system.name"))
}