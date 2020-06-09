package com.nonnulldinu.clionmeson.buildsystem.target

import com.google.gson.annotations.SerializedName

data class MesonBuildTargets (val targets: Array<MesonBuildTarget>){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MesonBuildTargets

        if (!targets.contentEquals(other.targets)) return false

        return true
    }

    override fun hashCode(): Int {
        return targets.contentHashCode()
    }
}