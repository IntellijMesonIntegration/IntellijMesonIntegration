// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.mesonbuildlang.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;

import static com.nonnulldinu.clionmeson.mesonbuildlang.psi.MesonBuildTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.nonnulldinu.clionmeson.mesonbuildlang.psi.*;

public class MesonBuildAtomImpl extends ASTWrapperPsiElement implements MesonBuildAtom {

  public MesonBuildAtomImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MesonBuildVisitor visitor) {
    visitor.visitAtom(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MesonBuildVisitor) accept((MesonBuildVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MesonBuildArrayLiteral getArrayLiteral() {
    return findChildByClass(MesonBuildArrayLiteral.class);
  }

  @Override
  @Nullable
  public MesonBuildDictLiteral getDictLiteral() {
    return findChildByClass(MesonBuildDictLiteral.class);
  }

  @Override
  @Nullable
  public MesonBuildFullExpression getFullExpression() {
    return findChildByClass(MesonBuildFullExpression.class);
  }

  @Override
  @Nullable
  public MesonBuildFuncCallExpression getFuncCallExpression() {
    return findChildByClass(MesonBuildFuncCallExpression.class);
  }

  @Override
  @Nullable
  public MesonBuildNumLiteralUnary getNumLiteralUnary() {
    return findChildByClass(MesonBuildNumLiteralUnary.class);
  }

  @Override
  @Nullable
  public MesonBuildSubscriptMethodChainExpr getSubscriptMethodChainExpr() {
    return findChildByClass(MesonBuildSubscriptMethodChainExpr.class);
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
  public PsiElement getId() {
    return findChildByType(ID);
  }

  @Override
  @Nullable
  public PsiElement getOctnum() {
    return findChildByType(OCTNUM);
  }

  @Override
  @Nullable
  public PsiElement getStrmultiline() {
    return findChildByType(STRMULTILINE);
  }

  @Override
  @Nullable
  public PsiElement getStrsimple() {
    return findChildByType(STRSIMPLE);
  }

}
