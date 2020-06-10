package com.nonnulldinu.clionmeson.buildsystem.target

import com.google.gson.annotations.SerializedName

data class MesonBuildTarget(
        @SerializedName("name") val name: String,
        @SerializedName("id") val id: String,
        @SerializedName("type") val type: String,
        @SerializedName("defined_in") val defined_in: String,
        @SerializedName("filename") val filename: Array<String>,
        @SerializedName("build_by_default") val buildByDefault: Boolean,
        @SerializedName("target_sources") val targetSources: Array<MesonBuildSourceCompilationDetails>,
        @SerializedName("subproject") val subproject: MesonBuildSubproject,
        @SerializedName("installed") val installed: Boolean
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MesonBuildTarget

        if (name != other.name) return false
        if (id != other.id) return false
        if (type != other.type) return false
        if (defined_in != other.defined_in) return false
        if (!filename.contentEquals(other.filename)) return false
        if (buildByDefault != other.buildByDefault) return false
        if (!targetSources.contentEquals(other.targetSources)) return false
        if (subproject != other.subproject) return false
        if (installed != other.installed) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + defined_in.hashCode()
        result = 31 * result + filename.contentHashCode()
        result = 31 * result + buildByDefault.hashCode()
        result = 31 * result + targetSources.hashCode()
        result = 31 * result + subproject.hashCode()
        result = 31 * result + installed.hashCode()
        return result
    }

    override fun toString(): String {
        return "$name($id)"
    }
}
