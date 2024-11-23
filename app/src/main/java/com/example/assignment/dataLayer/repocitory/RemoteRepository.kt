package com.example.assignment.dataLayer.repocitory

import com.example.assignment.dataLayer.datasource.ApiService

class RemoteRepository(
    private val  apiService: ApiService
) {
    suspend fun getHomeDetail() = apiService.getHomeScreenData()

    suspend fun getFoodDetail() = apiService.getFoodData()
}