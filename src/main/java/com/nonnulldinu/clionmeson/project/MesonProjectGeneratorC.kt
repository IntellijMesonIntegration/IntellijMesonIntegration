package com.nonnulldinu.clionmeson.project

import com.intellij.ide.util.projectWizard.AbstractNewProjectStep
import com.intellij.openapi.module.Module
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Ref
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.wm.impl.welcomeScreen.AbstractActionWithPanel
import com.intellij.platform.DirectoryProjectGenerator
import com.intellij.platform.GeneratorPeerImpl
import com.intellij.platform.ProjectGeneratorPeer
import com.nonnulldinu.clionmeson.module.MesonProjectSettingsStepC
import javax.swing.JPanel

class MesonProjectGeneratorC : MesonBasedProjectGenerator() {
    override fun createStep(projectGenerator: DirectoryProjectGenerator<Ref<Array<String?>?>?>, callback: AbstractNewProjectStep.AbstractCallback<Ref<Array<String?>?>?>): AbstractActionWithPanel {
        return MesonProjectSettingsStepC(projectGenerator, callback)
    }

    override fun getName(): String {
        return "C"
    }

    override fun getDescription(): String? {
        return "Meson-based C project"
    }

    override fun createPeer(): ProjectGeneratorPeer<Ref<Array<String?>?>?> {
        return GeneratorPeerImpl(Ref<Array<String?>?>(null), JPanel())
    }

    override fun generateProject(project: Project, baseDir: VirtualFile, settings: Ref<Array<String?>?>, module: Module) {
        doGenerateProject(project, baseDir)
    }

    private fun doGenerateProject(project: Project,
                                  baseDir: VirtualFile) {
//        val projRoot : String? = project.basePath
//        val mesonBuildFile : String = projRoot!! + "/meson.build"
//        val f = File(mesonBuildFile)
//        f.createNewFile()
//        val fs = FileOutputStream(f)
//        fs.write()
    } //	private void finishFileStructure(@NotNull Project project,
    //	                                 @NotNull VirtualFile baseDir, boolean generateMain) {
    //		baseDir.refresh(false, true);
    //		if (generateMain) {
    //			VirtualFile srcFolder = baseDir.findChild("src");
    //			if (srcFolder == null || !srcFolder.isDirectory()) {
    //				showError(ClionEmbeddedPlatformioBundle.message("src.not.found"));
    //				return;
    //			}
    //			if (srcFolder.findChild("main.cpp") == null) {
    //				try {
    //					VirtualFile mainC = srcFolder.findOrCreateChildData(this, "main.c");
    //					if (mainC.getLength() == 0) {
    //						mainC.setBinaryContent(ClionEmbeddedPlatformioBundle.message("write.your.code.here").getBytes(StandardCharsets.US_ASCII));
    //					}
    //				}
    //				catch (IOException e) {
    //					showError(ExceptionUtil.getThrowableText(e));
    //					return;
    //				}
    //			}
    //		}
    //		updateCMakeProjectInformation(project, baseDir);
    //	}
    //	public static void updateCMakeProjectInformation(@NotNull Project project, @NotNull VirtualFile baseDir) {
    //		if (project.isInitialized()) {
    //			CMakeWorkspace cmakeWorkspace = CMakeWorkspace.getInstance(project);
    //			MessageBusConnection busConnection = project.getMessageBus().connect();
    //			busConnection.subscribe(CMakeWorkspaceListener.TOPIC, new CMakeWorkspaceListener() {
    //
    //				@Override
    //				public void reloadingFinished(boolean canceled) {
    //					busConnection.disconnect();
    //					if (!canceled && project.isInitialized()) {
    //						//Phase 4
    //						configureBuildTypes(cmakeWorkspace);
    //						configureRunConfigurations(project);
    //					}
    //				}
    //			});
    //			ApplicationManager.getApplication().invokeLaterOnWriteThread(
    //					() -> cmakeWorkspace.selectProjectDir(VfsUtilCore.virtualToIoFile(baseDir)) //Phase 3 started
    //			);
    //		}
    //	}
    //	private static void configureRunConfigurations(@NotNull Project project) {
    //		RunManager runManager = RunManager.getInstance(project);
    //
    //		final CMakeBuildConfigurationHelper helper = CMakeRunConfigurationType.getHelper(project);
    //
    //		ConfigurationFactory[] factories =
    //				ConfigurationTypeUtil.findConfigurationType(PlatformioConfigurationType.class).getNewProjectFactories();
    //		for (int i = 0; i < factories.length; i++) {
    //			ConfigurationFactory factory = factories[i];
    //			String name = factory.getName();
    //			if (runManager.findConfigurationByName(name) == null) {
    //				RunnerAndConfigurationSettings runSettings = runManager.createConfiguration(name, factory);
    //
    //				PlatformioBaseConfiguration configuration = (PlatformioBaseConfiguration)runSettings.getConfiguration();
    //				CMakeTarget target = helper.findFirstSuitableTarget(configuration.getCmakeBuildTarget());
    //				if (target != null) {
    //					final BuildTargetData buildTargetData = new BuildTargetData(project.getName(), target.getName());
    //					final BuildTargetAndConfigurationData data = new BuildTargetAndConfigurationData(buildTargetData, null);
    //					configuration.setTargetAndConfigurationData(data);
    //					configuration.setExecutableData(new ExecutableData(buildTargetData));
    //					runManager.addConfiguration(runSettings);
    //					if (i == 0) {
    //						runManager.setSelectedConfiguration(runSettings);
    //					}
    //				}
    //			}
    //		}
    //	}
    //	private static void configureBuildTypes(@NotNull CMakeWorkspace cmakeWorkspace) {
    //		CMakeSettings settings = cmakeWorkspace.getSettings();
    //		List<CMakeModelConfigurationData> cMakeModelConfigurationData = cmakeWorkspace.getModelConfigurationData();
    //		if (!cMakeModelConfigurationData.isEmpty()) {
    //			List<String> buildTypes = cMakeModelConfigurationData.get(0).getRegisteredBuildTypes();
    //			settings.setProfiles(ContainerUtil.map(buildTypes, CMakeSettings.Profile::new));
    //		}
    //	}
    //	private static void showError(@NotNull String message) {
    //		Notification notification = PlatformioService.NOTIFICATION_GROUP.createNotification(
    //				ClionEmbeddedPlatformioBundle.message("project.init.failed"), null,
    //				message, NotificationType.WARNING);
    //		Notifications.Bus.notify(notification);
    //	}
}