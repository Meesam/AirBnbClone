package com.airbnb.airbnbclone.domain.model

import com.airbnb.airbnbclone.data.remote.dto.Address
import com.airbnb.airbnbclone.data.remote.dto.Images

data class ListingModel(
  val _id: String,
  val address: Address,
  val description: String,
  val images: Images,
  val price: Int,
  val property_type: String,
  val name: String,
  )
