package com.airbnb.airbnbclone.presentation.search_bar.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.airbnbclone.presentation.Screen


@Composable
fun SearchDetailedScreen(navController: NavController){
    var startAnimation by remember { mutableStateOf(false) }
    LaunchedEffect(key1 = true ){
        startAnimation = true
    }
    Box(modifier = Modifier.fillMaxSize()) {
      Column(verticalArrangement = Arrangement.SpaceBetween ,modifier = Modifier.fillMaxHeight()) {
          AnimatedVisibility(
              visible = startAnimation,
              enter = slideInVertically(initialOffsetY = { -it }),
              exit = slideOutVertically(targetOffsetY = { it })
          ) {
              WhereToScreen(navController)
          }
          AnimatedVisibility(
              visible = startAnimation,
              enter = slideInVertically(initialOffsetY = { it }),
              exit = slideOutVertically(targetOffsetY = { it })
          ) {
              SearchDetailsBottom()
          }
      }
    }
}