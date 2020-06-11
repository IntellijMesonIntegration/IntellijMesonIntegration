package com.nonnulldinu.clionmeson.errorHandler

import com.google.gson.Gson
import com.intellij.CommonBundle
import com.intellij.ide.DataManager
import com.intellij.ide.plugins.PluginManager
import com.intellij.idea.IdeaLogger
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.ApplicationNamesInfo
import com.intellij.openapi.application.ex.ApplicationInfoEx
import com.intellij.openapi.diagnostic.Attachment
import com.intellij.openapi.diagnostic.ErrorReportSubmitter
import com.intellij.openapi.diagnostic.IdeaLoggingEvent
import com.intellij.openapi.diagnostic.SubmittedReportInfo
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.Task.Backgroundable
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.util.SystemInfo
import org.jetbrains.annotations.NonNls
import org.jetbrains.annotations.PropertyKey
import java.awt.Component
import java.io.PrintWriter
import java.io.StringWriter
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandlers
import java.time.Duration
import java.util.*


class ErrorSubmitter : ErrorReportSubmitter() {
    /*
     * Changes the text on the report button
     */
    override fun getReportActionText(): String {
        return ErrorReportBundle.message("report.error.to.plugin.vendor")
    }

    /**
     * The boolean return value tells the IDE if the report can be send at all.
     * If you can’t send the report, then return false and you’re done.
     * Otherwise, return true and send the report asynchronously — that’s important.
     * @param events This is the list of exceptions, which should be send. The list of events to process. IntelliJ seems to always send just one event.
     * @param additionalInfo This is an optional message by the user.
     * @param parentComponent This might be useful if you want to show UI, e.g. a message box. Ignore this if you’re not interacting with the user.
     * @param consumer The callback. Call consumer.consume(…) when the report has been send successfully or failed to send. The argument to this method specifies the type of result.
     * @return boolean
     */
    override fun submit(events: Array<IdeaLoggingEvent>, additionalInfo: String?, parentComponent: Component, consumer: com.intellij.util.Consumer<SubmittedReportInfo>): Boolean {
        val event = events.firstOrNull { it.throwable != null } ?: return false // nothing to report if null
        val context = DataManager.getInstance().getDataContext(parentComponent)
        val project = CommonDataKeys.PROJECT.getData(context)
        val bean = GitHubErrorBean(event.throwable, IdeaLogger.ourLastActionId, additionalInfo ?: "<No description>", event.message ?: event.throwable.message.toString())
        val reportValues = getKeyValuePairs(project, bean, ApplicationInfoEx.getInstanceEx(), ApplicationNamesInfo.getInstance())
        val title = event.message ?: event.throwable.javaClass.name + (
                        if (event.throwable.message != null)
                            ("(" + event.throwable.message + ")")
                        else ""
                        ) + " in " + event.throwable.stackTrace[0].className + ":" + event.throwable.stackTrace[0].lineNumber
        val body = event.throwableText
        println(title)
//        println("a")
//        println(body)


        object : Backgroundable(project, ErrorReportBundle.message("report.error.progress.dialog.text")) {
            override fun run(indicator: ProgressIndicator) {
                val client = HttpClient.newHttpClient()
                val request = HttpRequest.newBuilder()
                        .uri(URI.create("https://clionmesonintegration.herokuapp.com/"))
                        .timeout(Duration.ofSeconds(10))
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(createNewGitHubIssue(reportValues)))
                        .build()

//                println(createNewGitHubIssue(reportValues))
                val response = client.send(request, BodyHandlers.ofString())
                println(response.statusCode())
                println(response.body())

                // show thank you message after report submitted
                ApplicationManager.getApplication().invokeLater {
                    Messages.showInfoMessage(parentComponent, "Thank you for submitting your report!", "Error Report")
                    consumer.consume(SubmittedReportInfo(SubmittedReportInfo.SubmissionStatus.NEW_ISSUE))
                }
            }
        }.queue()
        return true
    }

    /**
     * Builds a string that contains the post request such as:
     * {
        "issue-title": "test issue title",
        "issue-body": "test issue body",
        "issue-labels": ["test-issue"]
        }
     */
    private fun createNewGitHubIssue(details: MutableMap<String, String>) : String {
        return Gson().toJson(Issue(generateGitHubIssueTitle(details), generateGitHubIssueBody(details, true), generateGitHubIssueLabel()))
    }

    private fun generateGitHubIssueTitle(details: MutableMap<String, String>) : String {
        val errorMessage = details.remove("error.message")?.takeIf(String::isNotBlank) ?: "Unspecified error"
        return ErrorReportBundle.message("git.issue.title", details.remove("error.hash").orEmpty(), errorMessage)
    }

    private fun generateGitHubIssueBody(details: MutableMap<String, String>, includeStacktrace: Boolean) =
            buildString {
                val errorDescription = details.remove("error.description").orEmpty()
                val stackTrace = details.remove("error.stacktrace")?.takeIf(String::isNotBlank) ?: "invalid stacktrace"
                if (errorDescription.isNotEmpty()) append(errorDescription).append("\n\n----------------------\n")
                for ((key, value) in details) append("- ").append(key).append(": ").appendln(value)
                if (includeStacktrace)
                    appendln("<details><summary>Full StackTrace</summary>")
                            .appendln("<pre><code>")
                            .appendln(stackTrace)
                            .appendln("</code></pre>\n</details>")
            }

    private fun generateGitHubIssueLabel() : Array<String> {
        return arrayOf("test-issue")
    }
}

/**
 * Extends the standard class to provide the hash of the thrown exception stack trace.
 */
class GitHubErrorBean(throwable: Throwable, val lastAction: String?, val description: String, val message: String) {
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
 * Collects information about the running IDEA and the error
 */
private fun getKeyValuePairs(project: Project?, error: GitHubErrorBean, appInfo: ApplicationInfoEx, namesInfo: ApplicationNamesInfo): MutableMap<String, String> {
    PluginManager.getPlugin(PluginId.findId("com.non.null.dinu.MesonIntegration"))?.run {
        if (error.pluginName.isBlank()) error.pluginName = getName()
        if (error.pluginVersion.isBlank()) error.pluginVersion = getVersion()
    }
    val params = mutableMapOf(
            "error.description" to error.description,
            "Meson Version" to (project?.run { "meson --version" } ?: "Unknown"),
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

/**
 * Messages and strings used by the error reporter
 * Source: https://github.com/JuliaEditorSupport/julia-intellij/blob/master/src/org/ice1000/julia/lang/error/error-report.kt
 */
private object ErrorReportBundle {
    @NonNls
    private const val BUNDLE = "properties.report-bundle"
    private val bundle: ResourceBundle by lazy { ResourceBundle.getBundle(BUNDLE) }

    @JvmStatic
    internal fun message(@PropertyKey(resourceBundle = BUNDLE) key: String, vararg params: Any) =
            CommonBundle.message(bundle, key, *params)
}