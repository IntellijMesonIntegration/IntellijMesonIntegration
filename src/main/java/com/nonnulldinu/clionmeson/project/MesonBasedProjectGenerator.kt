package com.nonnulldinu.clionmeson.project

import com.intellij.ide.util.projectWizard.CustomStepProjectGenerator
import com.intellij.openapi.util.Ref
import com.jetbrains.cidr.cpp.cmake.projectWizard.generators.CLionProjectGenerator
import com.nonnulldinu.clionmeson.icons.PluginIcons
import javax.swing.Icon

abstract class MesonBasedProjectGenerator : CLionProjectGenerator<Ref<Array<String?>?>?>(), CustomStepProjectGenerator<Ref<Array<String?>?>?> {
    override fun getLogo(): Icon? {
        return PluginIcons.MESON_BUILD_ICON
    }

    override fun getGroupName(): String {
        return "Meson"
    }
}