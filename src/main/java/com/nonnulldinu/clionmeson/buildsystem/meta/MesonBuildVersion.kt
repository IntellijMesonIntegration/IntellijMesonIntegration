package com.nonnulldinu.clionmeson.buildsystem.meta

import com.google.gson.annotations.SerializedName

data class MesonBuildVersion(
        @SerializedName("full") val full: String,
        @SerializedName("major") val major: Int,
        @SerializedName("minor") val minor: Int,
        @SerializedName("patch") val patch: Int
)
