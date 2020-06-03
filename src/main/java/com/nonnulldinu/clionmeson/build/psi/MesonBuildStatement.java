// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MesonBuildStatement extends PsiElement {

  @Nullable
  MesonBuildAssignmentStatement getAssignmentStatement();

  @Nullable
  MesonBuildFuncCallStatement getFuncCallStatement();

  @Nullable
  MesonBuildSelectionStatement getSelectionStatement();

}
