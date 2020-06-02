package com.nonnulldinu.clionmeson.languages.lexers;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class MesonBuildLexerAdapter extends FlexAdapter {
    public MesonBuildLexerAdapter() {
        super(new _MesonBuildLexer((Reader) null));
    }
}
