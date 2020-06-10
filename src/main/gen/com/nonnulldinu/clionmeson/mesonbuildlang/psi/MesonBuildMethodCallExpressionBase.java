// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.mesonbuildlang.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MesonBuildMethodCallExpressionBase extends PsiElement {

  @Nullable
  MesonBuildArrayLiteral getArrayLiteral();

  @Nullable
  MesonBuildDictLiteral getDictLiteral();

  @Nullable
  MesonBuildFuncCallExpression getFuncCallExpression();

  @Nullable
  MesonBuildNumLiteralUnary getNumLiteralUnary();

  @Nullable
  PsiElement getBinnum();

  @Nullable
  PsiElement getDecnum();

  @Nullable
  PsiElement getHexnum();

  @Nullable
  PsiElement getId();

  @Nullable
  PsiElement getOctnum();

  @Nullable
  PsiElement getStrmultiline();

  @Nullable
  PsiElement getStrsimple();

}
