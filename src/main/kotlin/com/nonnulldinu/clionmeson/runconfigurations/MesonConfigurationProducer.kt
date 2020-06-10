package com.nonnulldinu.clionmeson.runconfigurations

import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.actions.RunConfigurationProducer
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiElement

class MesonConfigurationProducer : RunConfigurationProducer<MesonConfiguration>(false) {
    override fun isConfigurationFromContext(configuration: MesonConfiguration, context: ConfigurationContext): Boolean {
        TODO("Not yet implemented")
    }

    override fun setupConfigurationFromContext(configuration: MesonConfiguration, context: ConfigurationContext, sourceElement: Ref<PsiElement>): Boolean {
        TODO("Not yet implemented")
    }

}