package com.airbnb.airbnbclone.domain.repository

import com.airbnb.airbnbclone.data.remote.dto.ListingDto
import com.airbnb.airbnbclone.data.remote.dto.Listings

interface ListingAndReviewRepository {
  suspend fun getListingsAndReview(): ListingDto
  
  suspend fun getListingsAndReviewById(id:String): Listings
}