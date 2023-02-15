package com.example.presentation.presentation.entity

data class MovieInfoUI(
    val isAdult: Boolean,
    val backDropPath: String,
    val budget: String,
    val genres: String,
    val homepage: String,
    val id: Long,
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val status: String,
    val tagline: String,
    val title: String,
    val isVideo: Boolean,
    val voteAverage: RatingUI,
    val voteCount: Int
) {
    override fun toString(): String {
        return "MovieInfoUI(\nisAdult=$isAdult, \n backDropPath='$backDropPath', \n budget=$budget, \n genres='$genres', \n homepage='$homepage', \n id=$id, \n originalTitle='$originalTitle', \n overview='$overview', \n posterPath='$posterPath', \n releaseDate='$releaseDate', \n status='$status', \n tagline='$tagline', \n title='$title', \n isVideo=$isVideo, \n voteAverage=$voteAverage, \n voteCount=$voteCount)"
    }
}
