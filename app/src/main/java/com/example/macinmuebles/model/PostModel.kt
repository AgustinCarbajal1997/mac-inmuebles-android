package com.example.macinmuebles.model

data class PostModel(
    val id: String = "",
    val title: String = "",
    val imageFront: List<String> = emptyList(),
    val locality: String = "",
    val neighborhood: String = "",
    val sanitizedHtml: String = "",
    val price: String = "",
    val bedrooms: Int = 0,
    val bathrooms: Int = 0,
    val garage: Boolean = false,
    val balcony: Boolean = false,
    val pool: Boolean = false,
    val barbecue: Boolean = false,
    val privateNeighborhood: Boolean = false,
    val backyard: Boolean = false,
    val grill: Boolean = false,
    val barter: Boolean = false,
    val alarm: Boolean = false,
    val sum: Boolean = false,
    val elevator: Boolean = false,
    val laundry: Boolean = false,
    val credit: Boolean = false,
    val measures: Double = 0.0,
    val services: Boolean = false
)


data class ResponseApi(
    val success: String = "",
    val message: String = "",
    val data: List<PostModel>
)
