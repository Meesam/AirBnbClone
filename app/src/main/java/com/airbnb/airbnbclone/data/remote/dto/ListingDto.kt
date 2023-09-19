package com.airbnb.airbnbclone.data.remote.dto

import com.airbnb.airbnbclone.domain.model.ListingModel
import com.airbnb.airbnbclone.domain.model.ListingsModel

data class ListingDto(
    val listings: List<Listings>,
    val paginator: Paginator
)

