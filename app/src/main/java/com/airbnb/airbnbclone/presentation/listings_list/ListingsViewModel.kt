package com.airbnb.airbnbclone.presentation.listings_list

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.airbnb.airbnbclone.common.Resource
import com.airbnb.airbnbclone.domain.use_case.get_listings.GetListingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ListingsViewModel @Inject constructor(
   private val getListingsUseCase: GetListingsUseCase
) : ViewModel(){
  
   private val _state = mutableStateOf(ListingsState())
   val state :State<ListingsState> = _state
   
   init {
      getListings()
   }
   
   private fun getListings(){
      getListingsUseCase().onEach {result ->
         when(result){
            is Resource.Loading -> {
               _state.value = ListingsState(isLoading = true)
            }
            is Resource.Success -> {
               _state.value = ListingsState(listings = result.data ?: null)
            }
            is Resource.Error -> {
               Log.d("Resource.Error",result.message.toString())
            }
         }
      }.launchIn(viewModelScope)
   }
}