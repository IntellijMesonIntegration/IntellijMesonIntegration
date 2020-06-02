// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.nonnulldinu.clionmeson.build.psi.MesonBuildTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.nonnulldinu.clionmeson.build.psi.*;

public class MesonBuildSubscriptExprImpl extends ASTWrapperPsiElement implements MesonBuildSubscriptExpr {

  public MesonBuildSubscriptExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MesonBuildVisitor visitor) {
    visitor.visitSubscriptExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MesonBuildVisitor) accept((MesonBuildVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MesonBuildExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MesonBuildExpression.class);
  }

  @Override
  @NotNull
  public MesonBuildSubscriptRoot getSubscriptRoot() {
    return findNotNullChildByClass(MesonBuildSubscriptRoot.class);
  }

}
