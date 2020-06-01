// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.languages.parsers;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.nonnulldinu.clionmeson.build.psi.MesonBuildTypes.*;
import static com.nonnulldinu.clionmeson.languages.parsers.MesonBuildParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class MesonBuildParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return build_definition(b, l + 1);
  }

  /* ********************************************************** */
  // (NEWLINE | statement)*
  static boolean build_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "build_definition")) return false;
    while (true) {
      int c = current_position_(b);
      if (!build_definition_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "build_definition", c)) break;
    }
    return true;
  }

  // NEWLINE | statement
  private static boolean build_definition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "build_definition_0")) return false;
    boolean r;
    r = consumeToken(b, NEWLINE);
    if (!r) r = statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // decnum
  public static boolean dec_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dec_literal")) return false;
    if (!nextTokenIs(b, DECNUM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DECNUM);
    exit_section_(b, m, DEC_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // id | string_literal | num_literal
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = consumeToken(b, ID);
    if (!r) r = string_literal(b, l + 1);
    if (!r) r = num_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // positional_func_args ["," key_func_args] | key_func_args
  public static boolean func_args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_args")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNC_ARGS, "<func args>");
    r = func_args_0(b, l + 1);
    if (!r) r = key_func_args(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // positional_func_args ["," key_func_args]
  private static boolean func_args_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_args_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = positional_func_args(b, l + 1);
    r = r && func_args_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ["," key_func_args]
  private static boolean func_args_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_args_0_1")) return false;
    func_args_0_1_0(b, l + 1);
    return true;
  }

  // "," key_func_args
  private static boolean func_args_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_args_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && key_func_args(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // func_name "(" [e_func_args] ")"
  public static boolean func_call_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_call_statement")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = func_name(b, l + 1);
    r = r && consumeToken(b, PAREN_BEGIN);
    r = r && func_call_statement_2(b, l + 1);
    r = r && consumeToken(b, PAREN_END);
    exit_section_(b, m, FUNC_CALL_STATEMENT, r);
    return r;
  }

  // [e_func_args]
  private static boolean func_call_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_call_statement_2")) return false;
    func_args(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // id
  public static boolean func_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_name")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, FUNC_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // hexnum
  public static boolean hex_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hex_literal")) return false;
    if (!nextTokenIs(b, HEXNUM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HEXNUM);
    exit_section_(b, m, HEX_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // id ":" expression
  public static boolean key_func_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_func_arg")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, LANG_TOKEN_COLON);
    r = r && expression(b, l + 1);
    exit_section_(b, m, KEY_FUNC_ARG, r);
    return r;
  }

  /* ********************************************************** */
  // key_func_arg ("," key_func_arg)*
  public static boolean key_func_args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_func_args")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = key_func_arg(b, l + 1);
    r = r && key_func_args_1(b, l + 1);
    exit_section_(b, m, KEY_FUNC_ARGS, r);
    return r;
  }

  // ("," key_func_arg)*
  private static boolean key_func_args_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_func_args_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!key_func_args_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "key_func_args_1", c)) break;
    }
    return true;
  }

  // "," key_func_arg
  private static boolean key_func_args_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_func_args_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && key_func_arg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // oct_literal | dec_literal | hex_literal
  public static boolean num_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUM_LITERAL, "<num literal>");
    r = oct_literal(b, l + 1);
    if (!r) r = dec_literal(b, l + 1);
    if (!r) r = hex_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // octnum
  public static boolean oct_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "oct_literal")) return false;
    if (!nextTokenIs(b, OCTNUM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OCTNUM);
    exit_section_(b, m, OCT_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // expression
  public static boolean positional_func_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "positional_func_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, POSITIONAL_FUNC_ARG, "<positional func arg>");
    r = expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // positional_func_arg ("," positional_func_arg)*
  public static boolean positional_func_args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "positional_func_args")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, POSITIONAL_FUNC_ARGS, "<positional func args>");
    r = positional_func_arg(b, l + 1);
    r = r && positional_func_args_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ("," positional_func_arg)*
  private static boolean positional_func_args_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "positional_func_args_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!positional_func_args_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "positional_func_args_1", c)) break;
    }
    return true;
  }

  // "," positional_func_arg
  private static boolean positional_func_args_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "positional_func_args_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && positional_func_arg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (func_call_statement) NEWLINE
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement_0(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, m, STATEMENT, r);
    return r;
  }

  // (func_call_statement)
  private static boolean statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = func_call_statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // strsimple | strmultiline
  public static boolean string_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal")) return false;
    if (!nextTokenIs(b, "<string literal>", STRMULTILINE, STRSIMPLE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING_LITERAL, "<string literal>");
    r = consumeToken(b, STRSIMPLE);
    if (!r) r = consumeToken(b, STRMULTILINE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
