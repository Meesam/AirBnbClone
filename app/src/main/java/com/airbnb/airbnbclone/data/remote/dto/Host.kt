package com.airbnb.airbnbclone.data.remote.dto

data class Host(
    val host_about: String,
    val host_has_profile_pic: Boolean,
    val host_id: String,
    val host_identity_verified: Boolean,
    val host_is_superhost: Boolean,
    val host_listings_count: Int,
    val host_location: String,
    val host_name: String,
    val host_neighbourhood: String,
    val host_picture_url: String,
    val host_response_rate: Int,
    val host_response_time: String,
    val host_thumbnail_url: String,
    val host_total_listings_count: Int,
    val host_url: String,
    val host_verifications: List<String>
)