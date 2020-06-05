package com.nonnulldinu.clionmeson.filetypes;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.nonnulldinu.clionmeson.icons.PluginIcons;
import com.nonnulldinu.clionmeson.languages.MesonBuildLang;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class MesonBuildFileType extends LanguageFileType {
    public static final MesonBuildFileType INSTANCE = new MesonBuildFileType();
    public static final String EXTENSION = "build";
    public static final String FILE_NAME = "meson.build";

    protected MesonBuildFileType() {
        super(MesonBuildLang.INSTANCE);
    }

    /**
     * Returns the name of the file type. The name must be unique among all file types registered in the system.
     *
     * @return The file type name.
     */
    @Override
    @NotNull
    public String getName() {
        return "Meson Build";
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    /**
     * Returns the user-readable description of the file type.
     *
     * @return The file type description.
     */
    @Override
    @NotNull
    @Nls(capitalization = Nls.Capitalization.Sentence)
    public String getDescription() {
        return "Meson meson.build file";
    }

    /**
     * Returns the default extension for files of the type.
     *
     * @return The extension, <em>not</em> including the leading '.'.
     */
    @Override
    @NotNull
    public String getDefaultExtension() {
        return EXTENSION;
    }

    /**
     * Returns the icon used for showing files of the type.
     *
     * @return The icon instance, or {@code null} if no icon should be shown.
     */
    @Override
    @Nullable
    public Icon getIcon() {
        return PluginIcons.MESON_BUILD_ICON;
    }
}
