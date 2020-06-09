package com.nonnulldinu.clionmeson.errorHandler

import com.intellij.CommonBundle
import com.intellij.diagnostic.*
import com.intellij.ide.DataManager
import com.intellij.ide.plugins.PluginManager
import com.intellij.idea.IdeaLogger
import com.intellij.notification.NotificationListener
import com.intellij.notification.NotificationType
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.application.ApplicationNamesInfo
import com.intellij.openapi.application.ex.ApplicationInfoEx
import com.intellij.openapi.diagnostic.*
import com.intellij.openapi.diagnostic.SubmittedReportInfo.SubmissionStatus
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.progress.*
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.SystemInfo
import com.intellij.util.Consumer
import org.apache.commons.codec.binary.Base64
//import org.eclipse.egit.github.core.*
//import org.eclipse.egit.github.core.client.GitHubClient
//import org.eclipse.egit.github.core.service.IssueService
//import org.ice1000.julia.lang.module.juliaSettings
import org.jetbrains.annotations.NonNls
import org.jetbrains.annotations.PropertyKey
import java.awt.Component
import java.io.*
import java.net.URL
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class GitHubErrorReporter : ErrorReportSubmitter() {
    override fun getReportActionText() = "report.error.to.plugin.vendor"
    override fun submit(events: Array<IdeaLoggingEvent>, info: String?, parent: Component, consumer: Consumer<SubmittedReportInfo>): Boolean {
        // TODO improve
        val event = events.firstOrNull { it.throwable != null } ?: return false
        return doSubmit(event, parent, consumer, info)
    }

    private fun doSubmit(event: IdeaLoggingEvent, parent: Component, callback: Consumer<SubmittedReportInfo>, description: String?): Boolean {
        val dataContext = DataManager.getInstance().getDataContext(parent)
        val bean = GitHubErrorBean(event.throwable, IdeaLogger.ourLastActionId, description ?: "<No description>", event.message ?: event.throwable.message.toString())
        IdeErrorsDialog.findPluginId(event.throwable)?.let { pluginId ->
            PluginManager.getPlugin(pluginId)?.let { ideaPluginDescriptor ->
                if (!ideaPluginDescriptor.isBundled) {
                    bean.pluginName = ideaPluginDescriptor.name
                    bean.pluginVersion = ideaPluginDescriptor.version
                }
            }
        }

        (event.data as? AbstractMessage)?.let { bean.attachments = it.includedAttachments }
        val project = CommonDataKeys.PROJECT.getData(dataContext)
        val reportValues = getKeyValuePairs(
                project,
                bean,
                ApplicationInfoEx.getInstanceEx(),
                ApplicationNamesInfo.getInstance())
        val notifyingCallback = CallbackWithNotification(callback, project)
        val task = AnonymousFeedbackTask(project,"report.error.progress.dialog.text", true, reportValues, notifyingCallback)
        if (project == null) task.run(EmptyProgressIndicator()) else ProgressManager.getInstance().run(task)
        return true
    }

    internal class CallbackWithNotification(
            private val consumer: Consumer<SubmittedReportInfo>,
            private val project: Project?) : Consumer<SubmittedReportInfo> {
        override fun consume(reportInfo: SubmittedReportInfo) {
            consumer.consume(reportInfo)
            if (reportInfo.status == SubmissionStatus.FAILED) ReportMessages.GROUP.createNotification(ReportMessages.ERROR_REPORT,
                    reportInfo.linkText, NotificationType.ERROR, null).setImportant(false).notify(project)
            else ReportMessages.GROUP.createNotification(ReportMessages.ERROR_REPORT, reportInfo.linkText,
                    NotificationType.INFORMATION, NotificationListener.URL_OPENING_LISTENER).setImportant(false).notify(project)
        }
    }
}

/**
 * Extends the standard class to provide the hash of the thrown exception stack trace.
 *
 * @author patrick (17.06.17).
 */
class GitHubErrorBean(
        throwable: Throwable,
        val lastAction: String?,
        val description: String,
        val message: String) {
    val exceptionHash: String
    val stackTrace: String
    init {
        val trace = throwable.stackTrace
        exceptionHash = Arrays.hashCode(trace).toString()
        val sw = StringWriter()
        throwable.printStackTrace(PrintWriter(sw))
        stackTrace = sw.toString()
    }

    var pluginName = ""
    var pluginVersion = ""
    var attachments: List<Attachment> = emptyList()
}

/**
 * Messages and strings used by the error reporter
 */
//private object ErrorReportBundle {
//    @NonNls private const val BUNDLE = "org.ice1000.julia.lang.error-report.report-bundle"
//    private val bundle: ResourceBundle by lazy { ResourceBundle.getBundle(BUNDLE) }
//
//    @JvmStatic
//    internal fun message(@PropertyKey(resourceBundle = BUNDLE) key: String, vararg params: Any) =
//            CommonBundle.message(bundle, key, *params)
//}

private class AnonymousFeedbackTask(
        project: Project?, title: String, canBeCancelled: Boolean,
        private val params: MutableMap<String, String>,
        private val callback: Consumer<SubmittedReportInfo>) : Task.Backgroundable(project, title, canBeCancelled) {
    override fun run(indicator: ProgressIndicator) {
        indicator.isIndeterminate = true
        callback.consume(AnonymousFeedback.sendFeedback(params))
    }
}

/**
 * Collects information about the running IDEA and the error
 */
private fun getKeyValuePairs(project: Project?, error: GitHubErrorBean, appInfo: ApplicationInfoEx, namesInfo: ApplicationNamesInfo): MutableMap<String, String> {
    PluginManager.getPlugin(PluginId.findId("org.ice1000.julia"))?.run {
        if (error.pluginName.isBlank()) error.pluginName = name
        if (error.pluginVersion.isBlank()) error.pluginVersion = version
    }
    val params = mutableMapOf(
            "error.description" to error.description,
            "Julia Version" to (project?.run { "juliaSettings.settings.version" } ?: "Unknown"),
            "Plugin Name" to error.pluginName,
            "Plugin Version" to error.pluginVersion,
            "OS Name" to SystemInfo.OS_NAME,
            "Java Version" to SystemInfo.JAVA_VERSION,
            "App Name" to namesInfo.productName,
            "App Full Name" to namesInfo.fullProductName,
            "App Version name" to appInfo.versionName,
            "Is EAP" to java.lang.Boolean.toString(appInfo.isEAP),
            "App Build" to appInfo.build.asString(),
            "App Version" to appInfo.fullVersion,
            "Last Action" to (error.lastAction ?: "Unknown"),
            "error.message" to error.message,
            "error.stacktrace" to error.stackTrace,
            "error.hash" to error.exceptionHash)
    for (attachment in error.attachments) params["Attachment ${attachment.name}"] = attachment.encodedBytes
    return params
}
