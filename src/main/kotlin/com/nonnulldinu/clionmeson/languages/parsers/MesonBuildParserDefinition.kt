package com.nonnulldinu.clionmeson.languages.parsers

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.ParserDefinition.SpaceRequirements
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import com.nonnulldinu.clionmeson.build.psi.MesonBuildTypes
import com.nonnulldinu.clionmeson.languages.MesonBuildLang
import com.nonnulldinu.clionmeson.languages.lexers.MesonBuildLexerAdapter

class MesonBuildParserDefinition : ParserDefinition {
    override fun createLexer(project: Project): Lexer {
        return MesonBuildLexerAdapter()
    }

    override fun getWhitespaceTokens(): TokenSet {
        return WHITE_SPACES
    }

    override fun getCommentTokens(): TokenSet {
        return COMMENTS
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    /**
     * Creates a PSI element for the specified virtual file.
     *
     * @param viewProvider virtual file.
     * @return the PSI file element.
     */
    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return MesonBuildFile(viewProvider)
    }

    override fun createParser(project: Project): PsiParser {
        return MesonBuildParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): SpaceRequirements {
        return SpaceRequirements.MAY
    }

    override fun createElement(node: ASTNode): PsiElement {
        return MesonBuildTypes.Factory.createElement(node)
    }

    companion object {
        val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
        val COMMENTS = TokenSet.create(MesonBuildTypes.LINE_COMMENT, MesonBuildTypes.BLOCK_COMMENT)
        val FILE = IFileElementType(MesonBuildLang)
    }
}