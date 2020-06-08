package com.nonnulldinu.clionmeson.buildsystem.meta

import com.google.gson.annotations.SerializedName

data class MesonBuildMetaIntrospectionInformation(
        @SerializedName("benchmarks") val benchmarks: MesonBuildFileUpdatedPair,
        @SerializedName("buildoptions") val buildoptions: MesonBuildFileUpdatedPair,
        @SerializedName("buildsystem_files") val buildSystemFiles: MesonBuildFileUpdatedPair,
        @SerializedName("dependencies")val dependencies: MesonBuildFileUpdatedPair,
        @SerializedName("installed") val installed: MesonBuildFileUpdatedPair,
        @SerializedName("projectinfo") val projectInfo: MesonBuildFileUpdatedPair,
        @SerializedName("targets") val targets: MesonBuildFileUpdatedPair,
        @SerializedName("tests") val tests: MesonBuildFileUpdatedPair
)
