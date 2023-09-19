package com.airbnb.airbnbclone.data.remote.dto

data class Review(
    val _id: String,
    val comments: String,
    val date: String,
    val listing_id: String,
    val reviewer_id: String,
    val reviewer_name: String
)