// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.build.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.nonnulldinu.clionmeson.build.psi.MesonBuildTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.nonnulldinu.clionmeson.build.psi.*;

public class MesonBuildStatementImpl extends ASTWrapperPsiElement implements MesonBuildStatement {

  public MesonBuildStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MesonBuildVisitor visitor) {
    visitor.visitStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MesonBuildVisitor) accept((MesonBuildVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MesonBuildAssignmentStatement getAssignmentStatement() {
    return findChildByClass(MesonBuildAssignmentStatement.class);
  }

  @Override
  @Nullable
  public MesonBuildFuncCallStatement getFuncCallStatement() {
    return findChildByClass(MesonBuildFuncCallStatement.class);
  }

  @Override
  @Nullable
  public MesonBuildSelectionStatement getSelectionStatement() {
    return findChildByClass(MesonBuildSelectionStatement.class);
  }

  @Override
  @Nullable
  public PsiElement getNewline() {
    return findChildByType(NEWLINE);
  }

}
