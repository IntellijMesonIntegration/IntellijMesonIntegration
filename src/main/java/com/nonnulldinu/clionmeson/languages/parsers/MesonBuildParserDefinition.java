package com.nonnulldinu.clionmeson.languages.parsers;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.nonnulldinu.clionmeson.build.psi.MesonBuildTypes;
import com.nonnulldinu.clionmeson.languages.MesonBuildLang;
import com.nonnulldinu.clionmeson.languages.lexers.MesonBuildLexerAdapter;
import org.jetbrains.annotations.NotNull;

public class MesonBuildParserDefinition  implements ParserDefinition {
    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(MesonBuildTypes.LINE_COMMENT, MesonBuildTypes.BLOCK_COMMENT);

    public static final IFileElementType FILE = new IFileElementType(MesonBuildLang.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new MesonBuildLexerAdapter();
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    /**
     * Creates a PSI element for the specified virtual file.
     *
     * @param viewProvider virtual file.
     * @return the PSI file element.
     */
    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new MesonBuildFile(viewProvider);
    }

    @NotNull
    @Override
    public PsiParser createParser(final Project project) {
        return new MesonBuildParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override
    public SpaceRequirements spaceExistenceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return MesonBuildTypes.Factory.createElement(node);
    }
}
