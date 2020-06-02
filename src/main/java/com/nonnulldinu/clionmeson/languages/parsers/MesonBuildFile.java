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

    /**
     * @return text range of this element relative to its parent
     */
//    @Override
//    public @NotNull TextRange getTextRangeInParent() {
//        return null;
//    }

    /**
     * The returned references are expected to be used by language support,
     * for example in Java `foo` element in `foo = 42` expression has a reference,
     * which is used by Java language support to compute expected type of the assignment.
     * <p>
     * On the other hand {@code "bar"} literal in {@code new File("bar")} is a string literal,
     * and from Java language perspective it has no references,
     * but the framework support "knows" that this literal contains the reference to a file.
     * These are external references.
     *
     * @return collection of references from this element, or empty collection if there are no such references
     * @see PsiExternalReferenceHost
     * @see PsiSymbolReferenceService#getReferences(PsiElement)
     */
//    @Override
//    public @NotNull Iterable<? extends PsiSymbolReference> getOwnReferences() {
//        return null;
//    }
}
