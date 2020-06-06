package com.nonnulldinu.clionmeson.languages.parsers

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.nonnulldinu.clionmeson.filetypes.MesonBuildFileType
import com.nonnulldinu.clionmeson.languages.MesonBuildLang

class MesonBuildFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, MesonBuildLang) {
    /**
     * Returns the file type for the file.
     *
     * @return the file type instance.
     */
    override fun getFileType(): FileType {
        return MesonBuildFileType.Companion.INSTANCE
    }
}