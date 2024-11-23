package com.example.assignment.dataLayer.datasource

import com.example.assignment.domainLayer.food.FoodDetail
import com.example.assignment.domainLayer.home.HomeDetail
import retrofit2.http.GET

interface ApiService{

    @GET("/homepage_v2")
    suspend fun getHomeScreenData(): HomeDetail

    @GET("food_info")
    suspend fun getFoodData(): FoodDetail
}