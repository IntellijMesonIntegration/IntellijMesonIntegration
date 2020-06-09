package com.nonnulldinu.clionmeson.filetypes

import com.intellij.openapi.fileTypes.LanguageFileType
import com.nonnulldinu.clionmeson.icons.PluginIcons
import com.nonnulldinu.clionmeson.languages.MesonBuildLang
import org.jetbrains.annotations.Nls
import javax.swing.Icon

class MesonBuildFileType private constructor() : LanguageFileType(MesonBuildLang) {
    /**
     * Returns the name of the file type. The name must be unique among all file types registered in the system.
     *
     * @return The file type name.
     */
    override fun getName(): String {
        return "Meson Build"
    }

    override fun isReadOnly(): Boolean {
        return false
    }

    /**
     * Returns the user-readable description of the file type.
     *
     * @return The file type description.
     */
    override fun getDescription(): @Nls(capitalization = Nls.Capitalization.Sentence) String {
        return "Meson meson.build file"
    }

    /**
     * Returns the default extension for files of the type.
     *
     * @return The extension, *not* including the leading '.'.
     */
    override fun getDefaultExtension(): String {
        return EXTENSION
    }

    /**
     * Returns the icon used for showing files of the type.
     *
     * @return The icon instance, or `null` if no icon should be shown.
     */
    override fun getIcon(): Icon? {
        return PluginIcons.MESON_BUILD_ICON
    }

    companion object {
        val INSTANCE = MesonBuildFileType()
        const val EXTENSION = "build"
    }
}