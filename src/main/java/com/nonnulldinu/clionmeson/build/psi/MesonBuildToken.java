package com.nonnulldinu.clionmeson.build.psi;

import com.intellij.psi.tree.IElementType;
import com.nonnulldinu.clionmeson.languages.MesonBuildLang;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class MesonBuildToken extends IElementType {
    /**
     * Creates and registers a new element type for the specified language.
     */
    public MesonBuildToken(@NotNull @NonNls String debugName) {
        super(debugName, MesonBuildLang.INSTANCE);
    }

    @Override
    public String toString() {
        return "MesonBuildToken:\"" + super.toString() + "\"";
    }

}
