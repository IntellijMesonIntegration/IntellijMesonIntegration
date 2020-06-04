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

public class MesonBuildNumLiteralUnaryImpl extends ASTWrapperPsiElement implements MesonBuildNumLiteralUnary {

  public MesonBuildNumLiteralUnaryImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MesonBuildVisitor visitor) {
    visitor.visitNumLiteralUnary(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MesonBuildVisitor) accept((MesonBuildVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getBinnum() {
    return findChildByType(BINNUM);
  }

  @Override
  @Nullable
  public PsiElement getDecnum() {
    return findChildByType(DECNUM);
  }

  @Override
  @Nullable
  public PsiElement getHexnum() {
    return findChildByType(HEXNUM);
  }

  @Override
  @Nullable
  public PsiElement getOctnum() {
    return findChildByType(OCTNUM);
  }

}
