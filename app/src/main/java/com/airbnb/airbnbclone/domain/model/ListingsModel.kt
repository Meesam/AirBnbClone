package com.airbnb.airbnbclone.domain.model

import com.airbnb.airbnbclone.data.remote.dto.Paginator

data class ListingsModel(
  val listings: List<ListingModel>,
  val paginator: Paginator
)
