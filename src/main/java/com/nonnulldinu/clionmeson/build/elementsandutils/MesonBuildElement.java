package com.nonnulldinu.clionmeson.build.elementsandutils;

import com.intellij.psi.tree.IElementType;
import com.nonnulldinu.clionmeson.languages.MesonBuildLang;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class MesonBuildElement extends IElementType {

    public MesonBuildElement( @NotNull @NonNls String debugName) {
        super(debugName, MesonBuildLang.INSTANCE);
    }
}
