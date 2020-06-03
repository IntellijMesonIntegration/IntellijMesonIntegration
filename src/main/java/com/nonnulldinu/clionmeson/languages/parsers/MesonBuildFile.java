package com.nonnulldinu.clionmeson.languages.parsers;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.model.psi.PsiExternalReferenceHost;
import com.intellij.model.psi.PsiSymbolReference;
import com.intellij.model.psi.PsiSymbolReferenceService;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.FileViewProvider;
import com.nonnulldinu.clionmeson.filetypes.MesonBuildFileType;
import com.nonnulldinu.clionmeson.languages.MesonBuildLang;
import org.jetbrains.annotations.NotNull;

public class MesonBuildFile extends PsiFileBase {
    protected MesonBuildFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, MesonBuildLang.INSTANCE);
    }

    /**
     * Returns the file type for the file.
     *
     * @return the file type instance.
     */
    @Override
    public @NotNull FileType getFileType() {
        return MesonBuildFileType.INSTANCE;
    }
}
