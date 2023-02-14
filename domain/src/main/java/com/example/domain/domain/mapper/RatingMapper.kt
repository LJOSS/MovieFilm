package com.example.domain.domain.mapper

import com.example.domain.domain.entity.RatingColored

class RatingMapper {

    fun getRatingColor(rating: Float): Int {
        return RatingColored.getRatingByValue(rating).id
    }
}
