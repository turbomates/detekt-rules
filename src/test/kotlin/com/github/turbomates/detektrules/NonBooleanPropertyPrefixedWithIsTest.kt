package com.github.turbomates.detektrules

import io.gitlab.arturbosch.detekt.rules.KotlinCoreEnvironmentTest
import io.gitlab.arturbosch.detekt.test.TestConfig
import io.gitlab.arturbosch.detekt.test.compileAndLintWithContext
import io.kotest.matchers.collections.shouldHaveSize
import org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreEnvironment
import org.junit.jupiter.api.Test

@KotlinCoreEnvironmentTest
internal class NonBooleanPropertyPrefixedWithIsTest(private val env: KotlinCoreEnvironment) {
    private val config = TestConfig(mapOf("excludedTypes" to listOf("BooleanWrapper")))
    private val subject = NonBooleanPropertyPrefixedWithIs(config)

    @Test
    fun `excluded type ignored`() {
        val code = """
            data class O (var isDefault: BooleanWrapper)
            data class BooleanWrapper(val value: Boolean)
        """
        val findings = subject.compileAndLintWithContext(env, code)
        findings shouldHaveSize 0
    }
}
