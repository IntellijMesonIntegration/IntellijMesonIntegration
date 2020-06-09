// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.mesonbuildlang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.nonnulldinu.clionmeson.mesonbuildlang.psi.*;

public class MesonBuildArrayLiteralImpl extends ASTWrapperPsiElement implements MesonBuildArrayLiteral {

  public MesonBuildArrayLiteralImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MesonBuildVisitor visitor) {
    visitor.visitArrayLiteral(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MesonBuildVisitor) accept((MesonBuildVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MesonBuildFullExpression> getFullExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MesonBuildFullExpression.class);
  }

}
