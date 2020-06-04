// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MesonBuildSubscriptMethodChainExpr extends PsiElement {

  @NotNull
  List<MesonBuildAddExpr> getAddExprList();

  @NotNull
  List<MesonBuildFuncCallExpression> getFuncCallExpressionList();

  @NotNull
  MesonBuildMethodCallExpressionBase getMethodCallExpressionBase();

}
