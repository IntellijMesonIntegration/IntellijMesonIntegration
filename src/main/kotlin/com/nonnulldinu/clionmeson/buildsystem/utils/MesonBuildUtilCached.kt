package com.nonnulldinu.clionmeson.buildsystem.utils

import java.io.File

class MesonBuildUtilCached<T>(var file: File, var value: T?) {
    var lastReload: Long = 0

    fun shouldReload(): Boolean = value == null || file.lastModified() > lastReload
    fun reload(_newReload : Long) {
        lastReload = _newReload
    }
}
