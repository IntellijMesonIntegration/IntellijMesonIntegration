package com.nonnulldinu.clionmeson.module;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.ModuleTypeManager;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import com.nonnulldinu.clionmeson.icons.MesonIcons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class MesonModuleType extends ModuleType<MesonModuleBuilder> {
	private static final String ID = "DEMO_MODULE_TYPE";

	public MesonModuleType() {
		super(ID);
	}

	public static MesonModuleType getInstance() {
		return (MesonModuleType) ModuleTypeManager.getInstance().findByID(ID);
	}

	@NotNull
	@Override
	public MesonModuleBuilder createModuleBuilder() {
		return new MesonModuleBuilder();
	}

	@NotNull
	@Override
	public String getName() {
		return "SDK Module Type";
	}

	@NotNull
	@Override
	public String getDescription() {
		return "Example custom module type";
	}

	@NotNull
	@Override
	public Icon getNodeIcon(@Deprecated boolean b) {
		return MesonIcons.FILE;
	}

	@NotNull
	@Override
	public ModuleWizardStep[] createWizardSteps(@NotNull WizardContext wizardContext,
	                                            @NotNull MesonModuleBuilder moduleBuilder,
	                                            @NotNull ModulesProvider modulesProvider) {
		return super.createWizardSteps(wizardContext, moduleBuilder, modulesProvider);
	}
}
