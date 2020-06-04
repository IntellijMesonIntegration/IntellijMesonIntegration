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
  // mul_expr (add_op mul_expr)*
  public static boolean add_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "add_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADD_EXPR, "<add expr>");
    r = mul_expr(b, l + 1);
    r = r && add_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (add_op mul_expr)*
  private static boolean add_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "add_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!add_expr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "add_expr_1", c)) break;
    }
    return true;
  }

  // add_op mul_expr
  private static boolean add_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "add_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = add_op(b, l + 1);
    r = r && mul_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '+' | '-'
  static boolean add_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "add_op")) return false;
    if (!nextTokenIs(b, "", MINUS_OP, PLUS_OP)) return false;
    boolean r;
    r = consumeToken(b, PLUS_OP);
    if (!r) r = consumeToken(b, MINUS_OP);
    return r;
  }

  /* ********************************************************** */
  // "[" [newline? full_expression (newline? "," newline? full_expression)*] (","? newline?) "]"
  public static boolean array_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_literal")) return false;
    if (!nextTokenIs(b, BRACE_BEGIN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_BEGIN);
    r = r && array_literal_1(b, l + 1);
    r = r && array_literal_2(b, l + 1);
    r = r && consumeToken(b, BRACE_END);
    exit_section_(b, m, ARRAY_LITERAL, r);
    return r;
  }

  // [newline? full_expression (newline? "," newline? full_expression)*]
  private static boolean array_literal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_literal_1")) return false;
    array_literal_1_0(b, l + 1);
    return true;
  }

  // newline? full_expression (newline? "," newline? full_expression)*
  private static boolean array_literal_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_literal_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = array_literal_1_0_0(b, l + 1);
    r = r && full_expression(b, l + 1);
    r = r && array_literal_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // newline?
  private static boolean array_literal_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_literal_1_0_0")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // (newline? "," newline? full_expression)*
  private static boolean array_literal_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_literal_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!array_literal_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_literal_1_0_2", c)) break;
    }
    return true;
  }

  // newline? "," newline? full_expression
  private static boolean array_literal_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_literal_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = array_literal_1_0_2_0_0(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && array_literal_1_0_2_0_2(b, l + 1);
    r = r && full_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // newline?
  private static boolean array_literal_1_0_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_literal_1_0_2_0_0")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // newline?
  private static boolean array_literal_1_0_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_literal_1_0_2_0_2")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // ","? newline?
  private static boolean array_literal_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_literal_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = array_literal_2_0(b, l + 1);
    r = r && array_literal_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ","?
  private static boolean array_literal_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_literal_2_0")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // newline?
  private static boolean array_literal_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_literal_2_1")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  /* ********************************************************** */
  // id_expression atrop full_expression newline
  public static boolean assignment_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_statement")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT_STATEMENT, null);
    r = id_expression(b, l + 1);
    r = r && atrop(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, full_expression(b, l + 1));
    r = p && consumeToken(b, NEWLINE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // literal | subscript_method_chain_expr | par_expression
  public static boolean atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOM, "<atom>");
    r = literal(b, l + 1);
    if (!r) r = subscript_method_chain_expr(b, l + 1);
    if (!r) r = par_expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "=" | "+=" | "-=" | "/=" | "*=" | "%="
  public static boolean atrop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atrop")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATROP, "<atrop>");
    r = consumeToken(b, ATR_OP);
    if (!r) r = consumeToken(b, COMP_ATR_OP4);
    if (!r) r = consumeToken(b, COMP_ATR_OP5);
    if (!r) r = consumeToken(b, COMP_ATR_OP2);
    if (!r) r = consumeToken(b, COMP_ATR_OP1);
    if (!r) r = consumeToken(b, COMP_ATR_OP3);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // binnum
  static boolean bin_literal(PsiBuilder b, int l) {
    return consumeToken(b, BINNUM);
  }

  /* ********************************************************** */
  // bool_literal | relation_check | par_expression | "not" bool_atom
  static boolean bool_atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_atom")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bool_literal(b, l + 1);
    if (!r) r = relation_check(b, l + 1);
    if (!r) r = par_expression(b, l + 1);
    if (!r) r = bool_atom_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "not" bool_atom
  private static boolean bool_atom_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_atom_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LANG_TOKEN_NOT);
    r = r && bool_atom(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "true" | "false"
  static boolean bool_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_literal")) return false;
    if (!nextTokenIs(b, "", BOOL_LITERAL_FALSE, BOOL_LITERAL_TRUE)) return false;
    boolean r;
    r = consumeToken(b, BOOL_LITERAL_TRUE);
    if (!r) r = consumeToken(b, BOOL_LITERAL_FALSE);
    return r;
  }

  /* ********************************************************** */
  // statement_list
  static boolean build_definition(PsiBuilder b, int l) {
    return statement_list(b, l + 1);
  }

  /* ********************************************************** */
  // bool_atom ("and" bool_atom)*
  public static boolean conditional_and_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_and_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITIONAL_AND_EXPRESSION, "<conditional and expression>");
    r = bool_atom(b, l + 1);
    r = r && conditional_and_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ("and" bool_atom)*
  private static boolean conditional_and_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_and_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!conditional_and_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "conditional_and_expression_1", c)) break;
    }
    return true;
  }

  // "and" bool_atom
  private static boolean conditional_and_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_and_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LANG_TOKEN_AND);
    r = r && bool_atom(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // conditional_and_expression ("or" conditional_and_expression)*
  public static boolean conditional_or_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_or_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITIONAL_OR_EXPRESSION, "<conditional or expression>");
    r = conditional_and_expression(b, l + 1);
    r = r && conditional_or_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ("or" conditional_and_expression)*
  private static boolean conditional_or_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_or_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!conditional_or_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "conditional_or_expression_1", c)) break;
    }
    return true;
  }

  // "or" conditional_and_expression
  private static boolean conditional_or_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_or_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LANG_TOKEN_OR);
    r = r && conditional_and_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ("continue" | "break") newline
  public static boolean control_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "control_statement")) return false;
    if (!nextTokenIs(b, "<control statement>", LANG_TOKEN_JUMP_BREAK, LANG_TOKEN_JUMP_CONTINUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTROL_STATEMENT, "<control statement>");
    r = control_statement_0(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "continue" | "break"
  private static boolean control_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "control_statement_0")) return false;
    boolean r;
    r = consumeToken(b, LANG_TOKEN_JUMP_CONTINUE);
    if (!r) r = consumeToken(b, LANG_TOKEN_JUMP_BREAK);
    return r;
  }

  /* ********************************************************** */
  // decnum
  static boolean dec_literal(PsiBuilder b, int l) {
    return consumeToken(b, DECNUM);
  }

  /* ********************************************************** */
  // "{" [newline? keyword_elem (newline? "," newline? keyword_elem)*] (","? newline?) "}"
  public static boolean dict_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_literal")) return false;
    if (!nextTokenIs(b, CURLY_BRACE_BEGIN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CURLY_BRACE_BEGIN);
    r = r && dict_literal_1(b, l + 1);
    r = r && dict_literal_2(b, l + 1);
    r = r && consumeToken(b, CURLY_BRACE_END);
    exit_section_(b, m, DICT_LITERAL, r);
    return r;
  }

  // [newline? keyword_elem (newline? "," newline? keyword_elem)*]
  private static boolean dict_literal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_literal_1")) return false;
    dict_literal_1_0(b, l + 1);
    return true;
  }

  // newline? keyword_elem (newline? "," newline? keyword_elem)*
  private static boolean dict_literal_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_literal_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = dict_literal_1_0_0(b, l + 1);
    r = r && keyword_elem(b, l + 1);
    r = r && dict_literal_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // newline?
  private static boolean dict_literal_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_literal_1_0_0")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // (newline? "," newline? keyword_elem)*
  private static boolean dict_literal_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_literal_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!dict_literal_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "dict_literal_1_0_2", c)) break;
    }
    return true;
  }

  // newline? "," newline? keyword_elem
  private static boolean dict_literal_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_literal_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = dict_literal_1_0_2_0_0(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && dict_literal_1_0_2_0_2(b, l + 1);
    r = r && keyword_elem(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // newline?
  private static boolean dict_literal_1_0_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_literal_1_0_2_0_0")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // newline?
  private static boolean dict_literal_1_0_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_literal_1_0_2_0_2")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // ","? newline?
  private static boolean dict_literal_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_literal_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = dict_literal_2_0(b, l + 1);
    r = r && dict_literal_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ","?
  private static boolean dict_literal_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_literal_2_0")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // newline?
  private static boolean dict_literal_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_literal_2_1")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  /* ********************************************************** */
  // '==' | '!='
  static boolean eq_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "eq_op")) return false;
    if (!nextTokenIs(b, "", COMP_OP1, COMP_OP6)) return false;
    boolean r;
    r = consumeToken(b, COMP_OP1);
    if (!r) r = consumeToken(b, COMP_OP6);
    return r;
  }

  /* ********************************************************** */
  // !<<eof>> (method_call_statement | func_call_statement | assignment_statement | selection_statement | repetitive_statement | control_statement)
  public static boolean for_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FOR_STATEMENT, "<for statement>");
    r = for_statement_0(b, l + 1);
    r = r && for_statement_1(b, l + 1);
    exit_section_(b, l, m, r, false, statement_recover_parser_);
    return r;
  }

  // !<<eof>>
  private static boolean for_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // method_call_statement | func_call_statement | assignment_statement | selection_statement | repetitive_statement | control_statement
  private static boolean for_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = method_call_statement(b, l + 1);
    if (!r) r = func_call_statement(b, l + 1);
    if (!r) r = assignment_statement(b, l + 1);
    if (!r) r = selection_statement(b, l + 1);
    if (!r) r = repetitive_statement(b, l + 1);
    if (!r) r = control_statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (for_statement | newline)*
  public static boolean for_statement_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement_list")) return false;
    Marker m = enter_section_(b, l, _NONE_, FOR_STATEMENT_LIST, "<for statement list>");
    while (true) {
      int c = current_position_(b);
      if (!for_statement_list_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "for_statement_list", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // for_statement | newline
  private static boolean for_statement_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement_list_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = for_statement(b, l + 1);
    if (!r) r = consumeToken(b, NEWLINE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // full_expression
  static boolean full_bool_expression(PsiBuilder b, int l) {
    return full_expression(b, l + 1);
  }

  /* ********************************************************** */
  // ternary_expression | conditional_or_expression | add_expr
  public static boolean full_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "full_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FULL_EXPRESSION, "<full expression>");
    r = ternary_expression(b, l + 1);
    if (!r) r = conditional_or_expression(b, l + 1);
    if (!r) r = add_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // keyword_elem | positional_func_arg
  public static boolean func_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNC_ARG, "<func arg>");
    r = keyword_elem(b, l + 1);
    if (!r) r = positional_func_arg(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // newline? func_arg (newline? "," newline? func_arg)*(","? newline?)
  public static boolean func_args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_args")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNC_ARGS, "<func args>");
    r = func_args_0(b, l + 1);
    r = r && func_arg(b, l + 1);
    r = r && func_args_2(b, l + 1);
    r = r && func_args_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // newline?
  private static boolean func_args_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_args_0")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // (newline? "," newline? func_arg)*
  private static boolean func_args_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_args_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!func_args_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "func_args_2", c)) break;
    }
    return true;
  }

  // newline? "," newline? func_arg
  private static boolean func_args_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_args_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = func_args_2_0_0(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && func_args_2_0_2(b, l + 1);
    r = r && func_arg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // newline?
  private static boolean func_args_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_args_2_0_0")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // newline?
  private static boolean func_args_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_args_2_0_2")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // ","? newline?
  private static boolean func_args_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_args_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = func_args_3_0(b, l + 1);
    r = r && func_args_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ","?
  private static boolean func_args_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_args_3_0")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // newline?
  private static boolean func_args_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_args_3_1")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  /* ********************************************************** */
  // func_name "(" [func_args] ")"
  public static boolean func_call_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_call_expression")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNC_CALL_EXPRESSION, null);
    r = func_name(b, l + 1);
    r = r && consumeToken(b, PAREN_BEGIN);
    p = r; // pin = 2
    r = r && report_error_(b, func_call_expression_2(b, l + 1));
    r = p && consumeToken(b, PAREN_END) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [func_args]
  private static boolean func_call_expression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_call_expression_2")) return false;
    func_args(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // func_call_expression newline
  public static boolean func_call_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_call_statement")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = func_call_expression(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, m, FUNC_CALL_STATEMENT, r);
    return r;
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
  static boolean hex_literal(PsiBuilder b, int l) {
    return consumeToken(b, HEXNUM);
  }

  /* ********************************************************** */
  // id
  public static boolean id_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_expression")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, ID_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // id ("," id)*
  public static boolean id_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_list")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && id_list_1(b, l + 1);
    exit_section_(b, m, ID_LIST, r);
    return r;
  }

  // ("," id)*
  private static boolean id_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!id_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "id_list_1", c)) break;
    }
    return true;
  }

  // "," id
  private static boolean id_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "[" atom "]"
  static boolean index_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "index_expr")) return false;
    if (!nextTokenIs(b, BRACE_BEGIN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_BEGIN);
    r = r && atom(b, l + 1);
    r = r && consumeToken(b, BRACE_END);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // id ":" full_expression
  public static boolean keyword_elem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyword_elem")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, LANG_TOKEN_COLON);
    r = r && full_expression(b, l + 1);
    exit_section_(b, m, KEYWORD_ELEM, r);
    return r;
  }

  /* ********************************************************** */
  // dict_literal | array_literal | num_literal | string_literal | num_literal_unary | bool_literal
  static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    boolean r;
    r = dict_literal(b, l + 1);
    if (!r) r = array_literal(b, l + 1);
    if (!r) r = num_literal(b, l + 1);
    if (!r) r = string_literal(b, l + 1);
    if (!r) r = num_literal_unary(b, l + 1);
    if (!r) r = bool_literal(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // id | literal
  public static boolean method_call_expression_base(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_call_expression_base")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD_CALL_EXPRESSION_BASE, "<method call expression base>");
    r = consumeToken(b, ID);
    if (!r) r = literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // subscript_method_chain_expr newline
  public static boolean method_call_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_call_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD_CALL_STATEMENT, "<method call statement>");
    r = subscript_method_chain_expr(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // atom (mul_op atom)*
  public static boolean mul_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mul_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MUL_EXPR, "<mul expr>");
    r = atom(b, l + 1);
    r = r && mul_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (mul_op atom)*
  private static boolean mul_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mul_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!mul_expr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mul_expr_1", c)) break;
    }
    return true;
  }

  // mul_op atom
  private static boolean mul_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mul_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = mul_op(b, l + 1);
    r = r && atom(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '*' | '/' | '%'
  public static boolean mul_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mul_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MUL_OP, "<mul op>");
    r = consumeToken(b, MULT_OP);
    if (!r) r = consumeToken(b, DIV_OP);
    if (!r) r = consumeToken(b, MOD_OP);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // bin_literal | oct_literal | dec_literal | hex_literal
  static boolean num_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_literal")) return false;
    boolean r;
    r = bin_literal(b, l + 1);
    if (!r) r = oct_literal(b, l + 1);
    if (!r) r = dec_literal(b, l + 1);
    if (!r) r = hex_literal(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // unary_num_op num_literal
  public static boolean num_literal_unary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "num_literal_unary")) return false;
    if (!nextTokenIs(b, "<num literal unary>", MINUS_OP, PLUS_OP)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUM_LITERAL_UNARY, "<num literal unary>");
    r = unary_num_op(b, l + 1);
    r = r && num_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // octnum
  static boolean oct_literal(PsiBuilder b, int l) {
    return consumeToken(b, OCTNUM);
  }

  /* ********************************************************** */
  // "(" full_expression ")"
  static boolean par_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "par_expression")) return false;
    if (!nextTokenIs(b, PAREN_BEGIN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PAREN_BEGIN);
    r = r && full_expression(b, l + 1);
    r = r && consumeToken(b, PAREN_END);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // full_expression
  public static boolean positional_func_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "positional_func_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, POSITIONAL_FUNC_ARG, "<positional func arg>");
    r = full_expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // add_expr relation_check_op add_expr
  public static boolean relation_check(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relation_check")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RELATION_CHECK, "<relation check>");
    r = add_expr(b, l + 1);
    r = r && relation_check_op(b, l + 1);
    p = r; // pin = 2
    r = r && add_expr(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // '>=' | '>' | '<=' | '<' | eq_op
  public static boolean relation_check_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relation_check_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RELATION_CHECK_OP, "<relation check op>");
    r = consumeToken(b, COMP_OP3);
    if (!r) r = consumeToken(b, COMP_OP5);
    if (!r) r = consumeToken(b, COMP_OP2);
    if (!r) r = consumeToken(b, COMP_OP4);
    if (!r) r = eq_op(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "foreach" id_list ":" full_expression newline for_statement_list "endforeach" newline
  public static boolean repetitive_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repetitive_statement")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, REPETITIVE_STATEMENT, "<repetitive statement>");
    r = consumeToken(b, LANG_TOKEN_FOREACH);
    p = r; // pin = 1
    r = r && report_error_(b, id_list(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LANG_TOKEN_COLON)) && r;
    r = p && report_error_(b, full_expression(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, NEWLINE)) && r;
    r = p && report_error_(b, for_statement_list(b, l + 1)) && r;
    r = p && report_error_(b, consumeTokens(b, -1, LANG_TOKEN_FOREACH_END, NEWLINE)) && r;
    exit_section_(b, l, m, r, p, repetitive_statement_recover_parser_);
    return r || p;
  }

  /* ********************************************************** */
  // !"endforeach" newline
  static boolean repetitive_statement_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repetitive_statement_recover")) return false;
    if (!nextTokenIs(b, NEWLINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = repetitive_statement_recover_0(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, m, null, r);
    return r;
  }

  // !"endforeach"
  private static boolean repetitive_statement_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repetitive_statement_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, LANG_TOKEN_FOREACH_END);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "if" full_bool_expression newline statement_list ("elif" full_bool_expression newline statement_list)* ["else" newline statement_list] "endif" newline
  public static boolean selection_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selection_statement")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SELECTION_STATEMENT, "<selection statement>");
    r = consumeToken(b, LANG_TOKEN_IF);
    p = r; // pin = 1
    r = r && report_error_(b, full_bool_expression(b, l + 1));
    r = p && report_error_(b, consumeToken(b, NEWLINE)) && r;
    r = p && report_error_(b, statement_list(b, l + 1)) && r;
    r = p && report_error_(b, selection_statement_4(b, l + 1)) && r;
    r = p && report_error_(b, selection_statement_5(b, l + 1)) && r;
    r = p && report_error_(b, consumeTokens(b, -1, LANG_TOKEN_ENDIF, NEWLINE)) && r;
    exit_section_(b, l, m, r, p, selection_statement_recover_parser_);
    return r || p;
  }

  // ("elif" full_bool_expression newline statement_list)*
  private static boolean selection_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selection_statement_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!selection_statement_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "selection_statement_4", c)) break;
    }
    return true;
  }

  // "elif" full_bool_expression newline statement_list
  private static boolean selection_statement_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selection_statement_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LANG_TOKEN_ELSE_IF);
    r = r && full_bool_expression(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    r = r && statement_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ["else" newline statement_list]
  private static boolean selection_statement_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selection_statement_5")) return false;
    selection_statement_5_0(b, l + 1);
    return true;
  }

  // "else" newline statement_list
  private static boolean selection_statement_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selection_statement_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LANG_TOKEN_ELSE, NEWLINE);
    r = r && statement_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !"endif" newline
  static boolean selection_statement_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selection_statement_recover")) return false;
    if (!nextTokenIs(b, NEWLINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = selection_statement_recover_0(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, m, null, r);
    return r;
  }

  // !"endif"
  private static boolean selection_statement_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selection_statement_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, LANG_TOKEN_ENDIF);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !<<eof>> (method_call_statement | func_call_statement | assignment_statement | selection_statement | repetitive_statement)
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = statement_0(b, l + 1);
    r = r && statement_1(b, l + 1);
    exit_section_(b, l, m, r, false, statement_recover_parser_);
    return r;
  }

  // !<<eof>>
  private static boolean statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // method_call_statement | func_call_statement | assignment_statement | selection_statement | repetitive_statement
  private static boolean statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = method_call_statement(b, l + 1);
    if (!r) r = func_call_statement(b, l + 1);
    if (!r) r = assignment_statement(b, l + 1);
    if (!r) r = selection_statement(b, l + 1);
    if (!r) r = repetitive_statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (statement | newline)*
  public static boolean statement_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_list")) return false;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT_LIST, "<statement list>");
    while (true) {
      int c = current_position_(b);
      if (!statement_list_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "statement_list", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // statement | newline
  private static boolean statement_list_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_list_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = statement(b, l + 1);
    if (!r) r = consumeToken(b, NEWLINE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // newline
  static boolean statement_recover(PsiBuilder b, int l) {
    return consumeToken(b, NEWLINE);
  }

  /* ********************************************************** */
  // strmultiline | strsimple
  static boolean string_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal")) return false;
    if (!nextTokenIs(b, "", STRMULTILINE, STRSIMPLE)) return false;
    boolean r;
    r = consumeToken(b, STRMULTILINE);
    if (!r) r = consumeToken(b, STRSIMPLE);
    return r;
  }

  /* ********************************************************** */
  // method_call_expression_base ("." func_call_expression | index_expr)*
  public static boolean subscript_method_chain_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subscript_method_chain_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SUBSCRIPT_METHOD_CHAIN_EXPR, "<subscript method chain expr>");
    r = method_call_expression_base(b, l + 1);
    r = r && subscript_method_chain_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ("." func_call_expression | index_expr)*
  private static boolean subscript_method_chain_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subscript_method_chain_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!subscript_method_chain_expr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "subscript_method_chain_expr_1", c)) break;
    }
    return true;
  }

  // "." func_call_expression | index_expr
  private static boolean subscript_method_chain_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subscript_method_chain_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = subscript_method_chain_expr_1_0_0(b, l + 1);
    if (!r) r = index_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "." func_call_expression
  private static boolean subscript_method_chain_expr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subscript_method_chain_expr_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LANG_TOKEN_DOT);
    r = r && func_call_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // conditional_or_expression "?" full_expression ":" full_expression
  public static boolean ternary_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ternary_expression")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TERNARY_EXPRESSION, "<ternary expression>");
    r = conditional_or_expression(b, l + 1);
    r = r && consumeToken(b, LANG_TOKEN_QMARK);
    p = r; // pin = 2
    r = r && report_error_(b, full_expression(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LANG_TOKEN_COLON)) && r;
    r = p && full_expression(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // "+" | "-"
  static boolean unary_num_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_num_op")) return false;
    if (!nextTokenIs(b, "", MINUS_OP, PLUS_OP)) return false;
    boolean r;
    r = consumeToken(b, PLUS_OP);
    if (!r) r = consumeToken(b, MINUS_OP);
    return r;
  }

  static final Parser repetitive_statement_recover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return repetitive_statement_recover(b, l + 1);
    }
  };
  static final Parser selection_statement_recover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return selection_statement_recover(b, l + 1);
    }
  };
  static final Parser statement_recover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return statement_recover(b, l + 1);
    }
  };
}
