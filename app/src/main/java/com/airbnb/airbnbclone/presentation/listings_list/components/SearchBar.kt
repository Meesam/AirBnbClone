package com.airbnb.airbnbclone.presentation.listings_list.components


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.rounded.ClearAll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.airbnbclone.R

@Composable
fun SearchBar(){
  Box{
   Row(
     verticalAlignment = Alignment.CenterVertically,
     modifier = Modifier
       .fillMaxWidth()
       .shadow(
         elevation = 20.dp,
         shape = RoundedCornerShape(50.dp),
         clip = true,
         ambientColor = Color.Black,
         spotColor = Color.Black
       )
       .background(Color.White)
       .padding(10.dp)
   ){
     IconButton(onClick = { /*TODO*/ }) {
       Icon(imageVector = Icons.Outlined.Search , tint = Color.Black , contentDescription = "Search")
     }
     Column() {
       Text(
         text = "Where to?",
         fontSize = 12.sp,
         fontFamily = FontFamily.Default,
         fontWeight = FontWeight.W400)
       Text(
         text="Anywhere Any week Add guests",
         fontFamily = FontFamily.Default,
         fontWeight = FontWeight.W200,
         fontSize = 10.sp
         )
     }
     Spacer(modifier = Modifier.width(95.dp))
     Box(contentAlignment= Alignment.Center ,modifier = Modifier
       .border(1.dp, Color.LightGray, shape = CircleShape)
     ) {
       IconButton(onClick = { /*TODO*/ }) {
         Icon(imageVector = Icons.Rounded.ClearAll , tint = Color.Black , contentDescription = "Search")
       }
     }
   }
  }
}

@Composable
@Preview(showBackground = true, heightDp = 500)
fun SearchPreview(){
  SearchBar()
}