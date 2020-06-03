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

public class MesonBuildAddExprImpl extends ASTWrapperPsiElement implements MesonBuildAddExpr {

  public MesonBuildAddExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MesonBuildVisitor visitor) {
    visitor.visitAddExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MesonBuildVisitor) accept((MesonBuildVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MesonBuildAddOp> getAddOpList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MesonBuildAddOp.class);
  }

  @Override
  @NotNull
  public List<MesonBuildMulExpr> getMulExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MesonBuildMulExpr.class);
  }

}