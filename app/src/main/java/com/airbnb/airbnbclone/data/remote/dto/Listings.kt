package com.airbnb.airbnbclone.data.remote.dto

import com.airbnb.airbnbclone.domain.model.ListingModel
import com.airbnb.airbnbclone.domain.model.ListingsModel

data class Listings(
  val _id: String,
  val access: String,
  val accommodates: Int,
  val address: Address,
  val amenities: List<String>,
  val availability: Availability,
  val bathrooms: Double,
  val bed_type: String,
  val bedrooms: Int,
  val beds: Int,
  val calendar_last_scraped: String,
  val cancellation_policy: String,
  val cleaning_fee: CleaningFee,
  val description: String,
  val extra_people: ExtraPeople,
  val first_review: String,
  val guests_included: Int,
  val host: Host,
  val house_rules: String,
  val images: Images,
  val interaction: String,
  val last_review: String,
  val last_scraped: String,
  val listing_url: String,
  val maximum_nights: String,
  val minimum_nights: String,
  val name: String,
  val neighborhood_overview: String,
  val notes: String,
  val number_of_reviews: Int,
  val price: Int,
  val property_type: String,
  val review_scores: ReviewScores,
  val reviews: List<Review>,
  val room_type: String,
  val security_deposit: SecurityDeposit,
  val space: String,
  val summary: String,
  val transit: String,
  val weekly_price: WeeklyPrice
)

fun Listings.toListingsModel(): ListingModel {
  return ListingModel(
      _id = _id,
      address = address,
      description= description,
      images= images,
      price= price,
      property_type= property_type,
      name= name
  )
}
