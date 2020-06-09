// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.mesonbuildlang.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.nonnulldinu.clionmeson.mesonbuildlang.psi.*;

public class MesonBuildFullExpressionImpl extends ASTWrapperPsiElement implements MesonBuildFullExpression {

  public MesonBuildFullExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MesonBuildVisitor visitor) {
    visitor.visitFullExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MesonBuildVisitor) accept((MesonBuildVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MesonBuildAddExpr getAddExpr() {
    return findChildByClass(MesonBuildAddExpr.class);
  }

  @Override
  @Nullable
  public MesonBuildConditionalOrExpression getConditionalOrExpression() {
    return findChildByClass(MesonBuildConditionalOrExpression.class);
  }

  @Override
  @Nullable
  public MesonBuildTernaryExpression getTernaryExpression() {
    return findChildByClass(MesonBuildTernaryExpression.class);
  }

}
