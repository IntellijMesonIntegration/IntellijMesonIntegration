// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.nonnulldinu.clionmeson.build.psi.impl.*;

public interface MesonBuildTypes {

  IElementType DEC_LITERAL = new MesonBuildElement("DEC_LITERAL");
  IElementType EXPRESSION = new MesonBuildElement("EXPRESSION");
  IElementType FUNC_ARG = new MesonBuildElement("FUNC_ARG");
  IElementType FUNC_ARGS = new MesonBuildElement("FUNC_ARGS");
  IElementType FUNC_CALL_STATEMENT = new MesonBuildElement("FUNC_CALL_STATEMENT");
  IElementType FUNC_NAME = new MesonBuildElement("FUNC_NAME");
  IElementType HEX_LITERAL = new MesonBuildElement("HEX_LITERAL");
  IElementType ID_EXPRESSION = new MesonBuildElement("ID_EXPRESSION");
  IElementType KEYWORD_FUNC_ARG = new MesonBuildElement("KEYWORD_FUNC_ARG");
  IElementType NUM_LITERAL = new MesonBuildElement("NUM_LITERAL");
  IElementType OCT_LITERAL = new MesonBuildElement("OCT_LITERAL");
  IElementType POSITIONAL_FUNC_ARG = new MesonBuildElement("POSITIONAL_FUNC_ARG");
  IElementType STATEMENT = new MesonBuildElement("STATEMENT");
  IElementType STRING_LITERAL = new MesonBuildElement("STRING_LITERAL");

  IElementType ATR_OP = new MesonBuildToken("=");
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
  IElementType LANG_TOKEN_QMARK = new MesonBuildToken("?");
  IElementType MINUS_OP = new MesonBuildToken("-");
  IElementType MOD_OP = new MesonBuildToken("%");
  IElementType MULT_OP = new MesonBuildToken("*");
  IElementType NEWLINE = new MesonBuildToken("NEWLINE");
  IElementType NOT_OP = new MesonBuildToken("not");
  IElementType OCTNUM = new MesonBuildToken("octnum");
  IElementType PAREN_BEGIN = new MesonBuildToken("(");
  IElementType PAREN_END = new MesonBuildToken(")");
  IElementType PLUS_OP = new MesonBuildToken("+");
  IElementType STRMULTILINE = new MesonBuildToken("strmultiline");
  IElementType STRSIMPLE = new MesonBuildToken("strsimple");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == DEC_LITERAL) {
        return new MesonBuildDecLiteralImpl(node);
      }
      else if (type == EXPRESSION) {
        return new MesonBuildExpressionImpl(node);
      }
      else if (type == FUNC_ARG) {
        return new MesonBuildFuncArgImpl(node);
      }
      else if (type == FUNC_ARGS) {
        return new MesonBuildFuncArgsImpl(node);
      }
      else if (type == FUNC_CALL_STATEMENT) {
        return new MesonBuildFuncCallStatementImpl(node);
      }
      else if (type == FUNC_NAME) {
        return new MesonBuildFuncNameImpl(node);
      }
      else if (type == HEX_LITERAL) {
        return new MesonBuildHexLiteralImpl(node);
      }
      else if (type == ID_EXPRESSION) {
        return new MesonBuildIdExpressionImpl(node);
      }
      else if (type == KEYWORD_FUNC_ARG) {
        return new MesonBuildKeywordFuncArgImpl(node);
      }
      else if (type == NUM_LITERAL) {
        return new MesonBuildNumLiteralImpl(node);
      }
      else if (type == OCT_LITERAL) {
        return new MesonBuildOctLiteralImpl(node);
      }
      else if (type == POSITIONAL_FUNC_ARG) {
        return new MesonBuildPositionalFuncArgImpl(node);
      }
      else if (type == STATEMENT) {
        return new MesonBuildStatementImpl(node);
      }
      else if (type == STRING_LITERAL) {
        return new MesonBuildStringLiteralImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
