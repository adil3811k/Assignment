package com.example.assignment.domainLayer.food

import kotlinx.serialization.Serializable

@Serializable
data class ServingSize(
    val name: String,
    val units: String,
    val value: Double
)