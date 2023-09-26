package com.airbnb.airbnbclone.presentation.navigation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun AppBottomNavigation(
  items: List<BottomNavItem>,
  navController: NavController,
  modifier: Modifier,
  onItemClick: (BottomNavItem) -> Unit
){
  val backStateEntry=navController.currentBackStackEntryAsState()
  NavigationBar (
    modifier= Modifier.border(1.dp, Color.LightGray), containerColor = Color.White , contentColor = Color.Black,
  ) {
    items.forEach { item ->
      val selected=item.route==backStateEntry.value?.destination?.route
      NavigationBarItem(
        selected = selected,
        onClick = { onItemClick(item)},
        icon ={
          Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(imageVector = item.icon, contentDescription = item.name )
            Text(text = item.name, textAlign = TextAlign.Center, fontSize = 10.sp)
          }
        },
        colors= NavigationBarItemDefaults.colors(
          selectedIconColor= Color.Red,
          selectedTextColor=Color.Red,
          unselectedIconColor= Color.Gray,
          unselectedTextColor= Color.Gray,
          indicatorColor= Color.White
        )
      )
    }
  }
}