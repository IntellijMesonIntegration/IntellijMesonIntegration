package com.nonnulldinu.clionmeson.languages.lexers

import com.intellij.lexer.FlexAdapter
import java.io.Reader

class MesonBuildLexerAdapter : FlexAdapter(_MesonBuildLexer(null as Reader?)) 