package com.example.assignment.domainLayer.food

import kotlinx.serialization.Serializable

@Serializable
data class Ingredient(
    val ingid: String,
    val name: String,
    val value: Double
)