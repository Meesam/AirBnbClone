package com.airbnb.airbnbclone.presentation.listings_list.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.airbnbclone.domain.model.ListingModel

@Composable
fun ListingItem(
  listing:ListingModel,
){
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(20.dp)
  ) {
   Text(text = listing.property_type)
    Text(text = listing.name)
    Text(text = listing.price.toString())
  }
}