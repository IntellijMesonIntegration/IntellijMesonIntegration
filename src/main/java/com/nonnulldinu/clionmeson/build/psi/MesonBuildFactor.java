// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MesonBuildFactor extends PsiElement {

  @Nullable
  MesonBuildArray getArray();

  @Nullable
  MesonBuildDict getDict();

  @Nullable
  MesonBuildFuncCallExpression getFuncCallExpression();

  @Nullable
  MesonBuildIdExpression getIdExpression();

  @Nullable
  MesonBuildMethodCallChain getMethodCallChain();

  @Nullable
  MesonBuildParExpression getParExpression();

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
