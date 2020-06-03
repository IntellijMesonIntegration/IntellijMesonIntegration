package com.nonnulldinu.clionmeson.build.language.highlighting;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.nonnulldinu.clionmeson.build.psi.MesonBuildTypes;
import com.nonnulldinu.clionmeson.languages.lexers.MesonBuildLexerAdapter;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class MesonBuildSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey OPERATOR =
            createTextAttributesKey("MESON_BUILD_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("MESON_BUILD_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey STR_VALUE =
            createTextAttributesKey("MESON_BUILD_STR_VALUE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUM_VALUE =
            createTextAttributesKey("MESON_BUILD_NUM_VALUE", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey LINE_COMMENT =
            createTextAttributesKey("MESON_BUILD_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BLOCK_COMMENT =
            createTextAttributesKey("MESON_BUILD_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("MESON_BUILD_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);


    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] OPERATOR_KEYS = new TextAttributesKey[]{OPERATOR};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] STR_VALUE_KEYS = new TextAttributesKey[]{STR_VALUE};
    private static final TextAttributesKey[] NUM_VALUE_KEYS = new TextAttributesKey[]{NUM_VALUE};
    private static final TextAttributesKey[] LINE_COMMENT_KEYS = new TextAttributesKey[]{LINE_COMMENT};
    private static final TextAttributesKey[] BLOCK_COMMENT_KEYS = new TextAttributesKey[]{BLOCK_COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new MesonBuildLexerAdapter();
    }

    /**
     * Returns the list of text attribute keys used for highlighting the specified token type. The attributes of all attribute keys
     * returned for the token type are successively merged to obtain the color and attributes of the token.
     *
     * @param tokenType The token type for which the highlighting is requested.
     * @return The array of text attribute keys.
     */
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(MesonBuildTypes.PLUS_OP)
                || tokenType.equals(MesonBuildTypes.MINUS_OP) || tokenType.equals(MesonBuildTypes.MULT_OP)
                || tokenType.equals(MesonBuildTypes.DIV_OP) || tokenType.equals(MesonBuildTypes.MOD_OP)
                || tokenType.equals(MesonBuildTypes.COMP_ATR_OP1) || tokenType.equals(MesonBuildTypes.COMP_ATR_OP2)
                || tokenType.equals(MesonBuildTypes.COMP_ATR_OP3) || tokenType.equals(MesonBuildTypes.COMP_ATR_OP4)
                || tokenType.equals(MesonBuildTypes.COMP_ATR_OP5) || tokenType.equals(MesonBuildTypes.ATR_OP)
                || tokenType.equals(MesonBuildTypes.BRACE_BEGIN) || tokenType.equals(MesonBuildTypes.BRACE_END)
                || tokenType.equals(MesonBuildTypes.CURLY_BRACE_BEGIN) || tokenType.equals(MesonBuildTypes.CURLY_BRACE_END)
                || tokenType.equals(MesonBuildTypes.PAREN_BEGIN) || tokenType.equals(MesonBuildTypes.PAREN_END)
                || tokenType.equals(MesonBuildTypes.COMMA)
                || tokenType.equals(MesonBuildTypes.COMP_OP1) || tokenType.equals(MesonBuildTypes.COMP_OP2)
                || tokenType.equals(MesonBuildTypes.COMP_OP3) || tokenType.equals(MesonBuildTypes.COMP_OP4)
                || tokenType.equals(MesonBuildTypes.COMP_OP5) || tokenType.equals(MesonBuildTypes.COMP_OP6)

                || tokenType.equals(MesonBuildTypes.LANG_TOKEN_QMARK) || tokenType.equals(MesonBuildTypes.LANG_TOKEN_COLON)
                || tokenType.equals(MesonBuildTypes.LANG_TOKEN_DOT)
        ) {
            return OPERATOR_KEYS;
        } else if (
            // conditional
                tokenType.equals(MesonBuildTypes.IN_OP) || tokenType.equals(MesonBuildTypes.LANG_TOKEN_AND)
                        || tokenType.equals(MesonBuildTypes.LANG_TOKEN_OR) || tokenType.equals(MesonBuildTypes.LANG_TOKEN_NOT)
                        /// if
                        || tokenType.equals(MesonBuildTypes.LANG_TOKEN_IF) || tokenType.equals(MesonBuildTypes.LANG_TOKEN_ELSE_IF)
                        || tokenType.equals(MesonBuildTypes.LANG_TOKEN_ELSE) || tokenType.equals(MesonBuildTypes.LANG_TOKEN_ENDIF)

                        /// for
                        || tokenType.equals(MesonBuildTypes.LANG_TOKEN_FOREACH) || tokenType.equals(MesonBuildTypes.LANG_TOKEN_FOREACH_END)
                        || tokenType.equals(MesonBuildTypes.LANG_TOKEN_JUMP_CONTINUE) || tokenType.equals(MesonBuildTypes.LANG_TOKEN_JUMP_BREAK)
        ) {
            return KEYWORD_KEYS;
        } else if (tokenType.equals(MesonBuildTypes.BOOL_LITERAL_FALSE) || tokenType.equals(MesonBuildTypes.BOOL_LITERAL_TRUE)
                || tokenType.equals(MesonBuildTypes.STRSIMPLE) /*|| tokenType.equals(MesonBuildTypes.STRMULTILINE)*/
        ) {
            return STR_VALUE_KEYS;
        } else if (tokenType.equals(MesonBuildTypes.BINNUM) || tokenType.equals(MesonBuildTypes.OCTNUM)
                || tokenType.equals(MesonBuildTypes.DECNUM) || tokenType.equals(MesonBuildTypes.HEXNUM)) {
            return NUM_VALUE_KEYS;
        } else if (tokenType.equals(MesonBuildTypes.SINGLE_LINE_COMMENT)) {
            return LINE_COMMENT_KEYS;
        } else if (tokenType.equals(MesonBuildTypes.MULTILINE_COMMENT)) {
            return BLOCK_COMMENT_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}