// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.nonnulldinu.clionmeson.build.elementsandutils.MesonBuildElement;
import com.nonnulldinu.clionmeson.build.elementsandutils.MesonBuildToken;
import com.nonnulldinu.clionmeson.build.psi.impl.*;

public interface MesonBuildTypes {

  IElementType ADD_EXPR = new MesonBuildElement("ADD_EXPR");
  IElementType ARRAY_LITERAL = new MesonBuildElement("ARRAY_LITERAL");
  IElementType ASSIGNMENT_STATEMENT = new MesonBuildElement("ASSIGNMENT_STATEMENT");
  IElementType ATOM = new MesonBuildElement("ATOM");
  IElementType ATROP = new MesonBuildElement("ATROP");
  IElementType CONDITIONAL_AND_EXPRESSION = new MesonBuildElement("CONDITIONAL_AND_EXPRESSION");
  IElementType CONDITIONAL_OR_EXPRESSION = new MesonBuildElement("CONDITIONAL_OR_EXPRESSION");
  IElementType CONTROL_STATEMENT = new MesonBuildElement("CONTROL_STATEMENT");
  IElementType DICT_LITERAL = new MesonBuildElement("DICT_LITERAL");
  IElementType FOR_STATEMENT = new MesonBuildElement("FOR_STATEMENT");
  IElementType FOR_STATEMENT_LIST = new MesonBuildElement("FOR_STATEMENT_LIST");
  IElementType FULL_EXPRESSION = new MesonBuildElement("FULL_EXPRESSION");
  IElementType FUNC_ARG = new MesonBuildElement("FUNC_ARG");
  IElementType FUNC_ARGS = new MesonBuildElement("FUNC_ARGS");
  IElementType FUNC_CALL_EXPRESSION = new MesonBuildElement("FUNC_CALL_EXPRESSION");
  IElementType FUNC_CALL_STATEMENT = new MesonBuildElement("FUNC_CALL_STATEMENT");
  IElementType FUNC_NAME = new MesonBuildElement("FUNC_NAME");
  IElementType ID_EXPRESSION = new MesonBuildElement("ID_EXPRESSION");
  IElementType ID_LIST = new MesonBuildElement("ID_LIST");
  IElementType KEYWORD_ELEM = new MesonBuildElement("KEYWORD_ELEM");
  IElementType METHOD_CALL_EXPRESSION_BASE = new MesonBuildElement("METHOD_CALL_EXPRESSION_BASE");
  IElementType METHOD_CALL_STATEMENT = new MesonBuildElement("METHOD_CALL_STATEMENT");
  IElementType MUL_EXPR = new MesonBuildElement("MUL_EXPR");
  IElementType MUL_OP = new MesonBuildElement("MUL_OP");
  IElementType NUM_LITERAL_UNARY = new MesonBuildElement("NUM_LITERAL_UNARY");
  IElementType POSITIONAL_FUNC_ARG = new MesonBuildElement("POSITIONAL_FUNC_ARG");
  IElementType RELATION_CHECK = new MesonBuildElement("RELATION_CHECK");
  IElementType RELATION_CHECK_OP = new MesonBuildElement("RELATION_CHECK_OP");
  IElementType REPETITIVE_STATEMENT = new MesonBuildElement("REPETITIVE_STATEMENT");
  IElementType SELECTION_STATEMENT = new MesonBuildElement("SELECTION_STATEMENT");
  IElementType SELECTION_STATEMENT_FOR = new MesonBuildElement("SELECTION_STATEMENT_FOR");
  IElementType STATEMENT = new MesonBuildElement("STATEMENT");
  IElementType STATEMENT_LIST = new MesonBuildElement("STATEMENT_LIST");
  IElementType SUBSCRIPT_METHOD_CHAIN_EXPR = new MesonBuildElement("SUBSCRIPT_METHOD_CHAIN_EXPR");
  IElementType TERNARY_EXPRESSION = new MesonBuildElement("TERNARY_EXPRESSION");

  IElementType ATR_OP = new MesonBuildToken("=");
  IElementType BINNUM = new MesonBuildToken("binnum");
  IElementType BLOCK_COMMENT = new MesonBuildToken("block_comment");
  IElementType BOOL_LITERAL_FALSE = new MesonBuildToken("false");
  IElementType BOOL_LITERAL_TRUE = new MesonBuildToken("true");
  IElementType BRACE_BEGIN = new MesonBuildToken("[");
  IElementType BRACE_END = new MesonBuildToken("]");
  IElementType COMMA = new MesonBuildToken(",");
  IElementType COMP_ATR_OP1 = new MesonBuildToken("*=");
  IElementType COMP_ATR_OP2 = new MesonBuildToken("/=");
  IElementType COMP_ATR_OP3 = new MesonBuildToken("%=");
  IElementType COMP_ATR_OP4 = new MesonBuildToken("+=");
  IElementType COMP_ATR_OP5 = new MesonBuildToken("-=");
  IElementType COMP_OP1 = new MesonBuildToken("==");
  IElementType COMP_OP2 = new MesonBuildToken("<=");
  IElementType COMP_OP3 = new MesonBuildToken(">=");
  IElementType COMP_OP4 = new MesonBuildToken("<");
  IElementType COMP_OP5 = new MesonBuildToken(">");
  IElementType COMP_OP6 = new MesonBuildToken("!=");
  IElementType CURLY_BRACE_BEGIN = new MesonBuildToken("{");
  IElementType CURLY_BRACE_END = new MesonBuildToken("}");
  IElementType DECNUM = new MesonBuildToken("decnum");
  IElementType DIV_OP = new MesonBuildToken("/");
  IElementType HEXNUM = new MesonBuildToken("hexnum");
  IElementType ID = new MesonBuildToken("id");
  IElementType IN_OP = new MesonBuildToken("in");
  IElementType LANG_TOKEN_AND = new MesonBuildToken("and");
  IElementType LANG_TOKEN_COLON = new MesonBuildToken(":");
  IElementType LANG_TOKEN_DOT = new MesonBuildToken(".");
  IElementType LANG_TOKEN_ELSE = new MesonBuildToken("else");
  IElementType LANG_TOKEN_ELSE_IF = new MesonBuildToken("elif");
  IElementType LANG_TOKEN_ENDIF = new MesonBuildToken("endif");
  IElementType LANG_TOKEN_FOREACH = new MesonBuildToken("foreach");
  IElementType LANG_TOKEN_FOREACH_END = new MesonBuildToken("endforeach");
  IElementType LANG_TOKEN_IF = new MesonBuildToken("if");
  IElementType LANG_TOKEN_JUMP_BREAK = new MesonBuildToken("break");
  IElementType LANG_TOKEN_JUMP_CONTINUE = new MesonBuildToken("continue");
  IElementType LANG_TOKEN_NOT = new MesonBuildToken("not");
  IElementType LANG_TOKEN_OR = new MesonBuildToken("or");
  IElementType LANG_TOKEN_QMARK = new MesonBuildToken("?");
  IElementType LINE_COMMENT = new MesonBuildToken("line_comment");
  IElementType MINUS_OP = new MesonBuildToken("-");
  IElementType MOD_OP = new MesonBuildToken("%");
  IElementType MULT_OP = new MesonBuildToken("*");
  IElementType NEWLINE = new MesonBuildToken("newline");
  IElementType OCTNUM = new MesonBuildToken("octnum");
  IElementType PAREN_BEGIN = new MesonBuildToken("(");
  IElementType PAREN_END = new MesonBuildToken(")");
  IElementType PLUS_OP = new MesonBuildToken("+");
  IElementType STRMULTILINE = new MesonBuildToken("strmultiline");
  IElementType STRSIMPLE = new MesonBuildToken("strsimple");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ADD_EXPR) {
        return new MesonBuildAddExprImpl(node);
      }
      else if (type == ARRAY_LITERAL) {
        return new MesonBuildArrayLiteralImpl(node);
      }
      else if (type == ASSIGNMENT_STATEMENT) {
        return new MesonBuildAssignmentStatementImpl(node);
      }
      else if (type == ATOM) {
        return new MesonBuildAtomImpl(node);
      }
      else if (type == ATROP) {
        return new MesonBuildAtropImpl(node);
      }
      else if (type == CONDITIONAL_AND_EXPRESSION) {
        return new MesonBuildConditionalAndExpressionImpl(node);
      }
      else if (type == CONDITIONAL_OR_EXPRESSION) {
        return new MesonBuildConditionalOrExpressionImpl(node);
      }
      else if (type == CONTROL_STATEMENT) {
        return new MesonBuildControlStatementImpl(node);
      }
      else if (type == DICT_LITERAL) {
        return new MesonBuildDictLiteralImpl(node);
      }
      else if (type == FOR_STATEMENT) {
        return new MesonBuildForStatementImpl(node);
      }
      else if (type == FOR_STATEMENT_LIST) {
        return new MesonBuildForStatementListImpl(node);
      }
      else if (type == FULL_EXPRESSION) {
        return new MesonBuildFullExpressionImpl(node);
      }
      else if (type == FUNC_ARG) {
        return new MesonBuildFuncArgImpl(node);
      }
      else if (type == FUNC_ARGS) {
        return new MesonBuildFuncArgsImpl(node);
      }
      else if (type == FUNC_CALL_EXPRESSION) {
        return new MesonBuildFuncCallExpressionImpl(node);
      }
      else if (type == FUNC_CALL_STATEMENT) {
        return new MesonBuildFuncCallStatementImpl(node);
      }
      else if (type == FUNC_NAME) {
        return new MesonBuildFuncNameImpl(node);
      }
      else if (type == ID_EXPRESSION) {
        return new MesonBuildIdExpressionImpl(node);
      }
      else if (type == ID_LIST) {
        return new MesonBuildIdListImpl(node);
      }
      else if (type == KEYWORD_ELEM) {
        return new MesonBuildKeywordElemImpl(node);
      }
      else if (type == METHOD_CALL_EXPRESSION_BASE) {
        return new MesonBuildMethodCallExpressionBaseImpl(node);
      }
      else if (type == METHOD_CALL_STATEMENT) {
        return new MesonBuildMethodCallStatementImpl(node);
      }
      else if (type == MUL_EXPR) {
        return new MesonBuildMulExprImpl(node);
      }
      else if (type == MUL_OP) {
        return new MesonBuildMulOpImpl(node);
      }
      else if (type == NUM_LITERAL_UNARY) {
        return new MesonBuildNumLiteralUnaryImpl(node);
      }
      else if (type == POSITIONAL_FUNC_ARG) {
        return new MesonBuildPositionalFuncArgImpl(node);
      }
      else if (type == RELATION_CHECK) {
        return new MesonBuildRelationCheckImpl(node);
      }
      else if (type == RELATION_CHECK_OP) {
        return new MesonBuildRelationCheckOpImpl(node);
      }
      else if (type == REPETITIVE_STATEMENT) {
        return new MesonBuildRepetitiveStatementImpl(node);
      }
      else if (type == SELECTION_STATEMENT) {
        return new MesonBuildSelectionStatementImpl(node);
      }
      else if (type == SELECTION_STATEMENT_FOR) {
        return new MesonBuildSelectionStatementForImpl(node);
      }
      else if (type == STATEMENT) {
        return new MesonBuildStatementImpl(node);
      }
      else if (type == STATEMENT_LIST) {
        return new MesonBuildStatementListImpl(node);
      }
      else if (type == SUBSCRIPT_METHOD_CHAIN_EXPR) {
        return new MesonBuildSubscriptMethodChainExprImpl(node);
      }
      else if (type == TERNARY_EXPRESSION) {
        return new MesonBuildTernaryExpressionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
