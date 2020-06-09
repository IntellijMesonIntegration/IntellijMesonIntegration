package com.nonnulldinu.clionmeson.buildsystem.meta

import com.google.gson.annotations.SerializedName

data class MesonBuildMetaIntrospection(
        @SerializedName("version") val version: MesonBuildVersion,
        @SerializedName("information") val information: MesonBuildMetaIntrospectionInformation
) {

}
