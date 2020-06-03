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
import com.intellij.util.ui.components.BorderLayoutPanel;
//import com.jetbrains.cidr.cpp.embedded.platformio.ClionEmbeddedPlatformioBundle;
//import com.jetbrains.cidr.cpp.embedded.platformio.PlatformioBaseConfiguration;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class MesonWizardStep extends ProjectSettingsStepBase<Ref<String[]>> {
	public MesonWizardStep(DirectoryProjectGenerator<Ref<String[]>> projectGenerator, AbstractNewProjectStep.AbstractCallback<Ref<String[]>> callback) {
		super(projectGenerator, callback);
	}
}