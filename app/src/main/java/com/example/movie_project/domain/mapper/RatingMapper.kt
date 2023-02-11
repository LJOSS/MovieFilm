package com.example.movie_project.domain.mapper

import androidx.annotation.ColorRes
import com.example.movie_project.R

class RatingMapper {

    fun getRatingColor(rating: Float): Int {
        return RatingColored.getRatingByValue(rating).ratingColor
    }
}

enum class RatingColored(
    val ratingStartValue: Float,
    val ratingFinishValue: Float,
    @ColorRes val ratingColor: Int
) {
    NONE(-1.0f, 0.0f, R.color.black),
    BAD(0.0f, 2.9f, R.color.badRating),
    NORMAL(3.0f, 5.9f, R.color.normalRating),
    GOOD(6.0f, 8.5f, R.color.goodRating),
    EXCELLENT(8.6f, 10.0f, R.color.excellentRating);

    companion object {

        fun getRatingByValue(rating: Float): RatingColored =
            RatingColored.values().find {
                rating in it.ratingStartValue..it.ratingFinishValue
            } ?: NONE
    }

}