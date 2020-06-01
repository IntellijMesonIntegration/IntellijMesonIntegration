package com.nonnulldinu.clionmeson.languages;

import com.intellij.lang.Language;

public class MesonBuildLang extends Language {
    public static final MesonBuildLang INSTANCE = new MesonBuildLang();
    protected MesonBuildLang() {
        super("MesonBuildLang");
    }
}
