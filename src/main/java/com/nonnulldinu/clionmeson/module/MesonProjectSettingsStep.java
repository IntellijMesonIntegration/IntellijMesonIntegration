package com.nonnulldinu.clionmeson.module;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.CapturingProcessHandler;
import com.intellij.execution.process.CapturingProcessRunner;
import com.intellij.execution.process.ProcessOutput;
import com.intellij.ide.util.projectWizard.AbstractNewProjectStep;
import com.intellij.ide.util.projectWizard.ProjectSettingsStepBase;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.openapi.ui.VerticalFlowLayout;
import com.intellij.openapi.util.Ref;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.platform.DirectoryProjectGenerator;
import com.intellij.ui.ColoredTreeCellRenderer;
import com.intellij.ui.SimpleTextAttributes;
import com.intellij.ui.TreeSpeedSearch;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.treeStructure.Tree;
import com.intellij.util.ArrayUtil;
import com.intellij.util.ExceptionUtil;
import com.intellij.util.ui.JBUI;
import com.intellij.util.ui.components.BorderLayoutPanel;
//import com.jetbrains.cidr.cpp.embedded.platformio.ClionEmbeddedPlatformioBundle;
//import com.jetbrains.cidr.cpp.embedded.platformio.PlatformioBaseConfiguration;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MesonProjectSettingsStep extends ProjectSettingsStepBase<Ref<String[]>> {
//	private final ComboBox language;
//	private final ComboBox standard;

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
		ComboBox standardCombobox = new ComboBox<>(new String[] {"C11", "C14", "C17"});
		standardCombobox.setSelectedItem("C17");

		jPanel.add(standardLabel, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, JBUI.emptyInsets(), 0, 0));
		jPanel.add(standardCombobox, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, JBUI.emptyInsets(), 0, 0));

		// create the spacer to push the items to the top left corner
		jPanel.add(Box.createGlue(), new GridBagConstraints(2, 2, 1, 2, 1, 1, GridBagConstraints.CENTER, 0, JBUI.emptyInsets(), 0, 0));

		return jPanel;
	}

//	// todo: maybe remove?
//	@Override
//	public boolean checkValid() {
//		if (!super.checkValid()) return false;
//		Ref<String[]> settings = getPeer().getSettings();
//		if (settings.isNull() || settings.get().length == 0) {
//			setWarningText("Please select target");
//			return false;
//		}
//		else {
//			setErrorText(null);
//			return true;
//		}
//	}
}
