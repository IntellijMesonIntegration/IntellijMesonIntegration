package com.nonnulldinu.clionmeson.buildsystem.meta

import com.google.gson.annotations.SerializedName

data class MesonBuildMeta(
        @SerializedName("meson_version") val mesonVersion: MesonBuildVersion,
        @SerializedName("directories") val directories: MesonBuildMetaDirs,
        @SerializedName("introspection") val introspection: MesonBuildMetaIntrospection,
        @SerializedName("build_files_updated") val buildFilesUpdated: Boolean,
        @SerializedName("error") val error: Boolean
) {

}