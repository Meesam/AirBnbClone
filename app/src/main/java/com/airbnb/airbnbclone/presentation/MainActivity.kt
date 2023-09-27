package com.airbnb.airbnbclone.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.airbnb.airbnbclone.presentation.listings_list.components.ListingsScreen
import com.airbnb.airbnbclone.presentation.map.MapScreen
import com.airbnb.airbnbclone.presentation.search_bar.components.SearchDetailedScreen
import com.airbnb.airbnbclone.presentation.navigation.AppBottomNavigation
import com.airbnb.airbnbclone.presentation.navigation.BottomNavItem
import com.airbnb.airbnbclone.presentation.splash_screen.SplashScreen
import com.airbnb.airbnbclone.presentation.ui.theme.AirBnbCloneTheme

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      AirBnbCloneTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          InitiateApp()
        }
      }
    }
  }
  
  @Composable
  fun AppNavigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route ){
      composable(Screen.SplashScreen.route){
        SplashScreen(navController)
      }
      composable(Screen.ExploreScreen.route){
        ListingsScreen(navController)
      }
      composable(Screen.WishlistScreen.route){
        Wishlist()
      }
      composable(Screen.TripScreen.route){
        Trip()
      }
      composable(Screen.InboxScreen.route){
        Inbox()
      }
      composable(Screen.ProfileScreen.route){
        Profile()
      }
      composable(Screen.SearchDetailScreen.route){
        SearchDetailedScreen(navController)
      }
      composable(Screen.MapScreen.route){
        MapScreen()
      }
    }
  }
  
  @Composable
  fun Wishlist(){
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
      Text(text = "Wishlist")
    }
  }
  @Composable
  fun Trip(){
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
      Text(text = "Trip")
    }
  }
  
  @Composable
  fun Inbox(){
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
      Text(text = "Inbox")
    }
  }
  
  @Composable
  fun Profile(){
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
      Text(text = "Profile")
    }
  }
  
  @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
  @OptIn(ExperimentalMaterial3Api::class)
  @Composable
  fun InitiateApp(){
    val navList= listOf(
      BottomNavItem(name = "Explore", route = "explore", icon = Icons.Default.Search),
      BottomNavItem(name = "Wishlist", route = "wishlist", icon = Icons.Default.FavoriteBorder),
      BottomNavItem(name = "Trip", route = "trip", icon = Icons.Default.LocationOn),
      BottomNavItem(name = "Inbox", route = "inbox", icon = Icons.Default.MailOutline),
      BottomNavItem(name = "Profile", route = "profile", icon = Icons.Default.AccountCircle))
    val navController= rememberNavController()
    var bottomBarState = rememberSaveable() { (mutableStateOf(true)) }
    var fabVisibility= rememberSaveable() { (mutableStateOf(false)) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute= navController.currentDestination?.route.toString()
    when (navBackStackEntry?.destination?.route) {
      "search-detail-screen" -> {
        bottomBarState.value = false
        fabVisibility.value = false
      }
      "explore" -> {
        fabVisibility.value = true
        bottomBarState.value = true
      }
      "map" ->{
        bottomBarState.value = false
        fabVisibility.value = true
      }
      else ->{
        bottomBarState.value = true
        fabVisibility.value = false
      }
    }
    Scaffold(bottomBar = {
      AppBottomNavigation(
        items = navList,
        navController = navController,
        modifier = Modifier.padding(0.dp),
        onItemClick = {
          navController.navigate(it.route)
        },
        bottomBarState = bottomBarState
        )
    },
      floatingActionButton = {
        AnimatedVisibility(
          visible = fabVisibility.value,
          enter = slideInVertically(initialOffsetY = { it }),
          exit = slideOutVertically(targetOffsetY = { it })
        ){
          ExtendedFloatingActionButton(
            onClick = {
              if(currentRoute ==="map") {
                navController.navigate(Screen.ExploreScreen.route)
              }else {
                navController.navigate(Screen.MapScreen.route)
              }
            },
            icon ={
                if(currentRoute ==="map") {
                  Icon(Icons.Outlined.Search, "Search")
                }else{
                 Icon(Icons.Outlined.Map, "Map")
                }
             },
            text = { Text(text = if (currentRoute ==="map") "Explore"  else "Map") },
            containerColor= Color.Black,
            contentColor = Color.White,
            shape = RoundedCornerShape(40.dp)
          )
        }
      },
      floatingActionButtonPosition = FabPosition.Center
    ) {
      AppNavigation(navController)
    }
  }
}


