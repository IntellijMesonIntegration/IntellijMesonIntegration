package com.nonnulldinu.clionmeson.errorHandler

import com.google.gson.annotations.SerializedName


/**
 * An issue that we can send to the bot to report
 */
data class Issue(@SerializedName("issue-title") val title: String, @SerializedName("issue-body") val body: String, @SerializedName("issue-labels") val label: Array<String>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Issue

        if (title != other.title) return false
        if (body != other.body) return false
        if (!label.contentEquals(other.label)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + body.hashCode()
        result = 31 * result + label.contentHashCode()
        return result
    }
}