package com.example.assignment.domainLayer.food

import kotlinx.serialization.Serializable

@Serializable
data class SimilarItem(
    val _id: String,
    val image: String,
    val name: String
)