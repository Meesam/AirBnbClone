package com.airbnb.airbnbclone.presentation

sealed class Screen(val route:String) {
  object SplashScreen:Screen("splash_screen")
  object ExploreScreen:Screen("explore")
  object WishlistScreen:Screen("wishlist")
  object TripScreen:Screen("trip")
  object InboxScreen:Screen("inbox")
  object ProfileScreen:Screen("profile")
  object SearchDetailScreen:Screen("search-detail-screen")
  object MapScreen:Screen("map")
  
}
