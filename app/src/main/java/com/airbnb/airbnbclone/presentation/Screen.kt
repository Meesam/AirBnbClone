package com.airbnb.airbnbclone.presentation

sealed class Screen(val route:String) {
  object ListingsScreen:Screen("listings_screen")
  object ListingDetailsScreen:Screen("listing_screen")
}
