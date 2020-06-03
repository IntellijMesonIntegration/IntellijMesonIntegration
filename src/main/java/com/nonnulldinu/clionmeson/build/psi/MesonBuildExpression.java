// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MesonBuildExpression extends PsiElement {

  @Nullable
  MesonBuildAddExpr getAddExpr();

  @Nullable
  MesonBuildArray getArray();

  @Nullable
  MesonBuildDict getDict();

  @Nullable
  MesonBuildIdExpression getIdExpression();

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
  PsiElement getStrsimple();

}
