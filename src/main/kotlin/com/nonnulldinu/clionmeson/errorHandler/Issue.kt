package com.nonnulldinu.clionmeson.errorHandler

import com.google.gson.annotations.SerializedName


/**
 * An issue that we can send to the bot to report
 */
data class Issue(@SerializedName("issue-title") val title: String, @SerializedName("issue-body") val body: String)