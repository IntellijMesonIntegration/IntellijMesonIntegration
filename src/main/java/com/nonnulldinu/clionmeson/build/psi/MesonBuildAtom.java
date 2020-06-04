// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MesonBuildAtom extends PsiElement {

  @Nullable
  MesonBuildArrayLiteral getArrayLiteral();

  @Nullable
  MesonBuildDictLiteral getDictLiteral();

  @Nullable
  MesonBuildFullExpression getFullExpression();

  @Nullable
  MesonBuildNumLiteralUnary getNumLiteralUnary();

  @Nullable
  MesonBuildSubscriptMethodChainExpr getSubscriptMethodChainExpr();

  @Nullable
  PsiElement getBinnum();

  @Nullable
  PsiElement getDecnum();

  @Nullable
  PsiElement getHexnum();

  @Nullable
  PsiElement getOctnum();

  @Nullable
  PsiElement getStrmultiline();

  @Nullable
  PsiElement getStrsimple();

}
