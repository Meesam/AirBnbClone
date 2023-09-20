package com.airbnb.airbnbclone.di

import com.airbnb.airbnbclone.common.Constants.API_BASE_URL
import com.airbnb.airbnbclone.data.remote.ListingsAndReviewApi
import com.airbnb.airbnbclone.data.repository.ListingAndReviewRepositoryImpl
import com.airbnb.airbnbclone.domain.repository.ListingAndReviewRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
  // Add Api integration with Retrofit
  
  @Singleton
  @Provides
  fun provideListingApi(): ListingsAndReviewApi {
    return Retrofit.Builder()
      .baseUrl(API_BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(ListingsAndReviewApi::class.java)
  }
  
  @Provides
  @Singleton
  fun provideListingRepository(
    listingAndReviewApi:ListingsAndReviewApi
  ):ListingAndReviewRepository{
     return ListingAndReviewRepositoryImpl(listingAndReviewApi)
  }
}