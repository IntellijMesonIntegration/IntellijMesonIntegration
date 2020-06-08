package com.nonnulldinu.clionmeson.buildsystem.target

import com.google.gson.annotations.SerializedName

data class MesonBuildSourceCompilationDetails(
        @SerializedName("language") val language: String,
        @SerializedName("compiler") val compiler: Array<String>,
        @SerializedName("parameters") val parameters: Array<String>,
        @SerializedName("sources") val sources: Array<String>,
        @SerializedName("generated_sources") val generatedSources: Array<String>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MesonBuildSourceCompilationDetails

        if (language != other.language) return false
        if (!compiler.contentEquals(other.compiler)) return false
        if (!parameters.contentEquals(other.parameters)) return false
        if (!sources.contentEquals(other.sources)) return false
        if (!generatedSources.contentEquals(other.generatedSources)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = language.hashCode()
        result = 31 * result + compiler.contentHashCode()
        result = 31 * result + parameters.contentHashCode()
        result = 31 * result + sources.contentHashCode()
        result = 31 * result + generatedSources.contentHashCode()
        return result
    }
}
