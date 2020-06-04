// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MesonBuildSimpleBoolExpression extends PsiElement {

  @Nullable
  MesonBuildBoolLiteral getBoolLiteral();

  @Nullable
  MesonBuildExpression getExpression();

  @Nullable
  MesonBuildFuncCallExpression getFuncCallExpression();

  @Nullable
  MesonBuildMethodCallChain getMethodCallChain();

  @Nullable
  MesonBuildParExpression getParExpression();

  @Nullable
  MesonBuildRelCheckExpr getRelCheckExpr();

  @Nullable
  MesonBuildSimpleBoolExpression getSimpleBoolExpression();

  @Nullable
  PsiElement getId();

}
