package com.nonnulldinu.clionmeson.module

import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.roots.ModifiableRootModel

/**
 * Builder which is used when a new project or module is created and not imported from source.
 */
class MesonModuleBuilder : ModuleBuilder() {
    override fun setupRootModel(model: ModifiableRootModel) {}
    override fun getModuleType(): ModuleType<*> {
        return MesonModuleType.instance
    } //	@Nullable
    //	@Override
    //	public ModuleWizardStep getCustomOptionsStep(WizardContext context, Disposable parentDisposable) {
    ////		return new MesonWizardStep(projectGenerator, callback);
    //	}
}