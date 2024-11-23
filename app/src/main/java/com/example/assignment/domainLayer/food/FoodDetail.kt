package com.example.assignment.domainLayer.food

import kotlinx.serialization.Serializable

@Serializable
data class FoodDetail(
    val `data`: Data,
    val message: String,
    val success: Boolean
)