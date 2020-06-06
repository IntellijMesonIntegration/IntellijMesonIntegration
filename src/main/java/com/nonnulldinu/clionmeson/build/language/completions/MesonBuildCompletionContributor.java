package com.nonnulldinu.clionmeson.build.language.completions;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import com.nonnulldinu.clionmeson.languages.MesonBuildLang;
import org.jetbrains.annotations.NotNull;

public class MesonBuildCompletionContributor extends CompletionContributor {
    public MesonBuildCompletionContributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement().withLanguage(MesonBuildLang.INSTANCE),
                new CompletionProvider<>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("continue"));
                        resultSet.addElement(LookupElementBuilder.create("break"));
                    }
                }
        );
    }
}
