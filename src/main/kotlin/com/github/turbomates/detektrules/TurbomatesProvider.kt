package com.github.turbomates.detektrules

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.RuleSet
import io.gitlab.arturbosch.detekt.api.RuleSetProvider

class TurbomatesProvider : RuleSetProvider {
    override val ruleSetId: String = "turbomates"

    override fun instance(config: Config): RuleSet {
        return RuleSet(
            ruleSetId,
            listOf(
                NonBooleanPropertyPrefixedWithIs(config),
            ),
        )
    }
}
