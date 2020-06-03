package com.nonnulldinu.clionmeson.module;

import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.roots.ModifiableRootModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Builder which is used when a new project or module is created and not imported from source.
 */
public class MesonModuleBuilder extends ModuleBuilder {
	@Override
	public void setupRootModel(@NotNull ModifiableRootModel model) {

	}

	@Override
	public ModuleType getModuleType() {
		return MesonModuleType.getInstance();
	}

	@Nullable
	@Override
	public ModuleWizardStep getCustomOptionsStep(WizardContext context, Disposable parentDisposable) {
		return new MesonWizardStep();
	}
}