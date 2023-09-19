package com.airbnb.airbnbclone.data.di

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
  fun providesRetrofit(): Retrofit.Builder {
    return Retrofit.Builder().baseUrl("http://localhost:4000/")
      .addConverterFactory(GsonConverterFactory.create())
    
  }
  
  /*@Singleton
  @Provides
  fun provideEmployeeApi(builder: Retrofit.Builder): EmployeeApi {
    return builder.build().create(EmployeeApi::class.java)
  }*/
}