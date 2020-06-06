// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.nonnulldinu.clionmeson.build.elementsandutils.MesonBuildElement
import com.nonnulldinu.clionmeson.build.elementsandutils.MesonBuildToken
import com.nonnulldinu.clionmeson.build.psi.impl.*

interface MesonBuildTypes {
    object Factory {
        fun createElement(node: ASTNode): PsiElement {
            val type = node.elementType
            if (type === ADD_EXPR) {
                return MesonBuildAddExprImpl(node)
            } else if (type === ARRAY_LITERAL) {
                return MesonBuildArrayLiteralImpl(node)
            } else if (type === ASSIGNMENT_STATEMENT) {
                return MesonBuildAssignmentStatementImpl(node)
            } else if (type === ATOM) {
                return MesonBuildAtomImpl(node)
            } else if (type === ATROP) {
                return MesonBuildAtropImpl(node)
            } else if (type === CONDITIONAL_AND_EXPRESSION) {
                return MesonBuildConditionalAndExpressionImpl(node)
            } else if (type === CONDITIONAL_OR_EXPRESSION) {
                return MesonBuildConditionalOrExpressionImpl(node)
            } else if (type === CONTROL_STATEMENT) {
                return MesonBuildControlStatementImpl(node)
            } else if (type === DICT_LITERAL) {
                return MesonBuildDictLiteralImpl(node)
            } else if (type === FOR_STATEMENT) {
                return MesonBuildForStatementImpl(node)
            } else if (type === FOR_STATEMENT_LIST) {
                return MesonBuildForStatementListImpl(node)
            } else if (type === FULL_EXPRESSION) {
                return MesonBuildFullExpressionImpl(node)
            } else if (type === FUNC_ARG) {
                return MesonBuildFuncArgImpl(node)
            } else if (type === FUNC_ARGS) {
                return MesonBuildFuncArgsImpl(node)
            } else if (type === FUNC_CALL_EXPRESSION) {
                return MesonBuildFuncCallExpressionImpl(node)
            } else if (type === FUNC_CALL_STATEMENT) {
                return MesonBuildFuncCallStatementImpl(node)
            } else if (type === FUNC_NAME) {
                return MesonBuildFuncNameImpl(node)
            } else if (type === ID_EXPRESSION) {
                return MesonBuildIdExpressionImpl(node)
            } else if (type === ID_LIST) {
                return MesonBuildIdListImpl(node)
            } else if (type === KEYWORD_ELEM) {
                return MesonBuildKeywordElemImpl(node)
            } else if (type === METHOD_CALL_EXPRESSION_BASE) {
                return MesonBuildMethodCallExpressionBaseImpl(node)
            } else if (type === METHOD_CALL_STATEMENT) {
                return MesonBuildMethodCallStatementImpl(node)
            } else if (type === MUL_EXPR) {
                return MesonBuildMulExprImpl(node)
            } else if (type === MUL_OP) {
                return MesonBuildMulOpImpl(node)
            } else if (type === NUM_LITERAL_UNARY) {
                return MesonBuildNumLiteralUnaryImpl(node)
            } else if (type === POSITIONAL_FUNC_ARG) {
                return MesonBuildPositionalFuncArgImpl(node)
            } else if (type === RELATION_CHECK) {
                return MesonBuildRelationCheckImpl(node)
            } else if (type === RELATION_CHECK_OP) {
                return MesonBuildRelationCheckOpImpl(node)
            } else if (type === REPETITIVE_STATEMENT) {
                return MesonBuildRepetitiveStatementImpl(node)
            } else if (type === SELECTION_STATEMENT) {
                return MesonBuildSelectionStatementImpl(node)
            } else if (type === SELECTION_STATEMENT_FOR) {
                return MesonBuildSelectionStatementForImpl(node)
            } else if (type === STATEMENT) {
                return MesonBuildStatementImpl(node)
            } else if (type === STATEMENT_LIST) {
                return MesonBuildStatementListImpl(node)
            } else if (type === SUBSCRIPT_METHOD_CHAIN_EXPR) {
                return MesonBuildSubscriptMethodChainExprImpl(node)
            } else if (type === TERNARY_EXPRESSION) {
                return MesonBuildTernaryExpressionImpl(node)
            }
            throw AssertionError("Unknown element type: $type")
        }
    }

    companion object {
        val ADD_EXPR: IElementType = MesonBuildElement("ADD_EXPR")
        val ARRAY_LITERAL: IElementType = MesonBuildElement("ARRAY_LITERAL")
        val ASSIGNMENT_STATEMENT: IElementType = MesonBuildElement("ASSIGNMENT_STATEMENT")
        val ATOM: IElementType = MesonBuildElement("ATOM")
        val ATROP: IElementType = MesonBuildElement("ATROP")
        val CONDITIONAL_AND_EXPRESSION: IElementType = MesonBuildElement("CONDITIONAL_AND_EXPRESSION")
        val CONDITIONAL_OR_EXPRESSION: IElementType = MesonBuildElement("CONDITIONAL_OR_EXPRESSION")
        val CONTROL_STATEMENT: IElementType = MesonBuildElement("CONTROL_STATEMENT")
        val DICT_LITERAL: IElementType = MesonBuildElement("DICT_LITERAL")
        val FOR_STATEMENT: IElementType = MesonBuildElement("FOR_STATEMENT")
        val FOR_STATEMENT_LIST: IElementType = MesonBuildElement("FOR_STATEMENT_LIST")
        val FULL_EXPRESSION: IElementType = MesonBuildElement("FULL_EXPRESSION")
        val FUNC_ARG: IElementType = MesonBuildElement("FUNC_ARG")
        val FUNC_ARGS: IElementType = MesonBuildElement("FUNC_ARGS")
        val FUNC_CALL_EXPRESSION: IElementType = MesonBuildElement("FUNC_CALL_EXPRESSION")
        val FUNC_CALL_STATEMENT: IElementType = MesonBuildElement("FUNC_CALL_STATEMENT")
        val FUNC_NAME: IElementType = MesonBuildElement("FUNC_NAME")
        val ID_EXPRESSION: IElementType = MesonBuildElement("ID_EXPRESSION")
        val ID_LIST: IElementType = MesonBuildElement("ID_LIST")
        val KEYWORD_ELEM: IElementType = MesonBuildElement("KEYWORD_ELEM")
        val METHOD_CALL_EXPRESSION_BASE: IElementType = MesonBuildElement("METHOD_CALL_EXPRESSION_BASE")
        val METHOD_CALL_STATEMENT: IElementType = MesonBuildElement("METHOD_CALL_STATEMENT")
        val MUL_EXPR: IElementType = MesonBuildElement("MUL_EXPR")
        val MUL_OP: IElementType = MesonBuildElement("MUL_OP")
        val NUM_LITERAL_UNARY: IElementType = MesonBuildElement("NUM_LITERAL_UNARY")
        val POSITIONAL_FUNC_ARG: IElementType = MesonBuildElement("POSITIONAL_FUNC_ARG")
        val RELATION_CHECK: IElementType = MesonBuildElement("RELATION_CHECK")
        val RELATION_CHECK_OP: IElementType = MesonBuildElement("RELATION_CHECK_OP")
        val REPETITIVE_STATEMENT: IElementType = MesonBuildElement("REPETITIVE_STATEMENT")
        val SELECTION_STATEMENT: IElementType = MesonBuildElement("SELECTION_STATEMENT")
        val SELECTION_STATEMENT_FOR: IElementType = MesonBuildElement("SELECTION_STATEMENT_FOR")
        val STATEMENT: IElementType = MesonBuildElement("STATEMENT")
        val STATEMENT_LIST: IElementType = MesonBuildElement("STATEMENT_LIST")
        val SUBSCRIPT_METHOD_CHAIN_EXPR: IElementType = MesonBuildElement("SUBSCRIPT_METHOD_CHAIN_EXPR")
        val TERNARY_EXPRESSION: IElementType = MesonBuildElement("TERNARY_EXPRESSION")
        val ATR_OP: IElementType = MesonBuildToken("=")
        val BINNUM: IElementType = MesonBuildToken("binnum")
        val BLOCK_COMMENT: IElementType = MesonBuildToken("block_comment")
        val BOOL_LITERAL_FALSE: IElementType = MesonBuildToken("false")
        val BOOL_LITERAL_TRUE: IElementType = MesonBuildToken("true")
        val BRACE_BEGIN: IElementType = MesonBuildToken("[")
        val BRACE_END: IElementType = MesonBuildToken("]")
        val COMMA: IElementType = MesonBuildToken(",")
        val COMP_ATR_OP1: IElementType = MesonBuildToken("*=")
        val COMP_ATR_OP2: IElementType = MesonBuildToken("/=")
        val COMP_ATR_OP3: IElementType = MesonBuildToken("%=")
        val COMP_ATR_OP4: IElementType = MesonBuildToken("+=")
        val COMP_ATR_OP5: IElementType = MesonBuildToken("-=")
        val COMP_OP1: IElementType = MesonBuildToken("==")
        val COMP_OP2: IElementType = MesonBuildToken("<=")
        val COMP_OP3: IElementType = MesonBuildToken(">=")
        val COMP_OP4: IElementType = MesonBuildToken("<")
        val COMP_OP5: IElementType = MesonBuildToken(">")
        val COMP_OP6: IElementType = MesonBuildToken("!=")
        val CURLY_BRACE_BEGIN: IElementType = MesonBuildToken("{")
        val CURLY_BRACE_END: IElementType = MesonBuildToken("}")
        val DECNUM: IElementType = MesonBuildToken("decnum")
        val DIV_OP: IElementType = MesonBuildToken("/")
        val HEXNUM: IElementType = MesonBuildToken("hexnum")
        val ID: IElementType = MesonBuildToken("id")
        val IN_OP: IElementType = MesonBuildToken("in")
        val LANG_TOKEN_AND: IElementType = MesonBuildToken("and")
        val LANG_TOKEN_COLON: IElementType = MesonBuildToken(":")
        val LANG_TOKEN_DOT: IElementType = MesonBuildToken(".")
        val LANG_TOKEN_ELSE: IElementType = MesonBuildToken("else")
        val LANG_TOKEN_ELSE_IF: IElementType = MesonBuildToken("elif")
        val LANG_TOKEN_ENDIF: IElementType = MesonBuildToken("endif")
        val LANG_TOKEN_FOREACH: IElementType = MesonBuildToken("foreach")
        val LANG_TOKEN_FOREACH_END: IElementType = MesonBuildToken("endforeach")
        val LANG_TOKEN_IF: IElementType = MesonBuildToken("if")
        val LANG_TOKEN_JUMP_BREAK: IElementType = MesonBuildToken("break")
        val LANG_TOKEN_JUMP_CONTINUE: IElementType = MesonBuildToken("continue")
        val LANG_TOKEN_NOT: IElementType = MesonBuildToken("not")
        val LANG_TOKEN_OR: IElementType = MesonBuildToken("or")
        val LANG_TOKEN_QMARK: IElementType = MesonBuildToken("?")
        val LINE_COMMENT: IElementType = MesonBuildToken("line_comment")
        val MINUS_OP: IElementType = MesonBuildToken("-")
        val MOD_OP: IElementType = MesonBuildToken("%")
        val MULT_OP: IElementType = MesonBuildToken("*")
        val NEWLINE: IElementType = MesonBuildToken("newline")
        val OCTNUM: IElementType = MesonBuildToken("octnum")
        val PAREN_BEGIN: IElementType = MesonBuildToken("(")
        val PAREN_END: IElementType = MesonBuildToken(")")
        val PLUS_OP: IElementType = MesonBuildToken("+")
        val STRMULTILINE: IElementType = MesonBuildToken("strmultiline")
        val STRSIMPLE: IElementType = MesonBuildToken("strsimple")
    }
}