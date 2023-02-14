package com.example.domain.domain.mapper


class RatingMapper {

    fun getRatingColor(rating: Float): Int {
        return RatingColored.getRatingByValue(rating).id
    }
}

enum class RatingColored(
    val id: Int,
    val ratingStartValue: Float,
    val ratingFinishValue: Float,
) {
    NONE(0,-1.0f, 0.0f),
    BAD(1,0.0f, 2.9f),
    NORMAL(2,3.0f, 5.9f),
    GOOD(3, 6.0f, 8.5f),
    EXCELLENT(4, 8.6f, 10.0f);

    companion object {

        fun getRatingByValue(rating: Float): RatingColored =
            RatingColored.values().find {
                rating in it.ratingStartValue..it.ratingFinishValue
            } ?: NONE
    }

}