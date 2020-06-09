// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.mesonbuildlang.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.nonnulldinu.clionmeson.mesonbuildlang.psi.*;

public class MesonBuildRepetitiveStatementImpl extends ASTWrapperPsiElement implements MesonBuildRepetitiveStatement {

  public MesonBuildRepetitiveStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MesonBuildVisitor visitor) {
    visitor.visitRepetitiveStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MesonBuildVisitor) accept((MesonBuildVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MesonBuildForStatementList getForStatementList() {
    return findChildByClass(MesonBuildForStatementList.class);
  }

  @Override
  @Nullable
  public MesonBuildFullExpression getFullExpression() {
    return findChildByClass(MesonBuildFullExpression.class);
  }

  @Override
  @Nullable
  public MesonBuildIdList getIdList() {
    return findChildByClass(MesonBuildIdList.class);
  }

}
