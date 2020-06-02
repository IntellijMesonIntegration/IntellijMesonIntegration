// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MesonBuildAddExpr extends PsiElement {

  @NotNull
  List<MesonBuildAddOp> getAddOpList();

  @NotNull
  List<MesonBuildMulExpr> getMulExprList();

}
