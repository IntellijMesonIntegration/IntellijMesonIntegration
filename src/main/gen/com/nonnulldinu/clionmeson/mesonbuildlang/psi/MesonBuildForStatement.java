// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.mesonbuildlang.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MesonBuildForStatement extends PsiElement {

  @Nullable
  MesonBuildAssignmentStatement getAssignmentStatement();

  @Nullable
  MesonBuildControlStatement getControlStatement();

  @Nullable
  MesonBuildFuncCallStatement getFuncCallStatement();

  @Nullable
  MesonBuildMethodCallStatement getMethodCallStatement();

  @Nullable
  MesonBuildRepetitiveStatement getRepetitiveStatement();

  @Nullable
  MesonBuildSelectionStatementFor getSelectionStatementFor();

}
