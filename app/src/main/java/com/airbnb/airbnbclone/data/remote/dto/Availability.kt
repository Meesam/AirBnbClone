package com.airbnb.airbnbclone.data.remote.dto

data class Availability(
    val availability_30: Int,
    val availability_365: Int,
    val availability_60: Int,
    val availability_90: Int
)