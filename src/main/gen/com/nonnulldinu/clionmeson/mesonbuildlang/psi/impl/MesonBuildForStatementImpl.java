// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.mesonbuildlang.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.nonnulldinu.clionmeson.mesonbuildlang.psi.*;

public class MesonBuildForStatementImpl extends ASTWrapperPsiElement implements MesonBuildForStatement {

  public MesonBuildForStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MesonBuildVisitor visitor) {
    visitor.visitForStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MesonBuildVisitor) accept((MesonBuildVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MesonBuildAssignmentStatement getAssignmentStatement() {
    return findChildByClass(MesonBuildAssignmentStatement.class);
  }

  @Override
  @Nullable
  public MesonBuildControlStatement getControlStatement() {
    return findChildByClass(MesonBuildControlStatement.class);
  }

  @Override
  @Nullable
  public MesonBuildFuncCallStatement getFuncCallStatement() {
    return findChildByClass(MesonBuildFuncCallStatement.class);
  }

  @Override
  @Nullable
  public MesonBuildMethodCallStatement getMethodCallStatement() {
    return findChildByClass(MesonBuildMethodCallStatement.class);
  }

  @Override
  @Nullable
  public MesonBuildRepetitiveStatement getRepetitiveStatement() {
    return findChildByClass(MesonBuildRepetitiveStatement.class);
  }

  @Override
  @Nullable
  public MesonBuildSelectionStatementFor getSelectionStatementFor() {
    return findChildByClass(MesonBuildSelectionStatementFor.class);
  }

}
