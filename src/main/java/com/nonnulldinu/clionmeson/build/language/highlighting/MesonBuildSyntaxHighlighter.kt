package com.nonnulldinu.clionmeson.build.language.highlighting

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.nonnulldinu.clionmeson.build.psi.MesonBuildTypes
import com.nonnulldinu.clionmeson.languages.lexers.MesonBuildLexerAdapter

class MesonBuildSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return MesonBuildLexerAdapter()
    }

    /**
     * Returns the list of text attribute keys used for highlighting the specified token type. The attributes of all attribute keys
     * returned for the token type are successively merged to obtain the color and attributes of the token.
     *
     * @param tokenType The token type for which the highlighting is requested.
     * @return The array of text attribute keys.
     */
    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return if (tokenType == MesonBuildTypes.Companion.PLUS_OP || tokenType == MesonBuildTypes.Companion.MINUS_OP || tokenType == MesonBuildTypes.Companion.MULT_OP || tokenType == MesonBuildTypes.Companion.DIV_OP || tokenType == MesonBuildTypes.Companion.MOD_OP || tokenType == MesonBuildTypes.Companion.COMP_ATR_OP1 || tokenType == MesonBuildTypes.Companion.COMP_ATR_OP2 || tokenType == MesonBuildTypes.Companion.COMP_ATR_OP3 || tokenType == MesonBuildTypes.Companion.COMP_ATR_OP4 || tokenType == MesonBuildTypes.Companion.COMP_ATR_OP5 || tokenType == MesonBuildTypes.Companion.ATR_OP || tokenType == MesonBuildTypes.Companion.BRACE_BEGIN || tokenType == MesonBuildTypes.Companion.BRACE_END || tokenType == MesonBuildTypes.Companion.CURLY_BRACE_BEGIN || tokenType == MesonBuildTypes.Companion.CURLY_BRACE_END || tokenType == MesonBuildTypes.Companion.PAREN_BEGIN || tokenType == MesonBuildTypes.Companion.PAREN_END || tokenType == MesonBuildTypes.Companion.COMMA || tokenType == MesonBuildTypes.Companion.COMP_OP1 || tokenType == MesonBuildTypes.Companion.COMP_OP2 || tokenType == MesonBuildTypes.Companion.COMP_OP3 || tokenType == MesonBuildTypes.Companion.COMP_OP4 || tokenType == MesonBuildTypes.Companion.COMP_OP5 || tokenType == MesonBuildTypes.Companion.COMP_OP6 || tokenType == MesonBuildTypes.Companion.LANG_TOKEN_QMARK || tokenType == MesonBuildTypes.Companion.LANG_TOKEN_COLON || tokenType == MesonBuildTypes.Companion.LANG_TOKEN_DOT) {
            OPERATOR_KEYS
        } else if ( // conditional
                tokenType == MesonBuildTypes.Companion.IN_OP || tokenType == MesonBuildTypes.Companion.LANG_TOKEN_AND || tokenType == MesonBuildTypes.Companion.LANG_TOKEN_OR || tokenType == MesonBuildTypes.Companion.LANG_TOKEN_NOT || tokenType == MesonBuildTypes.Companion.LANG_TOKEN_IF || tokenType == MesonBuildTypes.Companion.LANG_TOKEN_ELSE_IF || tokenType == MesonBuildTypes.Companion.LANG_TOKEN_ELSE || tokenType == MesonBuildTypes.Companion.LANG_TOKEN_ENDIF || tokenType == MesonBuildTypes.Companion.LANG_TOKEN_FOREACH || tokenType == MesonBuildTypes.Companion.LANG_TOKEN_FOREACH_END || tokenType == MesonBuildTypes.Companion.LANG_TOKEN_JUMP_CONTINUE || tokenType == MesonBuildTypes.Companion.LANG_TOKEN_JUMP_BREAK) {
            KEYWORD_KEYS
        } else if (tokenType == MesonBuildTypes.Companion.STRSIMPLE || tokenType == MesonBuildTypes.Companion.STRMULTILINE) {
            STR_VALUE_KEYS
        } else if (tokenType == MesonBuildTypes.Companion.BOOL_LITERAL_FALSE || tokenType == MesonBuildTypes.Companion.BOOL_LITERAL_TRUE || tokenType == MesonBuildTypes.Companion.BINNUM || tokenType == MesonBuildTypes.Companion.OCTNUM || tokenType == MesonBuildTypes.Companion.DECNUM || tokenType == MesonBuildTypes.Companion.HEXNUM) {
            NUM_VALUE_KEYS
        } else if (tokenType == MesonBuildTypes.Companion.LINE_COMMENT) {
            LINE_COMMENT_KEYS
        } else if (tokenType == MesonBuildTypes.Companion.BLOCK_COMMENT) {
            BLOCK_COMMENT_KEYS
        } else if (tokenType == TokenType.BAD_CHARACTER) {
            BAD_CHAR_KEYS
        } else {
            EMPTY_KEYS
        }
    }

    companion object {
        val OPERATOR = TextAttributesKey.createTextAttributesKey("MESON_BUILD_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        val KEYWORD = TextAttributesKey.createTextAttributesKey("MESON_BUILD_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
        val STR_VALUE = TextAttributesKey.createTextAttributesKey("MESON_BUILD_STR_VALUE", DefaultLanguageHighlighterColors.STRING)
        val NUM_VALUE = TextAttributesKey.createTextAttributesKey("MESON_BUILD_NUM_VALUE", DefaultLanguageHighlighterColors.NUMBER)
        val LINE_COMMENT = TextAttributesKey.createTextAttributesKey("MESON_BUILD_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val BLOCK_COMMENT = TextAttributesKey.createTextAttributesKey("MESON_BUILD_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT)
        val BAD_CHARACTER = TextAttributesKey.createTextAttributesKey("MESON_BUILD_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val OPERATOR_KEYS = arrayOf(OPERATOR)
        private val KEYWORD_KEYS = arrayOf(KEYWORD)
        private val STR_VALUE_KEYS = arrayOf(STR_VALUE)
        private val NUM_VALUE_KEYS = arrayOf(NUM_VALUE)
        private val LINE_COMMENT_KEYS = arrayOf(LINE_COMMENT)
        private val BLOCK_COMMENT_KEYS = arrayOf(BLOCK_COMMENT)
        private val EMPTY_KEYS = arrayOfNulls<TextAttributesKey>(0)
    }
}