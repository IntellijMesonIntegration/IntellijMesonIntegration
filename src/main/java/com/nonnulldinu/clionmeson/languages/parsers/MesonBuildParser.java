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
  // "[" [expression ("," expression)*] "]"
  public static boolean array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array")) return false;
    if (!nextTokenIs(b, BRACE_BEGIN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_BEGIN);
    r = r && array_1(b, l + 1);
    r = r && consumeToken(b, BRACE_END);
    exit_section_(b, m, ARRAY, r);
    return r;
  }

  // [expression ("," expression)*]
  private static boolean array_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1")) return false;
    array_1_0(b, l + 1);
    return true;
  }

  // expression ("," expression)*
  private static boolean array_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && array_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ("," expression)*
  private static boolean array_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!array_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_1_0_1", c)) break;
    }
    return true;
  }

  // "," expression
  private static boolean array_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // id_expression atrop expression
  public static boolean assignment_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_statement")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = id_expression(b, l + 1);
    r = r && atrop(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, ASSIGNMENT_STATEMENT, r);
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
  // (newline | statement)*
  static boolean build_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "build_definition")) return false;
    while (true) {
      int c = current_position_(b);
      if (!build_definition_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "build_definition", c)) break;
    }
    return true;
  }

  // newline | statement
  private static boolean build_definition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "build_definition_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEWLINE);
    if (!r) r = statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // decnum
  static boolean dec_literal(PsiBuilder b, int l) {
    return consumeToken(b, DECNUM);
  }

  /* ********************************************************** */
  // "{" [keyword_elem ("," keyword_elem)*] "}"
  public static boolean dict(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict")) return false;
    if (!nextTokenIs(b, CURLY_BRACE_BEGIN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CURLY_BRACE_BEGIN);
    r = r && dict_1(b, l + 1);
    r = r && consumeToken(b, CURLY_BRACE_END);
    exit_section_(b, m, DICT, r);
    return r;
  }

  // [keyword_elem ("," keyword_elem)*]
  private static boolean dict_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_1")) return false;
    dict_1_0(b, l + 1);
    return true;
  }

  // keyword_elem ("," keyword_elem)*
  private static boolean dict_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = keyword_elem(b, l + 1);
    r = r && dict_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ("," keyword_elem)*
  private static boolean dict_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!dict_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "dict_1_0_1", c)) break;
    }
    return true;
  }

  // "," keyword_elem
  private static boolean dict_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dict_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && keyword_elem(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // dict | array | add_expr | id_expression | string_literal | num_literal | par_expression
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = dict(b, l + 1);
    if (!r) r = array(b, l + 1);
    if (!r) r = add_expr(b, l + 1);
    if (!r) r = id_expression(b, l + 1);
    if (!r) r = string_literal(b, l + 1);
    if (!r) r = num_literal(b, l + 1);
    if (!r) r = par_expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // dict | array | par_expression | id_expression | string_literal | num_literal
  public static boolean factor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "factor")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FACTOR, "<factor>");
    r = dict(b, l + 1);
    if (!r) r = array(b, l + 1);
    if (!r) r = par_expression(b, l + 1);
    if (!r) r = id_expression(b, l + 1);
    if (!r) r = string_literal(b, l + 1);
    if (!r) r = num_literal(b, l + 1);
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
  // func_arg ("," func_arg)*
  public static boolean func_args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_args")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNC_ARGS, "<func args>");
    r = func_arg(b, l + 1);
    r = r && func_args_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ("," func_arg)*
  private static boolean func_args_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_args_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!func_args_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "func_args_1", c)) break;
    }
    return true;
  }

  // "," func_arg
  private static boolean func_args_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_args_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && func_arg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // func_name "(" [func_args] ")"
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

  // [func_args]
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
  static boolean hex_literal(PsiBuilder b, int l) {
    return consumeToken(b, HEXNUM);
  }

  /* ********************************************************** */
  // lvalue
  public static boolean id_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id_expression")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = lvalue(b, l + 1);
    exit_section_(b, m, ID_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // id ":" expression
  public static boolean keyword_elem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyword_elem")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, LANG_TOKEN_COLON);
    r = r && expression(b, l + 1);
    exit_section_(b, m, KEYWORD_ELEM, r);
    return r;
  }

  /* ********************************************************** */
  // subscript_expr | id
  public static boolean lvalue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lvalue")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = subscript_expr(b, l + 1);
    if (!r) r = consumeToken(b, ID);
    exit_section_(b, m, LVALUE, r);
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
  // octnum
  static boolean oct_literal(PsiBuilder b, int l) {
    return consumeToken(b, OCTNUM);
  }

  /* ********************************************************** */
  // "(" expression ")"
  public static boolean par_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "par_expression")) return false;
    if (!nextTokenIs(b, PAREN_BEGIN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PAREN_BEGIN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, PAREN_END);
    exit_section_(b, m, PAR_EXPRESSION, r);
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
  // !<<eof>> (func_call_statement | assignment_statement) (newline)
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = statement_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, statement_1(b, l + 1));
    r = p && consumeToken(b, NEWLINE) && r;
    exit_section_(b, l, m, r, p, statement_recover_parser_);
    return r || p;
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

  // func_call_statement | assignment_statement
  private static boolean statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1")) return false;
    boolean r;
    r = func_call_statement(b, l + 1);
    if (!r) r = assignment_statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // !(newline | func_call_statement | assignment_statement)
  static boolean statement_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !statement_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // newline | func_call_statement | assignment_statement
  private static boolean statement_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_recover_0")) return false;
    boolean r;
    r = consumeToken(b, NEWLINE);
    if (!r) r = func_call_statement(b, l + 1);
    if (!r) r = assignment_statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // strsimple | strmultiline
  static boolean string_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal")) return false;
    if (!nextTokenIs(b, "", STRMULTILINE, STRSIMPLE)) return false;
    boolean r;
    r = consumeToken(b, STRSIMPLE);
    if (!r) r = consumeToken(b, STRMULTILINE);
    return r;
  }

  /* ********************************************************** */
  // subscript_root ("[" expression "]")+
  public static boolean subscript_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subscript_expr")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = subscript_root(b, l + 1);
    r = r && subscript_expr_1(b, l + 1);
    exit_section_(b, m, SUBSCRIPT_EXPR, r);
    return r;
  }

  // ("[" expression "]")+
  private static boolean subscript_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subscript_expr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = subscript_expr_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!subscript_expr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "subscript_expr_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // "[" expression "]"
  private static boolean subscript_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subscript_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACE_BEGIN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, BRACE_END);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // id
  public static boolean subscript_root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subscript_root")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, SUBSCRIPT_ROOT, r);
    return r;
  }

  static final Parser statement_recover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return statement_recover(b, l + 1);
    }
  };
}
