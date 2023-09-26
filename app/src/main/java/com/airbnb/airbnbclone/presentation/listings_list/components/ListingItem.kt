package com.airbnb.airbnbclone.presentation.listings_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.airbnb.airbnbclone.domain.model.ListingModel
import com.airbnb.airbnbclone.presentation.ui.theme.AirBnbCloneTheme
import com.airbnb.airbnbclone.R

@Composable
fun ListingItem(
  listing:ListingModel,
){
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
      .clickable {  }
  ) {
    Column() {
      Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
          model = listing.images.picture_url,
          contentDescription = null,
          contentScale = ContentScale.FillWidth,
          modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .fillMaxSize()
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
          IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Outlined.FavoriteBorder,contentDescription = "Menu" ,tint = Color.White )
          }
        }
      }
      Spacer(modifier = Modifier.height(10.dp))
      Text(
        text = "${listing.address.market}, ${listing.address.country}",
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
        )
      Spacer(modifier = Modifier.height(5.dp))
      Text(
        text = "$${listing.price.toString()} total before taxes",
        textDecoration = TextDecoration.Underline
      )
    }
  }
}

@Composable
fun ListingItem1(
){
  Box(
    modifier = Modifier.fillMaxWidth()
  ) {
    Column() {
      Box(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id =R.drawable.android_device_identifiers_featured ), contentScale = ContentScale.FillWidth, contentDescription ="", modifier = Modifier
          .clip(RoundedCornerShape(10.dp))
          .fillMaxSize() )
        /*AsyncImage(
          model = "https://semicolonspace.com/wp-content/uploads/2023/02/forest.jpg",
          contentDescription = null,
        )*/
        Column(horizontalAlignment = Alignment.End) {
          IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Outlined.FavoriteBorder,contentDescription = "Menu" ,tint = Color.White )
          }
        }
        
      }
      Text(text = "Noida")
      Text(text = "100$")
    }
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  AirBnbCloneTheme {
    ListingItem1()
  }
}