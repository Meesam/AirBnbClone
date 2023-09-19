package com.airbnb.airbnbclone.data.remote.dto

data class ReviewScores(
    val review_scores_accuracy: Int,
    val review_scores_checkin: Int,
    val review_scores_cleanliness: Int,
    val review_scores_communication: Int,
    val review_scores_location: Int,
    val review_scores_rating: Int,
    val review_scores_value: Int
)