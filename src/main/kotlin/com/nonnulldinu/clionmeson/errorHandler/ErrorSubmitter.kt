package com.nonnulldinu.clionmeson.errorHandler;

import com.intellij.diagnostic.AbstractMessage;
import com.intellij.diagnostic.IdeaReportingEvent;
import com.intellij.ide.DataManager;
import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.idea.IdeaLogger;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.diagnostic.ErrorReportSubmitter;
import com.intellij.openapi.diagnostic.IdeaLoggingEvent;
import com.intellij.openapi.diagnostic.SubmittedReportInfo;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.util.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayDeque;
import java.util.Deque;

public class ErrorSubmitter extends ErrorReportSubmitter {
	/*
	 * Changes the text on the report button
	 */
	@NotNull
	@Override
	public String getReportActionText() {
		return "Report to Author";
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
	@Override
	public boolean submit(@NotNull IdeaLoggingEvent[] events, @Nullable String additionalInfo, @NotNull Component parentComponent, @NotNull Consumer<SubmittedReportInfo> consumer) {
		DataContext context = DataManager.getInstance().getDataContext(parentComponent);
		Project project = CommonDataKeys.PROJECT.getData(context);

		new Task.Backgroundable(project, "Sending Error Report") {
			@Override
			public void run(@NotNull ProgressIndicator indicator) {
				HttpClient client = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder()
						.uri(URI.create("https://clionmesonintegration.herokuapp.com/"))
						.timeout(Duration.ofMinutes(1))
						.header("Content-Type", "application/json")
						.POST(HttpRequest.BodyPublishers.ofString("{\"issue-title\":\"test issue from heroku\", \"issue-body\":\"test issue from heroku\"}"))
						.build();
				client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
						.thenApply(HttpResponse::body)
						.thenAccept(System.out::println)
						.join();


/*
				EventBuilder event = new EventBuilder();
				event.withLevel(Event.Level.ERROR);
				if (getPluginDescriptor() instanceof IdeaPluginDescriptor) {
					event.withRelease(((IdeaPluginDescriptor) getPluginDescriptor()).getVersion());
				}
				// set server name to empty to avoid tracking personal data
				event.withServerName("");

				// now, attach all exceptions to the message
				Deque<SentryException> errors = new ArrayDeque<>(events.length);
				for (IdeaLoggingEvent ideaEvent : events) {
					// this is the tricky part
					// ideaEvent.throwable is a com.intellij.diagnostic.IdeaReportingEvent.TextBasedThrowable
					// This is a wrapper and is only providing the original stack trace via 'printStackTrace(...)',
					// but not via 'getStackTrace()'.
					//
					// Sentry accesses Throwable.getStackTrace(),
					// So, we workaround this by retrieving the original exception from the data property
					if (ideaEvent instanceof IdeaReportingEvent && ideaEvent.getData() instanceof AbstractMessage) {
						Throwable ex = ((AbstractMessage) ideaEvent.getData()).getThrowable();
						errors.add(new SentryException(ex, ex.getStackTrace()));
					} else {
						// ignoring this ideaEvent, you might not want to do this
					}
				}
				event.withSentryInterface(new ExceptionInterface(errors));
				// might be useful to debug the exception
				event.withExtra("last_action", IdeaLogger.ourLastActionId);

				// by default, Sentry is sending async in a background thread
				SentryClient sentry = SentryDemo.getSentryClient();
				sentry.sendEvent(event);*/

				ApplicationManager.getApplication().invokeLater(() -> {
					// we're a bit lazy here.
					// Alternatively, we could add a listener to the sentry client
					// to be notified if the message was successfully send
					Messages.showInfoMessage(parentComponent, "Thank you for submitting your report!", "Error Report");
					consumer.consume(new SubmittedReportInfo(SubmittedReportInfo.SubmissionStatus.NEW_ISSUE));
				});
			}
		}.queue();
		return true;
	}
}
