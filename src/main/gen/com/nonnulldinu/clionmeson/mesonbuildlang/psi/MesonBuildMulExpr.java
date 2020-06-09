// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.mesonbuildlang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MesonBuildMulExpr extends PsiElement {

  @NotNull
  List<MesonBuildAtom> getAtomList();

  @NotNull
  List<MesonBuildMulOp> getMulOpList();

}
