package com.nonnulldinu.clionmeson.ide.newProject.ui;

import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import com.jetbrains.cidr.lang.modulemap.resolve.ModuleMapWalker;
import com.jetbrains.cidr.lang.modulemap.symbols.ModuleMapModuleSymbol;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;


public class NewProjectPanel extends ModuleBuilder {
	public void setupRootModel(ModifiableRootModel modifiableRootModel) throws ConfigurationException {

	}

	public ModuleType getModuleType() {
		return ModuleType.EMPTY;
	}

	@Override
	public ModuleWizardStep[] createWizardSteps(@NotNull WizardContext wizardContext, @NotNull ModulesProvider modulesProvider) {
		return new ModuleWizardStep[]{new ModuleWizardStep() {
			@Override
			public JComponent getComponent() {
				return new JLabel("Put your content here");
			}

			@Override
			public void updateDataModel() {

			}
		}};
	}
}