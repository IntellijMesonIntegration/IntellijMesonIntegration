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
  // "+" | "-"
  public static boolean add_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "add_op")) return false;
    if (!nextTokenIs(b, "<add op>", MINUS_OP, PLUS_OP)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADD_OP, "<add op>");
    r = consumeToken(b, PLUS_OP);
    if (!r) r = consumeToken(b, MINUS_OP);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "[" [newline? full_expression (newline? "," newline? full_expression)*] (","? newline?) "]"
  public static boolean array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array")) return false;
    if (!nextTokenIs(b, BRACE_BEGIN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_BEGIN);
    r = r && array_1(b, l + 1);
    r = r && array_2(b, l + 1);
    r = r && consumeToken(b, BRACE_END);
    exit_section_(b, m, ARRAY, r);
    return r;
  }

  // [newline? full_expression (newline? "," newline? full_expression)*]
  private static boolean array_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1")) return false;
    array_1_0(b, l + 1);
    return true;
  }

  // newline? full_expression (newline? "," newline? full_expression)*
  private static boolean array_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = array_1_0_0(b, l + 1);
    r = r && full_expression(b, l + 1);
    r = r && array_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // newline?
  private static boolean array_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0_0")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // (newline? "," newline? full_expression)*
  private static boolean array_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!array_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_1_0_2", c)) break;
    }
    return true;
  }

  // newline? "," newline? full_expression
  private static boolean array_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = array_1_0_2_0_0(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && array_1_0_2_0_2(b, l + 1);
    r = r && full_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // newline?
  private static boolean array_1_0_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0_2_0_0")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // newline?
  private static boolean array_1_0_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0_2_0_2")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // ","? newline?
  private static boolean array_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = array_2_0(b, l + 1);
    r = r && array_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ","?
  private static boolean array_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_2_0")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // newline?
  private static boolean array_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_2_1")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  /* ********************************************************** */
  // id_expression atrop full_expression newline
  public static boolean assignment_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_statement")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT_STATEMENT, "<assignment statement>");
    r = id_expression(b, l + 1);
    r = r && atrop(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, full_expression(b, l + 1));
    r = p && consumeToken(b, NEWLINE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
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
  // "true" | "false"
  public static boolean bool_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bool_literal")) return false;
    if (!nextTokenIs(b, "<bool literal>", BOOL_LITERAL_FALSE, BOOL_LITERAL_TRUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_LITERAL, "<bool literal>");
    r = consumeToken(b, BOOL_LITERAL_TRUE);
    if (!r) r = consumeToken(b, BOOL_LITERAL_FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // statement_list
  static boolean build_definition(PsiBuilder b, int l) {
    return statement_list(b, l + 1);
  }

  /* ********************************************************** */
  // simple_bool_expression ("and" simple_bool_expression)*
  public static boolean conditional_and_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_and_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITIONAL_AND_EXPRESSION, "<conditional and expression>");
    r = simple_bool_expression(b, l + 1);
    r = r && conditional_and_expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ("and" simple_bool_expression)*
  private static boolean conditional_and_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_and_expression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!conditional_and_expression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "conditional_and_expression_1", c)) break;
    }
    return true;
  }

  // "and" simple_bool_expression
  private static boolean conditional_and_expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_and_expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LANG_TOKEN_AND);
    r = r && simple_bool_expression(b, l + 1);
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
  public static boolean dict(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict")) return false;
    if (!nextTokenIs(b, CURLY_BRACE_BEGIN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CURLY_BRACE_BEGIN);
    r = r && dict_1(b, l + 1);
    r = r && dict_2(b, l + 1);
    r = r && consumeToken(b, CURLY_BRACE_END);
    exit_section_(b, m, DICT, r);
    return r;
  }

  // [newline? keyword_elem (newline? "," newline? keyword_elem)*]
  private static boolean dict_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_1")) return false;
    dict_1_0(b, l + 1);
    return true;
  }

  // newline? keyword_elem (newline? "," newline? keyword_elem)*
  private static boolean dict_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = dict_1_0_0(b, l + 1);
    r = r && keyword_elem(b, l + 1);
    r = r && dict_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // newline?
  private static boolean dict_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_1_0_0")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // (newline? "," newline? keyword_elem)*
  private static boolean dict_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!dict_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "dict_1_0_2", c)) break;
    }
    return true;
  }

  // newline? "," newline? keyword_elem
  private static boolean dict_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = dict_1_0_2_0_0(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && dict_1_0_2_0_2(b, l + 1);
    r = r && keyword_elem(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // newline?
  private static boolean dict_1_0_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_1_0_2_0_0")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // newline?
  private static boolean dict_1_0_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_1_0_2_0_2")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  // ","? newline?
  private static boolean dict_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = dict_2_0(b, l + 1);
    r = r && dict_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ","?
  private static boolean dict_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_2_0")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // newline?
  private static boolean dict_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_2_1")) return false;
    consumeToken(b, NEWLINE);
    return true;
  }

  /* ********************************************************** */
  // "==" | "!="
  public static boolean equality_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equality_op")) return false;
    if (!nextTokenIs(b, "<equality op>", COMP_OP1, COMP_OP6)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EQUALITY_OP, "<equality op>");
    r = consumeToken(b, COMP_OP1);
    if (!r) r = consumeToken(b, COMP_OP6);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // dict | array | add_expr | id_expression | string_literal | num_literal_unary | num_literal | par_expression
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = dict(b, l + 1);
    if (!r) r = array(b, l + 1);
    if (!r) r = add_expr(b, l + 1);
    if (!r) r = id_expression(b, l + 1);
    if (!r) r = string_literal(b, l + 1);
    if (!r) r = num_literal_unary(b, l + 1);
    if (!r) r = num_literal(b, l + 1);
    if (!r) r = par_expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // dict | array | method_call_chain | func_call_expression | par_expression | id_expression | string_literal | num_literal
  public static boolean factor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "factor")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FACTOR, "<factor>");
    r = dict(b, l + 1);
    if (!r) r = array(b, l + 1);
    if (!r) r = method_call_chain(b, l + 1);
    if (!r) r = func_call_expression(b, l + 1);
    if (!r) r = par_expression(b, l + 1);
    if (!r) r = id_expression(b, l + 1);
    if (!r) r = string_literal(b, l + 1);
    if (!r) r = num_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // conditional_or_expression
  public static boolean full_bool_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "full_bool_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FULL_BOOL_EXPRESSION, "<full bool expression>");
    r = conditional_or_expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ternary_expression | full_bool_expression | expression
  public static boolean full_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "full_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FULL_EXPRESSION, "<full expression>");
    r = ternary_expression(b, l + 1);
    if (!r) r = full_bool_expression(b, l + 1);
    if (!r) r = expression(b, l + 1);
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
  // lvalue
  public static boolean id_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ID_EXPRESSION, "<id expression>");
    r = lvalue(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // "[" full_expression "]"
  public static boolean index_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "index_expr")) return false;
    if (!nextTokenIs(b, BRACE_BEGIN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_BEGIN);
    r = r && full_expression(b, l + 1);
    r = r && consumeToken(b, BRACE_END);
    exit_section_(b, m, INDEX_EXPR, r);
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
  // subscript_expr | id
  public static boolean lvalue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lvalue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LVALUE, "<lvalue>");
    r = subscript_expr(b, l + 1);
    if (!r) r = consumeToken(b, ID);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // method_call_expression_base ("." func_call_expression | index_expr)+
  public static boolean method_call_chain(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_call_chain")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD_CALL_CHAIN, "<method call chain>");
    r = method_call_expression_base(b, l + 1);
    r = r && method_call_chain_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ("." func_call_expression | index_expr)+
  private static boolean method_call_chain_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_call_chain_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = method_call_chain_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!method_call_chain_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "method_call_chain_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // "." func_call_expression | index_expr
  private static boolean method_call_chain_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_call_chain_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = method_call_chain_1_0_0(b, l + 1);
    if (!r) r = index_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "." func_call_expression
  private static boolean method_call_chain_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_call_chain_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LANG_TOKEN_DOT);
    r = r && func_call_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // dict | array | func_call_expression | par_expression | id | string_literal | num_literal
  public static boolean method_call_expression_base(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_call_expression_base")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD_CALL_EXPRESSION_BASE, "<method call expression base>");
    r = dict(b, l + 1);
    if (!r) r = array(b, l + 1);
    if (!r) r = func_call_expression(b, l + 1);
    if (!r) r = par_expression(b, l + 1);
    if (!r) r = consumeToken(b, ID);
    if (!r) r = string_literal(b, l + 1);
    if (!r) r = num_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // method_call_chain newline
  public static boolean method_call_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_call_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD_CALL_STATEMENT, "<method call statement>");
    r = method_call_chain(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // factor (mul_op factor)*
  public static boolean mul_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mul_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MUL_EXPR, "<mul expr>");
    r = factor(b, l + 1);
    r = r && mul_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (mul_op factor)*
  private static boolean mul_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mul_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!mul_expr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "mul_expr_1", c)) break;
    }
    return true;
  }

  // mul_op factor
  private static boolean mul_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mul_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = mul_op(b, l + 1);
    r = r && factor(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "*" | "/" | "%"
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
  public static boolean par_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "par_expression")) return false;
    if (!nextTokenIs(b, PAREN_BEGIN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PAREN_BEGIN);
    r = r && full_expression(b, l + 1);
    r = r && consumeToken(b, PAREN_END);
    exit_section_(b, m, PAR_EXPRESSION, r);
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
  // expression rel_check_op expression
  public static boolean rel_check_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rel_check_expr")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, REL_CHECK_EXPR, "<rel check expr>");
    r = expression(b, l + 1);
    r = r && rel_check_op(b, l + 1);
    p = r; // pin = 2
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // "<" | ">" | "<=" | ">=" | equality_op
  public static boolean rel_check_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rel_check_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REL_CHECK_OP, "<rel check op>");
    r = consumeToken(b, COMP_OP4);
    if (!r) r = consumeToken(b, COMP_OP5);
    if (!r) r = consumeToken(b, COMP_OP2);
    if (!r) r = consumeToken(b, COMP_OP3);
    if (!r) r = equality_op(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "foreach" id_list ":" expression newline for_statement_list "endforeach" newline
  public static boolean repetitive_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "repetitive_statement")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, REPETITIVE_STATEMENT, "<repetitive statement>");
    r = consumeToken(b, LANG_TOKEN_FOREACH);
    p = r; // pin = 1
    r = r && report_error_(b, id_list(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LANG_TOKEN_COLON)) && r;
    r = p && report_error_(b, expression(b, l + 1)) && r;
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
  // bool_literal | rel_check_expr | expression | "not" simple_bool_expression
  public static boolean simple_bool_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_bool_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SIMPLE_BOOL_EXPRESSION, "<simple bool expression>");
    r = bool_literal(b, l + 1);
    if (!r) r = rel_check_expr(b, l + 1);
    if (!r) r = expression(b, l + 1);
    if (!r) r = simple_bool_expression_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "not" simple_bool_expression
  private static boolean simple_bool_expression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_bool_expression_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LANG_TOKEN_NOT);
    r = r && simple_bool_expression(b, l + 1);
    exit_section_(b, m, null, r);
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
  // subscript_root index_expr+
  public static boolean subscript_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subscript_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SUBSCRIPT_EXPR, "<subscript expr>");
    r = subscript_root(b, l + 1);
    r = r && subscript_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // index_expr+
  private static boolean subscript_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subscript_expr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = index_expr(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!index_expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "subscript_expr_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // method_call_chain | id
  public static boolean subscript_root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subscript_root")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SUBSCRIPT_ROOT, "<subscript root>");
    r = method_call_chain(b, l + 1);
    if (!r) r = consumeToken(b, ID);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // full_bool_expression "?" full_expression ":" full_expression
  public static boolean ternary_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ternary_expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TERNARY_EXPRESSION, "<ternary expression>");
    r = full_bool_expression(b, l + 1);
    r = r && consumeToken(b, LANG_TOKEN_QMARK);
    r = r && full_expression(b, l + 1);
    r = r && consumeToken(b, LANG_TOKEN_COLON);
    r = r && full_expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "+" | "-"
  public static boolean unary_num_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_num_op")) return false;
    if (!nextTokenIs(b, "<unary num op>", MINUS_OP, PLUS_OP)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_NUM_OP, "<unary num op>");
    r = consumeToken(b, PLUS_OP);
    if (!r) r = consumeToken(b, MINUS_OP);
    exit_section_(b, l, m, r, false, null);
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
