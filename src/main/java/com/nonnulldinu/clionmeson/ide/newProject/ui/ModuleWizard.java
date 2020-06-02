package com.nonnulldinu.clionmeson.ide.newProject.ui;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;

import javax.swing.*;

public class ModuleWizard extends ModuleWizardStep {
	@Override
	public JComponent getComponent() {
		return new JLabel("Provide some setting here");
	}

	@Override
	public void updateDataModel() {
		//todo update model according to UI
	}
}