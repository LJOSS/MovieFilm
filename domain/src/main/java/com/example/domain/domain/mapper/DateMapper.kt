package com.example.domain.domain.mapper

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DateMapper {

    fun mapToYYYYMM(date: LocalDate): String {
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern(PATTERN_YYY_MM)
        return date.format(formatter)
    }

    companion object {
        private const val PATTERN_YYY_MM = "YYYY LLLL"
    }
}
