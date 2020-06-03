// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MesonBuildMethodCallChain extends PsiElement {

  @NotNull
  List<MesonBuildFuncCallExpression> getFuncCallExpressionList();

  @NotNull
  List<MesonBuildIndexExpr> getIndexExprList();

  @NotNull
  MesonBuildMethodCallExpressionBase getMethodCallExpressionBase();

}
