package com.airbnb.airbnbclone.data.repository

import com.airbnb.airbnbclone.data.remote.ListingsAndReviewApi
import com.airbnb.airbnbclone.data.remote.dto.ListingDto
import com.airbnb.airbnbclone.data.remote.dto.Listings
import com.airbnb.airbnbclone.domain.repository.ListingAndReviewRepository
import javax.inject.Inject

class ListingAndReviewRepositoryImpl @Inject constructor(
    private val listingsAndReviewApi : ListingsAndReviewApi
): ListingAndReviewRepository {
  override suspend fun getListingsAndReview(): ListingDto {
    return listingsAndReviewApi.getListingsAndReview()
  }
  
  override suspend fun getListingsAndReviewById(id: String): Listings {
    return listingsAndReviewApi.getListingsAndReviewById(id)
  }
}