package com.airbnb.airbnbclone.presentation.listings_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.airbnbclone.presentation.listings_list.ListingsViewModel

@Composable
fun ListingsScreen(
  navController: NavController,
  viewModel: ListingsViewModel = hiltViewModel()
){
  val state = viewModel.state.value
  Box(modifier = Modifier.fillMaxSize()){
    LazyColumn(modifier = Modifier.fillMaxSize()){
      state.listings?.let {
        items(it.listings){listing ->
          ListingItem(listing)
        }
      }
    }
    if (state.error.isNotBlank()){
      Text(text = state.error)
    }
    if(state.isLoading){
      CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
  }
}