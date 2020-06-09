package com.nonnulldinu.clionmeson.buildsystem.meta

import com.google.gson.annotations.SerializedName

data class MesonBuildFileUpdatedPair(
        @SerializedName("file") val file: String,
        @SerializedName("updated") val updated: Boolean
) {

}
