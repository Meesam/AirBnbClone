package com.airbnb.airbnbclone.data.remote

import com.airbnb.airbnbclone.data.remote.dto.ListingDto
import com.airbnb.airbnbclone.data.remote.dto.Listings
import retrofit2.Response
import retrofit2.http.GET

interface ListingsAndReviewApi {
  @GET("/getListings")
  suspend fun getListingsAndReview():ListingDto
  
  @GET("/getListings/id:id")
  suspend fun getListingsAndReviewById(id:String):Listings
}