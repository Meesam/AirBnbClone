package com.airbnb.airbnbclone.domain.use_case.get_listings

import com.airbnb.airbnbclone.common.Resource
import com.airbnb.airbnbclone.data.remote.dto.toListingsModel
import com.airbnb.airbnbclone.domain.model.ListingModel
import com.airbnb.airbnbclone.domain.model.ListingsModel
import com.airbnb.airbnbclone.domain.repository.ListingAndReviewRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetListingUseCase @Inject constructor(
  private val listingAndReviewRepository : ListingAndReviewRepository
) {
  operator fun invoke(id:String):Flow<Resource<ListingModel>> = flow {
    try {
      emit(Resource.Loading())
      var listing = listingAndReviewRepository.getListingsAndReviewById(id).toListingsModel()
      emit(Resource.Success(listing))
    }
    catch (e:HttpException){
      emit(Resource.Error(e.localizedMessage ?:"An error occurred"))
    }
    catch (e:IOException){
      emit(Resource.Error(e.localizedMessage ?:"Couldn't reach to server, check your internet"))
    }
  }
  
}