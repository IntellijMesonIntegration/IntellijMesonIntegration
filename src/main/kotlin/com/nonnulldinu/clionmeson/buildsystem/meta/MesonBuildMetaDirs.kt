package com.nonnulldinu.clionmeson.buildsystem.meta

import com.google.gson.annotations.SerializedName

data class MesonBuildMetaDirs(
        @SerializedName("source") val source: String,
        @SerializedName("build") val build : String,
        @SerializedName("info") val info : String
) {

}
