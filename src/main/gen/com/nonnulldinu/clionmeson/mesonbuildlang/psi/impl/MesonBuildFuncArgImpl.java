// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.mesonbuildlang.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.nonnulldinu.clionmeson.mesonbuildlang.psi.*;

public class MesonBuildFuncArgImpl extends ASTWrapperPsiElement implements MesonBuildFuncArg {

  public MesonBuildFuncArgImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MesonBuildVisitor visitor) {
    visitor.visitFuncArg(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MesonBuildVisitor) accept((MesonBuildVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MesonBuildKeywordElem getKeywordElem() {
    return findChildByClass(MesonBuildKeywordElem.class);
  }

  @Override
  @Nullable
  public MesonBuildPositionalFuncArg getPositionalFuncArg() {
    return findChildByClass(MesonBuildPositionalFuncArg.class);
  }

}
