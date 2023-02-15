package com.example.domain.domain.mapper

class BudgetMapper {

    fun mapBudget(budget: Long): String {
        return if (budget == 0L) {
            "-"
        } else {
            String.format(BUDGET_FORMAT, budget)
        }
    }

    companion object {
        private const val BUDGET_FORMAT = "%,d$"
    }
}
