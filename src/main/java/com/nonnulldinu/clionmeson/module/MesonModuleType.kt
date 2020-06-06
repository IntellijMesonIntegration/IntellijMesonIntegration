package com.nonnulldinu.clionmeson.module

import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.module.ModuleTypeManager
import com.intellij.openapi.roots.ui.configuration.ModulesProvider
import com.nonnulldinu.clionmeson.icons.PluginIcons
import javax.swing.Icon

class MesonModuleType : ModuleType<MesonModuleBuilder>(ID) {
    override fun createModuleBuilder(): MesonModuleBuilder {
        return MesonModuleBuilder()
    }

    override fun getName(): String {
        return "SDK Module Type"
    }

    override fun getDescription(): String {
        return "Example custom module type"
    }

    override fun getNodeIcon(b: Boolean): Icon {
        return PluginIcons.MESON_BUILD_ICON
    }

    override fun createWizardSteps(wizardContext: WizardContext,
                                   moduleBuilder: MesonModuleBuilder,
                                   modulesProvider: ModulesProvider): Array<ModuleWizardStep> {
        return super.createWizardSteps(wizardContext, moduleBuilder, modulesProvider)
    }

    companion object {
        private const val ID = "DEMO_MODULE_TYPE"
        val instance: MesonModuleType
            get() = ModuleTypeManager.getInstance().findByID(ID) as MesonModuleType
    }
}