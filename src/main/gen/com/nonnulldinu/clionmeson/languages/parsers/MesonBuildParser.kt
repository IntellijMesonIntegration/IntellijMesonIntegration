// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.languages.parsers

import com.intellij.lang.ASTNode
import com.intellij.lang.LightPsiParser
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.lang.parser.GeneratedParserUtilBase
import com.intellij.psi.tree.IElementType
import com.nonnulldinu.clionmeson.build.psi.MesonBuildTypes

class MesonBuildParser : PsiParser, LightPsiParser {
    override fun parse(t: IElementType, b: PsiBuilder): ASTNode {
        parseLight(t, b)
        return b.treeBuilt
    }

    override fun parseLight(t: IElementType, b: PsiBuilder) {
        var b: PsiBuilder? = b
        val r: Boolean
        b = GeneratedParserUtilBase.adapt_builder_(t, b, this, null)
        val m = GeneratedParserUtilBase.enter_section_(b, 0, GeneratedParserUtilBase._COLLAPSE_, null)
        r = parse_root_(t, b)
        GeneratedParserUtilBase.exit_section_(b, 0, m, t, r, true, GeneratedParserUtilBase.TRUE_CONDITION)
    }

    protected fun parse_root_(t: IElementType?, b: PsiBuilder?): Boolean {
        return parse_root_(t, b, 0)
    }

    companion object {
        fun parse_root_(t: IElementType?, b: PsiBuilder?, l: Int): Boolean {
            return build_definition(b, l + 1)
        }

        /* ********************************************************** */ // mul_expr (newline? add_op newline? mul_expr)*
        fun add_expr(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "add_expr")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.ADD_EXPR, "<add expr>")
            r = mul_expr(b, l + 1)
            r = r && add_expr_1(b!!, l + 1)
            GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null)
            return r
        }

        // (newline? add_op newline? mul_expr)*
        private fun add_expr_1(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "add_expr_1")) return false
            while (true) {
                val c = GeneratedParserUtilBase.current_position_(b)
                if (!add_expr_1_0(b, l + 1)) break
                if (!GeneratedParserUtilBase.empty_element_parsed_guard_(b, "add_expr_1", c)) break
            }
            return true
        }

        // newline? add_op newline? mul_expr
        private fun add_expr_1_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "add_expr_1_0")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = add_expr_1_0_0(b, l + 1)
            r = r && add_op(b, l + 1)
            r = r && add_expr_1_0_2(b, l + 1)
            r = r && mul_expr(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        // newline?
        private fun add_expr_1_0_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "add_expr_1_0_0")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        // newline?
        private fun add_expr_1_0_2(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "add_expr_1_0_2")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        /* ********************************************************** */ // '+' | '-'
        fun add_op(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "add_op")) return false
            if (!GeneratedParserUtilBase.nextTokenIs(b, "", MesonBuildTypes.Companion.MINUS_OP, MesonBuildTypes.Companion.PLUS_OP)) return false
            var r: Boolean
            r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.PLUS_OP)
            if (!r) r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.MINUS_OP)
            return r
        }

        /* ********************************************************** */ // "[" [newline? full_expression (newline? "," newline? full_expression)*] (","? newline?) "]"
        fun array_literal(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "array_literal")) return false
            if (!GeneratedParserUtilBase.nextTokenIs(b, MesonBuildTypes.Companion.BRACE_BEGIN)) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.BRACE_BEGIN)
            r = r && array_literal_1(b!!, l + 1)
            r = r && array_literal_2(b!!, l + 1)
            r = r && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.BRACE_END)
            GeneratedParserUtilBase.exit_section_(b, m, MesonBuildTypes.Companion.ARRAY_LITERAL, r)
            return r
        }

        // [newline? full_expression (newline? "," newline? full_expression)*]
        private fun array_literal_1(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "array_literal_1")) return false
            array_literal_1_0(b, l + 1)
            return true
        }

        // newline? full_expression (newline? "," newline? full_expression)*
        private fun array_literal_1_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "array_literal_1_0")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = array_literal_1_0_0(b, l + 1)
            r = r && full_expression(b, l + 1)
            r = r && array_literal_1_0_2(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        // newline?
        private fun array_literal_1_0_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "array_literal_1_0_0")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        // (newline? "," newline? full_expression)*
        private fun array_literal_1_0_2(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "array_literal_1_0_2")) return false
            while (true) {
                val c = GeneratedParserUtilBase.current_position_(b)
                if (!array_literal_1_0_2_0(b, l + 1)) break
                if (!GeneratedParserUtilBase.empty_element_parsed_guard_(b, "array_literal_1_0_2", c)) break
            }
            return true
        }

        // newline? "," newline? full_expression
        private fun array_literal_1_0_2_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "array_literal_1_0_2_0")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = array_literal_1_0_2_0_0(b, l + 1)
            r = r && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.COMMA)
            r = r && array_literal_1_0_2_0_2(b, l + 1)
            r = r && full_expression(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        // newline?
        private fun array_literal_1_0_2_0_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "array_literal_1_0_2_0_0")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        // newline?
        private fun array_literal_1_0_2_0_2(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "array_literal_1_0_2_0_2")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        // ","? newline?
        private fun array_literal_2(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "array_literal_2")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = array_literal_2_0(b, l + 1)
            r = r && array_literal_2_1(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        // ","?
        private fun array_literal_2_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "array_literal_2_0")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.COMMA)
            return true
        }

        // newline?
        private fun array_literal_2_1(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "array_literal_2_1")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        /* ********************************************************** */ // id_expression atrop full_expression newline
        fun assignment_statement(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "assignment_statement")) return false
            if (!GeneratedParserUtilBase.nextTokenIs(b, MesonBuildTypes.Companion.ID)) return false
            var r: Boolean
            val p: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.ASSIGNMENT_STATEMENT, null)
            r = id_expression(b, l + 1)
            r = r && atrop(b, l + 1)
            p = r // pin = 2
            r = r && GeneratedParserUtilBase.report_error_(b, full_expression(b, l + 1))
            r = p && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE) && r
            GeneratedParserUtilBase.exit_section_(b, l, m, r, p, null)
            return r || p
        }

        /* ********************************************************** */ // subscript_method_chain_expr | func_call_expression | par_expression | id | literal
        fun atom(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "atom")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.ATOM, "<atom>")
            r = subscript_method_chain_expr(b, l + 1)
            if (!r) r = func_call_expression(b, l + 1)
            if (!r) r = par_expression(b, l + 1)
            if (!r) r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.ID)
            if (!r) r = literal(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null)
            return r
        }

        /* ********************************************************** */ // "=" | "+=" | "-=" | "/=" | "*=" | "%="
        fun atrop(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "atrop")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.ATROP, "<atrop>")
            r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.ATR_OP)
            if (!r) r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.COMP_ATR_OP4)
            if (!r) r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.COMP_ATR_OP5)
            if (!r) r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.COMP_ATR_OP2)
            if (!r) r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.COMP_ATR_OP1)
            if (!r) r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.COMP_ATR_OP3)
            GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null)
            return r
        }

        /* ********************************************************** */ // binnum
        fun bin_literal(b: PsiBuilder?, l: Int): Boolean {
            return GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.BINNUM)
        }

        /* ********************************************************** */ // bool_literal | relation_check | add_expr | par_expression | "not" bool_atom
        fun bool_atom(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "bool_atom")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = bool_literal(b, l + 1)
            if (!r) r = relation_check(b, l + 1)
            if (!r) r = add_expr(b, l + 1)
            if (!r) r = par_expression(b, l + 1)
            if (!r) r = bool_atom_4(b!!, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        // "not" bool_atom
        private fun bool_atom_4(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "bool_atom_4")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.LANG_TOKEN_NOT)
            r = r && bool_atom(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        /* ********************************************************** */ // "true" | "false"
        fun bool_literal(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "bool_literal")) return false
            if (!GeneratedParserUtilBase.nextTokenIs(b, "", MesonBuildTypes.Companion.BOOL_LITERAL_FALSE, MesonBuildTypes.Companion.BOOL_LITERAL_TRUE)) return false
            var r: Boolean
            r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.BOOL_LITERAL_TRUE)
            if (!r) r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.BOOL_LITERAL_FALSE)
            return r
        }

        /* ********************************************************** */ // statement_list
        fun build_definition(b: PsiBuilder?, l: Int): Boolean {
            return statement_list(b, l + 1)
        }

        /* ********************************************************** */ // bool_atom (newline? "and" newline? bool_atom)*
        fun conditional_and_expression(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "conditional_and_expression")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.CONDITIONAL_AND_EXPRESSION, "<conditional and expression>")
            r = bool_atom(b, l + 1)
            r = r && conditional_and_expression_1(b!!, l + 1)
            GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null)
            return r
        }

        // (newline? "and" newline? bool_atom)*
        private fun conditional_and_expression_1(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "conditional_and_expression_1")) return false
            while (true) {
                val c = GeneratedParserUtilBase.current_position_(b)
                if (!conditional_and_expression_1_0(b, l + 1)) break
                if (!GeneratedParserUtilBase.empty_element_parsed_guard_(b, "conditional_and_expression_1", c)) break
            }
            return true
        }

        // newline? "and" newline? bool_atom
        private fun conditional_and_expression_1_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "conditional_and_expression_1_0")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = conditional_and_expression_1_0_0(b, l + 1)
            r = r && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.LANG_TOKEN_AND)
            r = r && conditional_and_expression_1_0_2(b, l + 1)
            r = r && bool_atom(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        // newline?
        private fun conditional_and_expression_1_0_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "conditional_and_expression_1_0_0")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        // newline?
        private fun conditional_and_expression_1_0_2(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "conditional_and_expression_1_0_2")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        /* ********************************************************** */ // conditional_and_expression (newline? "or" newline? conditional_and_expression)*
        fun conditional_or_expression(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "conditional_or_expression")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.CONDITIONAL_OR_EXPRESSION, "<conditional or expression>")
            r = conditional_and_expression(b, l + 1)
            r = r && conditional_or_expression_1(b!!, l + 1)
            GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null)
            return r
        }

        // (newline? "or" newline? conditional_and_expression)*
        private fun conditional_or_expression_1(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "conditional_or_expression_1")) return false
            while (true) {
                val c = GeneratedParserUtilBase.current_position_(b)
                if (!conditional_or_expression_1_0(b, l + 1)) break
                if (!GeneratedParserUtilBase.empty_element_parsed_guard_(b, "conditional_or_expression_1", c)) break
            }
            return true
        }

        // newline? "or" newline? conditional_and_expression
        private fun conditional_or_expression_1_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "conditional_or_expression_1_0")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = conditional_or_expression_1_0_0(b, l + 1)
            r = r && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.LANG_TOKEN_OR)
            r = r && conditional_or_expression_1_0_2(b, l + 1)
            r = r && conditional_and_expression(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        // newline?
        private fun conditional_or_expression_1_0_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "conditional_or_expression_1_0_0")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        // newline?
        private fun conditional_or_expression_1_0_2(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "conditional_or_expression_1_0_2")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        /* ********************************************************** */ // ("continue" | "break") newline
        fun control_statement(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "control_statement")) return false
            if (!GeneratedParserUtilBase.nextTokenIs(b, "<control statement>", MesonBuildTypes.Companion.LANG_TOKEN_JUMP_BREAK, MesonBuildTypes.Companion.LANG_TOKEN_JUMP_CONTINUE)) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.CONTROL_STATEMENT, "<control statement>")
            r = control_statement_0(b!!, l + 1)
            r = r && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null)
            return r
        }

        // "continue" | "break"
        private fun control_statement_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "control_statement_0")) return false
            var r: Boolean
            r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.LANG_TOKEN_JUMP_CONTINUE)
            if (!r) r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.LANG_TOKEN_JUMP_BREAK)
            return r
        }

        /* ********************************************************** */ // decnum
        fun dec_literal(b: PsiBuilder?, l: Int): Boolean {
            return GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.DECNUM)
        }

        /* ********************************************************** */ // "{" [newline? keyword_elem (newline? "," newline? keyword_elem)*] (","? newline?) "}"
        fun dict_literal(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "dict_literal")) return false
            if (!GeneratedParserUtilBase.nextTokenIs(b, MesonBuildTypes.Companion.CURLY_BRACE_BEGIN)) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.CURLY_BRACE_BEGIN)
            r = r && dict_literal_1(b!!, l + 1)
            r = r && dict_literal_2(b!!, l + 1)
            r = r && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.CURLY_BRACE_END)
            GeneratedParserUtilBase.exit_section_(b, m, MesonBuildTypes.Companion.DICT_LITERAL, r)
            return r
        }

        // [newline? keyword_elem (newline? "," newline? keyword_elem)*]
        private fun dict_literal_1(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "dict_literal_1")) return false
            dict_literal_1_0(b, l + 1)
            return true
        }

        // newline? keyword_elem (newline? "," newline? keyword_elem)*
        private fun dict_literal_1_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "dict_literal_1_0")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = dict_literal_1_0_0(b, l + 1)
            r = r && keyword_elem(b, l + 1)
            r = r && dict_literal_1_0_2(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        // newline?
        private fun dict_literal_1_0_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "dict_literal_1_0_0")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        // (newline? "," newline? keyword_elem)*
        private fun dict_literal_1_0_2(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "dict_literal_1_0_2")) return false
            while (true) {
                val c = GeneratedParserUtilBase.current_position_(b)
                if (!dict_literal_1_0_2_0(b, l + 1)) break
                if (!GeneratedParserUtilBase.empty_element_parsed_guard_(b, "dict_literal_1_0_2", c)) break
            }
            return true
        }

        // newline? "," newline? keyword_elem
        private fun dict_literal_1_0_2_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "dict_literal_1_0_2_0")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = dict_literal_1_0_2_0_0(b, l + 1)
            r = r && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.COMMA)
            r = r && dict_literal_1_0_2_0_2(b, l + 1)
            r = r && keyword_elem(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        // newline?
        private fun dict_literal_1_0_2_0_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "dict_literal_1_0_2_0_0")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        // newline?
        private fun dict_literal_1_0_2_0_2(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "dict_literal_1_0_2_0_2")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        // ","? newline?
        private fun dict_literal_2(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "dict_literal_2")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = dict_literal_2_0(b, l + 1)
            r = r && dict_literal_2_1(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        // ","?
        private fun dict_literal_2_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "dict_literal_2_0")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.COMMA)
            return true
        }

        // newline?
        private fun dict_literal_2_1(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "dict_literal_2_1")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        /* ********************************************************** */ // '==' | '!='
        fun eq_op(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "eq_op")) return false
            if (!GeneratedParserUtilBase.nextTokenIs(b, "", MesonBuildTypes.Companion.COMP_OP1, MesonBuildTypes.Companion.COMP_OP6)) return false
            var r: Boolean
            r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.COMP_OP1)
            if (!r) r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.COMP_OP6)
            return r
        }

        /* ********************************************************** */ // !<<eof>> (method_call_statement | func_call_statement | assignment_statement | selection_statement_for | repetitive_statement | control_statement)
        fun for_statement(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "for_statement")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.FOR_STATEMENT, "<for statement>")
            r = for_statement_0(b!!, l + 1)
            r = r && for_statement_1(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, l, m, r, false, statement_for_recover_parser_)
            return r
        }

        // !<<eof>>
        private fun for_statement_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "for_statement_0")) return false
            val r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NOT_)
            r = !GeneratedParserUtilBase.eof(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null)
            return r
        }

        // method_call_statement | func_call_statement | assignment_statement | selection_statement_for | repetitive_statement | control_statement
        private fun for_statement_1(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "for_statement_1")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = method_call_statement(b, l + 1)
            if (!r) r = func_call_statement(b, l + 1)
            if (!r) r = assignment_statement(b, l + 1)
            if (!r) r = selection_statement_for(b, l + 1)
            if (!r) r = repetitive_statement(b, l + 1)
            if (!r) r = control_statement(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        /* ********************************************************** */ // (for_statement | newline)*
        fun for_statement_list(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "for_statement_list")) return false
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.FOR_STATEMENT_LIST, "<for statement list>")
            while (true) {
                val c = GeneratedParserUtilBase.current_position_(b)
                if (!for_statement_list_0(b!!, l + 1)) break
                if (!GeneratedParserUtilBase.empty_element_parsed_guard_(b, "for_statement_list", c)) break
            }
            GeneratedParserUtilBase.exit_section_(b, l, m, true, false, null)
            return true
        }

        // for_statement | newline
        private fun for_statement_list_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "for_statement_list_0")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = for_statement(b, l + 1)
            if (!r) r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        /* ********************************************************** */ // full_expression
        fun full_bool_expression(b: PsiBuilder?, l: Int): Boolean {
            return full_expression(b, l + 1)
        }

        /* ********************************************************** */ // ternary_expression | conditional_or_expression | add_expr
        fun full_expression(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "full_expression")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.FULL_EXPRESSION, "<full expression>")
            r = ternary_expression(b, l + 1)
            if (!r) r = conditional_or_expression(b, l + 1)
            if (!r) r = add_expr(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null)
            return r
        }

        /* ********************************************************** */ // keyword_elem | positional_func_arg
        fun func_arg(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "func_arg")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.FUNC_ARG, "<func arg>")
            r = keyword_elem(b, l + 1)
            if (!r) r = positional_func_arg(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null)
            return r
        }

        /* ********************************************************** */ // newline? func_arg (newline? "," newline? func_arg)*(","? newline?)
        fun func_args(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "func_args")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.FUNC_ARGS, "<func args>")
            r = func_args_0(b!!, l + 1)
            r = r && func_arg(b, l + 1)
            r = r && func_args_2(b, l + 1)
            r = r && func_args_3(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null)
            return r
        }

        // newline?
        private fun func_args_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "func_args_0")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        // (newline? "," newline? func_arg)*
        private fun func_args_2(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "func_args_2")) return false
            while (true) {
                val c = GeneratedParserUtilBase.current_position_(b)
                if (!func_args_2_0(b, l + 1)) break
                if (!GeneratedParserUtilBase.empty_element_parsed_guard_(b, "func_args_2", c)) break
            }
            return true
        }

        // newline? "," newline? func_arg
        private fun func_args_2_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "func_args_2_0")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = func_args_2_0_0(b, l + 1)
            r = r && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.COMMA)
            r = r && func_args_2_0_2(b, l + 1)
            r = r && func_arg(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        // newline?
        private fun func_args_2_0_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "func_args_2_0_0")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        // newline?
        private fun func_args_2_0_2(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "func_args_2_0_2")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        // ","? newline?
        private fun func_args_3(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "func_args_3")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = func_args_3_0(b, l + 1)
            r = r && func_args_3_1(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        // ","?
        private fun func_args_3_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "func_args_3_0")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.COMMA)
            return true
        }

        // newline?
        private fun func_args_3_1(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "func_args_3_1")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        /* ********************************************************** */ // func_name "(" [func_args] ")"
        fun func_call_expression(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "func_call_expression")) return false
            if (!GeneratedParserUtilBase.nextTokenIs(b, MesonBuildTypes.Companion.ID)) return false
            var r: Boolean
            val p: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.FUNC_CALL_EXPRESSION, null)
            r = func_name(b, l + 1)
            r = r && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.PAREN_BEGIN)
            p = r // pin = 2
            r = r && GeneratedParserUtilBase.report_error_(b, func_call_expression_2(b!!, l + 1))
            r = p && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.PAREN_END) && r
            GeneratedParserUtilBase.exit_section_(b, l, m, r, p, null)
            return r || p
        }

        // [func_args]
        private fun func_call_expression_2(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "func_call_expression_2")) return false
            func_args(b, l + 1)
            return true
        }

        /* ********************************************************** */ // func_call_expression newline
        fun func_call_statement(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "func_call_statement")) return false
            if (!GeneratedParserUtilBase.nextTokenIs(b, MesonBuildTypes.Companion.ID)) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = func_call_expression(b, l + 1)
            r = r && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            GeneratedParserUtilBase.exit_section_(b, m, MesonBuildTypes.Companion.FUNC_CALL_STATEMENT, r)
            return r
        }

        /* ********************************************************** */ // id_expression
        fun func_name(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "func_name")) return false
            if (!GeneratedParserUtilBase.nextTokenIs(b, MesonBuildTypes.Companion.ID)) return false
            val r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = id_expression(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, MesonBuildTypes.Companion.FUNC_NAME, r)
            return r
        }

        /* ********************************************************** */ // hexnum
        fun hex_literal(b: PsiBuilder?, l: Int): Boolean {
            return GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.HEXNUM)
        }

        /* ********************************************************** */ // id
        fun id_expression(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "id_expression")) return false
            if (!GeneratedParserUtilBase.nextTokenIs(b, MesonBuildTypes.Companion.ID)) return false
            val r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.ID)
            GeneratedParserUtilBase.exit_section_(b, m, MesonBuildTypes.Companion.ID_EXPRESSION, r)
            return r
        }

        /* ********************************************************** */ // id (newline? "," newline? id)*
        fun id_list(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "id_list")) return false
            if (!GeneratedParserUtilBase.nextTokenIs(b, MesonBuildTypes.Companion.ID)) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.ID)
            r = r && id_list_1(b!!, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, MesonBuildTypes.Companion.ID_LIST, r)
            return r
        }

        // (newline? "," newline? id)*
        private fun id_list_1(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "id_list_1")) return false
            while (true) {
                val c = GeneratedParserUtilBase.current_position_(b)
                if (!id_list_1_0(b, l + 1)) break
                if (!GeneratedParserUtilBase.empty_element_parsed_guard_(b, "id_list_1", c)) break
            }
            return true
        }

        // newline? "," newline? id
        private fun id_list_1_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "id_list_1_0")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = id_list_1_0_0(b, l + 1)
            r = r && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.COMMA)
            r = r && id_list_1_0_2(b, l + 1)
            r = r && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.ID)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        // newline?
        private fun id_list_1_0_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "id_list_1_0_0")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        // newline?
        private fun id_list_1_0_2(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "id_list_1_0_2")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        /* ********************************************************** */ // newline? "[" newline? add_expr newline?"]"
        fun index_expr(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "index_expr")) return false
            if (!GeneratedParserUtilBase.nextTokenIs(b, "", MesonBuildTypes.Companion.BRACE_BEGIN, MesonBuildTypes.Companion.NEWLINE)) return false
            var r: Boolean
            val p: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_)
            r = index_expr_0(b!!, l + 1)
            r = r && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.BRACE_BEGIN)
            p = r // pin = 2
            r = r && GeneratedParserUtilBase.report_error_(b, index_expr_2(b, l + 1))
            r = p && GeneratedParserUtilBase.report_error_(b, add_expr(b, l + 1)) && r
            r = p && GeneratedParserUtilBase.report_error_(b, index_expr_4(b, l + 1)) && r
            r = p && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.BRACE_END) && r
            GeneratedParserUtilBase.exit_section_(b, l, m, r, p, null)
            return r || p
        }

        // newline?
        private fun index_expr_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "index_expr_0")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        // newline?
        private fun index_expr_2(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "index_expr_2")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        // newline?
        private fun index_expr_4(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "index_expr_4")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        /* ********************************************************** */ // id ":" full_expression
        fun keyword_elem(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "keyword_elem")) return false
            if (!GeneratedParserUtilBase.nextTokenIs(b, MesonBuildTypes.Companion.ID)) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = GeneratedParserUtilBase.consumeTokens(b, 0, MesonBuildTypes.Companion.ID, MesonBuildTypes.Companion.LANG_TOKEN_COLON)
            r = r && full_expression(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, MesonBuildTypes.Companion.KEYWORD_ELEM, r)
            return r
        }

        /* ********************************************************** */ // dict_literal | array_literal | num_literal | string_literal | num_literal_unary | bool_literal
        fun literal(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "literal")) return false
            var r: Boolean
            r = dict_literal(b, l + 1)
            if (!r) r = array_literal(b, l + 1)
            if (!r) r = num_literal(b, l + 1)
            if (!r) r = string_literal(b, l + 1)
            if (!r) r = num_literal_unary(b, l + 1)
            if (!r) r = bool_literal(b, l + 1)
            return r
        }

        /* ********************************************************** */ // func_call_expression | id | literal
        fun method_call_expression_base(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "method_call_expression_base")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.METHOD_CALL_EXPRESSION_BASE, "<method call expression base>")
            r = func_call_expression(b, l + 1)
            if (!r) r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.ID)
            if (!r) r = literal(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null)
            return r
        }

        /* ********************************************************** */ // subscript_method_chain_expr newline
        fun method_call_statement(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "method_call_statement")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.METHOD_CALL_STATEMENT, "<method call statement>")
            r = subscript_method_chain_expr(b, l + 1)
            r = r && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null)
            return r
        }

        /* ********************************************************** */ // atom (newline? mul_op newline? atom)*
        fun mul_expr(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "mul_expr")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.MUL_EXPR, "<mul expr>")
            r = atom(b, l + 1)
            r = r && mul_expr_1(b!!, l + 1)
            GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null)
            return r
        }

        // (newline? mul_op newline? atom)*
        private fun mul_expr_1(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "mul_expr_1")) return false
            while (true) {
                val c = GeneratedParserUtilBase.current_position_(b)
                if (!mul_expr_1_0(b, l + 1)) break
                if (!GeneratedParserUtilBase.empty_element_parsed_guard_(b, "mul_expr_1", c)) break
            }
            return true
        }

        // newline? mul_op newline? atom
        private fun mul_expr_1_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "mul_expr_1_0")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = mul_expr_1_0_0(b, l + 1)
            r = r && mul_op(b, l + 1)
            r = r && mul_expr_1_0_2(b, l + 1)
            r = r && atom(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        // newline?
        private fun mul_expr_1_0_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "mul_expr_1_0_0")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        // newline?
        private fun mul_expr_1_0_2(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "mul_expr_1_0_2")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        /* ********************************************************** */ // '*' | '/' | '%'
        fun mul_op(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "mul_op")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.MUL_OP, "<mul op>")
            r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.MULT_OP)
            if (!r) r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.DIV_OP)
            if (!r) r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.MOD_OP)
            GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null)
            return r
        }

        /* ********************************************************** */ // bin_literal | oct_literal | dec_literal | hex_literal
        fun num_literal(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "num_literal")) return false
            var r: Boolean
            r = bin_literal(b, l + 1)
            if (!r) r = oct_literal(b, l + 1)
            if (!r) r = dec_literal(b, l + 1)
            if (!r) r = hex_literal(b, l + 1)
            return r
        }

        /* ********************************************************** */ // unary_num_op num_literal
        fun num_literal_unary(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "num_literal_unary")) return false
            if (!GeneratedParserUtilBase.nextTokenIs(b, "<num literal unary>", MesonBuildTypes.Companion.MINUS_OP, MesonBuildTypes.Companion.PLUS_OP)) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.NUM_LITERAL_UNARY, "<num literal unary>")
            r = unary_num_op(b, l + 1)
            r = r && num_literal(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null)
            return r
        }

        /* ********************************************************** */ // octnum
        fun oct_literal(b: PsiBuilder?, l: Int): Boolean {
            return GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.OCTNUM)
        }

        /* ********************************************************** */ // "(" newline? full_expression newline? ")"
        fun par_expression(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "par_expression")) return false
            if (!GeneratedParserUtilBase.nextTokenIs(b, MesonBuildTypes.Companion.PAREN_BEGIN)) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.PAREN_BEGIN)
            r = r && par_expression_1(b!!, l + 1)
            r = r && full_expression(b, l + 1)
            r = r && par_expression_3(b!!, l + 1)
            r = r && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.PAREN_END)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        // newline?
        private fun par_expression_1(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "par_expression_1")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        // newline?
        private fun par_expression_3(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "par_expression_3")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        /* ********************************************************** */ // full_expression
        fun positional_func_arg(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "positional_func_arg")) return false
            val r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.POSITIONAL_FUNC_ARG, "<positional func arg>")
            r = full_expression(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null)
            return r
        }

        /* ********************************************************** */ // add_expr newline? relation_check_op newline? add_expr
        fun relation_check(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "relation_check")) return false
            var r: Boolean
            val p: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.RELATION_CHECK, "<relation check>")
            r = add_expr(b, l + 1)
            r = r && relation_check_1(b!!, l + 1)
            r = r && relation_check_op(b, l + 1)
            p = r // pin = 3
            r = r && GeneratedParserUtilBase.report_error_(b, relation_check_3(b!!, l + 1))
            r = p && add_expr(b, l + 1) && r
            GeneratedParserUtilBase.exit_section_(b, l, m, r, p, null)
            return r || p
        }

        // newline?
        private fun relation_check_1(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "relation_check_1")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        // newline?
        private fun relation_check_3(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "relation_check_3")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        /* ********************************************************** */ // '>=' | '>' | '<=' | '<' | eq_op | "in" | "not" "in"
        fun relation_check_op(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "relation_check_op")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.RELATION_CHECK_OP, "<relation check op>")
            r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.COMP_OP3)
            if (!r) r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.COMP_OP5)
            if (!r) r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.COMP_OP2)
            if (!r) r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.COMP_OP4)
            if (!r) r = eq_op(b, l + 1)
            if (!r) r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.IN_OP)
            if (!r) r = GeneratedParserUtilBase.parseTokens(b, 0, MesonBuildTypes.Companion.LANG_TOKEN_NOT, MesonBuildTypes.Companion.IN_OP)
            GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null)
            return r
        }

        /* ********************************************************** */ // "foreach" id_list ":" full_expression newline for_statement_list "endforeach" newline
        fun repetitive_statement(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "repetitive_statement")) return false
            var r: Boolean
            val p: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.REPETITIVE_STATEMENT, "<repetitive statement>")
            r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.LANG_TOKEN_FOREACH)
            p = r // pin = 1
            r = r && GeneratedParserUtilBase.report_error_(b, id_list(b, l + 1))
            r = p && GeneratedParserUtilBase.report_error_(b, GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.LANG_TOKEN_COLON)) && r
            r = p && GeneratedParserUtilBase.report_error_(b, full_expression(b, l + 1)) && r
            r = p && GeneratedParserUtilBase.report_error_(b, GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)) && r
            r = p && GeneratedParserUtilBase.report_error_(b, for_statement_list(b, l + 1)) && r
            r = p && GeneratedParserUtilBase.report_error_(b, GeneratedParserUtilBase.consumeTokens(b, -1, MesonBuildTypes.Companion.LANG_TOKEN_FOREACH_END, MesonBuildTypes.Companion.NEWLINE)) && r
            GeneratedParserUtilBase.exit_section_(b, l, m, r, p, repetitive_statement_recover_parser_)
            return r || p
        }

        /* ********************************************************** */ // !"endforeach" newline
        fun repetitive_statement_recover(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "repetitive_statement_recover")) return false
            if (!GeneratedParserUtilBase.nextTokenIs(b, MesonBuildTypes.Companion.NEWLINE)) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = repetitive_statement_recover_0(b!!, l + 1)
            r = r && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        // !"endforeach"
        private fun repetitive_statement_recover_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "repetitive_statement_recover_0")) return false
            val r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NOT_)
            r = !GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.LANG_TOKEN_FOREACH_END)
            GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null)
            return r
        }

        /* ********************************************************** */ // "if" full_bool_expression newline statement_list ("elif" full_bool_expression newline statement_list)* ["else" newline statement_list] "endif" newline
        fun selection_statement(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "selection_statement")) return false
            var r: Boolean
            val p: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.SELECTION_STATEMENT, "<selection statement>")
            r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.LANG_TOKEN_IF)
            p = r // pin = 1
            r = r && GeneratedParserUtilBase.report_error_(b, full_bool_expression(b, l + 1))
            r = p && GeneratedParserUtilBase.report_error_(b, GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)) && r
            r = p && GeneratedParserUtilBase.report_error_(b, statement_list(b, l + 1)) && r
            r = p && GeneratedParserUtilBase.report_error_(b, selection_statement_4(b!!, l + 1)) && r
            r = p && GeneratedParserUtilBase.report_error_(b, selection_statement_5(b!!, l + 1)) && r
            r = p && GeneratedParserUtilBase.report_error_(b, GeneratedParserUtilBase.consumeTokens(b, -1, MesonBuildTypes.Companion.LANG_TOKEN_ENDIF, MesonBuildTypes.Companion.NEWLINE)) && r
            GeneratedParserUtilBase.exit_section_(b, l, m, r, p, selection_statement_recover_parser_)
            return r || p
        }

        // ("elif" full_bool_expression newline statement_list)*
        private fun selection_statement_4(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "selection_statement_4")) return false
            while (true) {
                val c = GeneratedParserUtilBase.current_position_(b)
                if (!selection_statement_4_0(b, l + 1)) break
                if (!GeneratedParserUtilBase.empty_element_parsed_guard_(b, "selection_statement_4", c)) break
            }
            return true
        }

        // "elif" full_bool_expression newline statement_list
        private fun selection_statement_4_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "selection_statement_4_0")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.LANG_TOKEN_ELSE_IF)
            r = r && full_bool_expression(b, l + 1)
            r = r && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            r = r && statement_list(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        // ["else" newline statement_list]
        private fun selection_statement_5(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "selection_statement_5")) return false
            selection_statement_5_0(b, l + 1)
            return true
        }

        // "else" newline statement_list
        private fun selection_statement_5_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "selection_statement_5_0")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = GeneratedParserUtilBase.consumeTokens(b, 0, MesonBuildTypes.Companion.LANG_TOKEN_ELSE, MesonBuildTypes.Companion.NEWLINE)
            r = r && statement_list(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        /* ********************************************************** */ // "if" full_bool_expression newline statement_list ("elif" full_bool_expression newline statement_list)* ["else" newline statement_list] "endif" newline
        fun selection_statement_for(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "selection_statement_for")) return false
            var r: Boolean
            val p: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.SELECTION_STATEMENT_FOR, "<selection statement for>")
            r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.LANG_TOKEN_IF)
            p = r // pin = 1
            r = r && GeneratedParserUtilBase.report_error_(b, full_bool_expression(b, l + 1))
            r = p && GeneratedParserUtilBase.report_error_(b, GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)) && r
            r = p && GeneratedParserUtilBase.report_error_(b, statement_list(b, l + 1)) && r
            r = p && GeneratedParserUtilBase.report_error_(b, selection_statement_for_4(b!!, l + 1)) && r
            r = p && GeneratedParserUtilBase.report_error_(b, selection_statement_for_5(b!!, l + 1)) && r
            r = p && GeneratedParserUtilBase.report_error_(b, GeneratedParserUtilBase.consumeTokens(b, -1, MesonBuildTypes.Companion.LANG_TOKEN_ENDIF, MesonBuildTypes.Companion.NEWLINE)) && r
            GeneratedParserUtilBase.exit_section_(b, l, m, r, p, selection_statement_recover_parser_)
            return r || p
        }

        // ("elif" full_bool_expression newline statement_list)*
        private fun selection_statement_for_4(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "selection_statement_for_4")) return false
            while (true) {
                val c = GeneratedParserUtilBase.current_position_(b)
                if (!selection_statement_for_4_0(b, l + 1)) break
                if (!GeneratedParserUtilBase.empty_element_parsed_guard_(b, "selection_statement_for_4", c)) break
            }
            return true
        }

        // "elif" full_bool_expression newline statement_list
        private fun selection_statement_for_4_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "selection_statement_for_4_0")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.LANG_TOKEN_ELSE_IF)
            r = r && full_bool_expression(b, l + 1)
            r = r && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            r = r && statement_list(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        // ["else" newline statement_list]
        private fun selection_statement_for_5(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "selection_statement_for_5")) return false
            selection_statement_for_5_0(b, l + 1)
            return true
        }

        // "else" newline statement_list
        private fun selection_statement_for_5_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "selection_statement_for_5_0")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = GeneratedParserUtilBase.consumeTokens(b, 0, MesonBuildTypes.Companion.LANG_TOKEN_ELSE, MesonBuildTypes.Companion.NEWLINE)
            r = r && statement_list(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        /* ********************************************************** */ // !"endif" newline
        fun selection_statement_recover(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "selection_statement_recover")) return false
            if (!GeneratedParserUtilBase.nextTokenIs(b, MesonBuildTypes.Companion.NEWLINE)) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = selection_statement_recover_0(b!!, l + 1)
            r = r && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        // !"endif"
        private fun selection_statement_recover_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "selection_statement_recover_0")) return false
            val r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NOT_)
            r = !GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.LANG_TOKEN_ENDIF)
            GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null)
            return r
        }

        /* ********************************************************** */ // !<<eof>> (method_call_statement | func_call_statement | assignment_statement | selection_statement | repetitive_statement)
        fun statement(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "statement")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.STATEMENT, "<statement>")
            r = statement_0(b!!, l + 1)
            r = r && statement_1(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, l, m, r, false, statement_recover_parser_)
            return r
        }

        // !<<eof>>
        private fun statement_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "statement_0")) return false
            val r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NOT_)
            r = !GeneratedParserUtilBase.eof(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null)
            return r
        }

        // method_call_statement | func_call_statement | assignment_statement | selection_statement | repetitive_statement
        private fun statement_1(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "statement_1")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = method_call_statement(b, l + 1)
            if (!r) r = func_call_statement(b, l + 1)
            if (!r) r = assignment_statement(b, l + 1)
            if (!r) r = selection_statement(b, l + 1)
            if (!r) r = repetitive_statement(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        /* ********************************************************** */ // newline
        fun statement_for_recover(b: PsiBuilder?, l: Int): Boolean {
            return GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
        }

        /* ********************************************************** */ // (statement | newline)*
        fun statement_list(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "statement_list")) return false
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.STATEMENT_LIST, "<statement list>")
            while (true) {
                val c = GeneratedParserUtilBase.current_position_(b)
                if (!statement_list_0(b!!, l + 1)) break
                if (!GeneratedParserUtilBase.empty_element_parsed_guard_(b, "statement_list", c)) break
            }
            GeneratedParserUtilBase.exit_section_(b, l, m, true, false, null)
            return true
        }

        // statement | newline
        private fun statement_list_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "statement_list_0")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = statement(b, l + 1)
            if (!r) r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        /* ********************************************************** */ // newline
        fun statement_recover(b: PsiBuilder?, l: Int): Boolean {
            return GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
        }

        /* ********************************************************** */ // strmultiline | strsimple
        fun string_literal(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "string_literal")) return false
            if (!GeneratedParserUtilBase.nextTokenIs(b, "", MesonBuildTypes.Companion.STRMULTILINE, MesonBuildTypes.Companion.STRSIMPLE)) return false
            var r: Boolean
            r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.STRMULTILINE)
            if (!r) r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.STRSIMPLE)
            return r
        }

        /* ********************************************************** */ // method_call_expression_base (newline? "." newline? func_call_expression | index_expr)+
        fun subscript_method_chain_expr(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "subscript_method_chain_expr")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.SUBSCRIPT_METHOD_CHAIN_EXPR, "<subscript method chain expr>")
            r = method_call_expression_base(b, l + 1)
            r = r && subscript_method_chain_expr_1(b!!, l + 1)
            GeneratedParserUtilBase.exit_section_(b, l, m, r, false, null)
            return r
        }

        // (newline? "." newline? func_call_expression | index_expr)+
        private fun subscript_method_chain_expr_1(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "subscript_method_chain_expr_1")) return false
            val r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = subscript_method_chain_expr_1_0(b, l + 1)
            while (r) {
                val c = GeneratedParserUtilBase.current_position_(b)
                if (!subscript_method_chain_expr_1_0(b, l + 1)) break
                if (!GeneratedParserUtilBase.empty_element_parsed_guard_(b, "subscript_method_chain_expr_1", c)) break
            }
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        // newline? "." newline? func_call_expression | index_expr
        private fun subscript_method_chain_expr_1_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "subscript_method_chain_expr_1_0")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = subscript_method_chain_expr_1_0_0(b, l + 1)
            if (!r) r = index_expr(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        // newline? "." newline? func_call_expression
        private fun subscript_method_chain_expr_1_0_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "subscript_method_chain_expr_1_0_0")) return false
            var r: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b)
            r = subscript_method_chain_expr_1_0_0_0(b, l + 1)
            r = r && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.LANG_TOKEN_DOT)
            r = r && subscript_method_chain_expr_1_0_0_2(b, l + 1)
            r = r && func_call_expression(b, l + 1)
            GeneratedParserUtilBase.exit_section_(b, m, null, r)
            return r
        }

        // newline?
        private fun subscript_method_chain_expr_1_0_0_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "subscript_method_chain_expr_1_0_0_0")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        // newline?
        private fun subscript_method_chain_expr_1_0_0_2(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "subscript_method_chain_expr_1_0_0_2")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        /* ********************************************************** */ // (conditional_or_expression | add_expr) newline? "?" newline? full_expression newline? ":" newline? full_expression
        fun ternary_expression(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "ternary_expression")) return false
            var r: Boolean
            val p: Boolean
            val m = GeneratedParserUtilBase.enter_section_(b, l, GeneratedParserUtilBase._NONE_, MesonBuildTypes.Companion.TERNARY_EXPRESSION, "<ternary expression>")
            r = ternary_expression_0(b!!, l + 1)
            r = r && ternary_expression_1(b, l + 1)
            r = r && GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.LANG_TOKEN_QMARK)
            p = r // pin = 3
            r = r && GeneratedParserUtilBase.report_error_(b, ternary_expression_3(b, l + 1))
            r = p && GeneratedParserUtilBase.report_error_(b, full_expression(b, l + 1)) && r
            r = p && GeneratedParserUtilBase.report_error_(b, ternary_expression_5(b, l + 1)) && r
            r = p && GeneratedParserUtilBase.report_error_(b, GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.LANG_TOKEN_COLON)) && r
            r = p && GeneratedParserUtilBase.report_error_(b, ternary_expression_7(b, l + 1)) && r
            r = p && full_expression(b, l + 1) && r
            GeneratedParserUtilBase.exit_section_(b, l, m, r, p, null)
            return r || p
        }

        // conditional_or_expression | add_expr
        private fun ternary_expression_0(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "ternary_expression_0")) return false
            var r: Boolean
            r = conditional_or_expression(b, l + 1)
            if (!r) r = add_expr(b, l + 1)
            return r
        }

        // newline?
        private fun ternary_expression_1(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "ternary_expression_1")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        // newline?
        private fun ternary_expression_3(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "ternary_expression_3")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        // newline?
        private fun ternary_expression_5(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "ternary_expression_5")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        // newline?
        private fun ternary_expression_7(b: PsiBuilder, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "ternary_expression_7")) return false
            GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.NEWLINE)
            return true
        }

        /* ********************************************************** */ // "+" | "-"
        fun unary_num_op(b: PsiBuilder?, l: Int): Boolean {
            if (!GeneratedParserUtilBase.recursion_guard_(b, l, "unary_num_op")) return false
            if (!GeneratedParserUtilBase.nextTokenIs(b, "", MesonBuildTypes.Companion.MINUS_OP, MesonBuildTypes.Companion.PLUS_OP)) return false
            var r: Boolean
            r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.PLUS_OP)
            if (!r) r = GeneratedParserUtilBase.consumeToken(b, MesonBuildTypes.Companion.MINUS_OP)
            return r
        }

        val repetitive_statement_recover_parser_ = GeneratedParserUtilBase.Parser { b, l -> repetitive_statement_recover(b, l + 1) }
        val selection_statement_recover_parser_ = GeneratedParserUtilBase.Parser { b, l -> selection_statement_recover(b, l + 1) }
        val statement_for_recover_parser_ = GeneratedParserUtilBase.Parser { b, l -> statement_for_recover(b, l + 1) }
        val statement_recover_parser_ = GeneratedParserUtilBase.Parser { b, l -> statement_recover(b, l + 1) }
    }
}