package com.airbnb.airbnbclone.presentation.listings_list

import com.airbnb.airbnbclone.domain.model.ListingsModel

data class ListingsState(
  val isLoading:Boolean = false,
  val listings:ListingsModel? = null ,
  val error:String = ""
)
