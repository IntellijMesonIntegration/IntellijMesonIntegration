package com.nonnulldinu.clionmeson.errorHandler

import com.intellij.ide.DataManager
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.diagnostic.ErrorReportSubmitter
import com.intellij.openapi.diagnostic.IdeaLoggingEvent
import com.intellij.openapi.diagnostic.SubmittedReportInfo
import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.progress.Task.Backgroundable
import com.intellij.openapi.ui.Messages
import java.awt.Component
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandlers
import java.time.Duration


class ErrorSubmitter : ErrorReportSubmitter() {
    /*
	 * Changes the text on the report button
	 */
    override fun getReportActionText(): String {
        return "Report to Author"
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
        val context = DataManager.getInstance().getDataContext(parentComponent)
        val project = CommonDataKeys.PROJECT.getData(context)
        object : Backgroundable(project, "Sending Error Report") {
            override fun run(indicator: ProgressIndicator) {
                val client = HttpClient.newHttpClient()
                val request = HttpRequest.newBuilder()
                        .uri(URI.create("https://clionmesonintegration.herokuapp.com/"))
                        .timeout(Duration.ofSeconds(10))
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString("{\"issue-title\":\"test issue from heroku\", \"issue-body\":\"test issue from heroku\"}"))
                        .build()
                client.sendAsync(request, BodyHandlers.ofString())
                        .thenApply { obj: HttpResponse<String?> -> obj.body() }
                        .thenAccept { x: String? -> println(x) }
                        .join()

                // show thank you message after report submitted
                ApplicationManager.getApplication().invokeLater {
                    Messages.showInfoMessage(parentComponent, "Thank you for submitting your report!", "Error Report")
                    consumer.consume(SubmittedReportInfo(SubmittedReportInfo.SubmissionStatus.NEW_ISSUE))
                }
            }
        }.queue()
        return true
    }
}