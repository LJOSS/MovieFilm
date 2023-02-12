package com.example.movie_project.domain.mapper

class BudgetMapper {

    fun mapBudget(budget: Long): String {
        return if (budget == 0L) {
            "-"
        } else {
            String.format("%,d$", budget)
        }
    }
}