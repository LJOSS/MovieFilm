package com.example.movie_project.presentation.entity

import androidx.annotation.ColorRes
import com.example.movie_project.R


enum class RatingColoredUI(
    val id: Int,
    @ColorRes val ratingColor: Int
) {
    NONE(0, R.color.black),
    BAD(1, R.color.badRating),
    NORMAL(2, R.color.normalRating),
    GOOD(3, R.color.goodRating),
    EXCELLENT(4, R.color.excellentRating);

    companion object {

        fun getRatingUIById(id: Int): RatingColoredUI =
            RatingColoredUI.values().find { it.id == id } ?: NONE
    }
}