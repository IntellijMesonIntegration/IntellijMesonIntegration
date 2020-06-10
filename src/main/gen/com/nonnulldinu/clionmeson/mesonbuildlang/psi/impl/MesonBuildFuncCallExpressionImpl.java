// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.mesonbuildlang.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.nonnulldinu.clionmeson.mesonbuildlang.psi.*;

public class MesonBuildFuncCallExpressionImpl extends ASTWrapperPsiElement implements MesonBuildFuncCallExpression {

  public MesonBuildFuncCallExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MesonBuildVisitor visitor) {
    visitor.visitFuncCallExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MesonBuildVisitor) accept((MesonBuildVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MesonBuildFuncArgs getFuncArgs() {
    return findChildByClass(MesonBuildFuncArgs.class);
  }

  @Override
  @NotNull
  public MesonBuildFuncName getFuncName() {
    return findNotNullChildByClass(MesonBuildFuncName.class);
  }

}
