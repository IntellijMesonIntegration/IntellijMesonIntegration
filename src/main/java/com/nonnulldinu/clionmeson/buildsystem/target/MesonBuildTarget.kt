package com.nonnulldinu.clionmeson.buildsystem.target

import com.nonnulldinu.clionmeson.buildsystem.commons.MesonBuildFileArray

class MesonBuildTarget(
        name: String,
        id: String,
        type: String,
        defined_in: String,
        filename: MesonBuildFileArray,
        buildByDefault: Boolean,
        targetSources: MesonBuildSourceCompilationDetails
) {
}
