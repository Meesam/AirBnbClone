package com.airbnb.airbnbclone.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.airbnb.airbnbclone.presentation.listings_list.components.ListingItem1
import com.airbnb.airbnbclone.presentation.listings_list.components.ListingsScreen
import com.airbnb.airbnbclone.presentation.listings_list.components.SearchDetailedScreen
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
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    when (navBackStackEntry?.destination?.route) {
      "search-detail-screen" -> {
        bottomBarState.value = false
      }
      else ->
        bottomBarState.value = true
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
    ) {
      AppNavigation(navController)
    }
  }
}


