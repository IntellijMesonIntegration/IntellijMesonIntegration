// This is a generated file. Not intended for manual editing.
package com.nonnulldinu.clionmeson.mesonbuildlang.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;

import static com.nonnulldinu.clionmeson.mesonbuildlang.psi.MesonBuildTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.nonnulldinu.clionmeson.mesonbuildlang.psi.*;

public class MesonBuildAssignmentStatementImpl extends ASTWrapperPsiElement implements MesonBuildAssignmentStatement {

  public MesonBuildAssignmentStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MesonBuildVisitor visitor) {
    visitor.visitAssignmentStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MesonBuildVisitor) accept((MesonBuildVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public MesonBuildAtrop getAtrop() {
    return findNotNullChildByClass(MesonBuildAtrop.class);
  }

  @Override
  @Nullable
  public MesonBuildFullExpression getFullExpression() {
    return findChildByClass(MesonBuildFullExpression.class);
  }

  @Override
  @NotNull
  public MesonBuildIdExpression getIdExpression() {
    return findNotNullChildByClass(MesonBuildIdExpression.class);
  }

  @Override
  @Nullable
  public PsiElement getNewline() {
    return findChildByType(NEWLINE);
  }

}
