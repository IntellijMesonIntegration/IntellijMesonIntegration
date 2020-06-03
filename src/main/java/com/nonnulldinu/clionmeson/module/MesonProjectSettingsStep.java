package com.nonnulldinu.clionmeson.module;

import com.intellij.ide.util.projectWizard.AbstractNewProjectStep;
import com.intellij.ide.util.projectWizard.ProjectSettingsStepBase;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.openapi.util.Ref;
import com.intellij.platform.DirectoryProjectGenerator;
import com.intellij.util.ui.JBUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MesonProjectSettingsStep extends ProjectSettingsStepBase<Ref<String[]>> {

	public MesonProjectSettingsStep(DirectoryProjectGenerator<Ref<String[]>> projectGenerator, AbstractNewProjectStep.AbstractCallback<Ref<String[]>> callback) {
		super(projectGenerator, callback);
	}

	@Override
	protected JPanel createAdvancedSettings() {
		final JPanel jPanel = new JPanel(new GridBagLayout());
		jPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		// language label and combobox
		final JLabel languageLabel = new JLabel("Language:");
		ComboBox languageCombobox = new ComboBox<>(new String[] {"C", "C++", "Rust", "Java"});
		languageCombobox.setSelectedItem("C++");

		jPanel.add(languageLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, JBUI.emptyInsets(), 0, 0));
		jPanel.add(languageCombobox, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, JBUI.emptyInsets(), 0, 0));

		// standard label and combobox
		final JLabel standardLabel = new JLabel("Language standard:");
		ComboBox standardCombobox = new ComboBox<>();

		jPanel.add(standardLabel, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, JBUI.emptyInsets(), 0, 0));
		jPanel.add(standardCombobox, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, JBUI.emptyInsets(), 0, 0));

		// create the spacer to push the items to the top left corner
		jPanel.add(Box.createGlue(), new GridBagConstraints(2, 2, 1, 2, 1, 1, GridBagConstraints.CENTER, 0, JBUI.emptyInsets(), 0, 0));

		// listeners
		languageCombobox.addActionListener (new ActionListener() { // see: https://stackoverflow.com/questions/58939/jcombobox-selection-change-listener
			public void actionPerformed(ActionEvent e) {
				DefaultComboBoxModel model;
				switch(languageCombobox.getSelectedIndex()) {
					case 0:
						model = new DefaultComboBoxModel(new String[] {"C90", "C99", "C11"});
						break;
					case 1:
						model = new DefaultComboBoxModel(new String[] {"C++98", "C++11", "C++14", "C++17", "C++20"});
						break;
					case 2:
						model = new DefaultComboBoxModel(new String[] {"Rust v1.38.0"});
						break;
					case 3:
						model = new DefaultComboBoxModel(new String[] {"Java 8", "Java 11", "Java 14"});
						break;
					default:
						model = new DefaultComboBoxModel();
				}
				standardCombobox.setModel(model);
				standardCombobox.setSelectedIndex(standardCombobox.getModel().getSize() - 1);
			}
		});

		// emit the signal update the standardCombobox and select the last standard
		languageCombobox.actionPerformed(null);
		standardCombobox.setSelectedIndex(standardCombobox.getModel().getSize() - 1);

		return jPanel;
	}
}
