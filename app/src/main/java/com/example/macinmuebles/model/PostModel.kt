package com.example.macinmuebles.model

data class PostModel(
    val id: String = "",
    val title: String = "",
    val imageFront: List<String> = emptyList(),
    val locality: String = "",
    val price: String = ""
)

data class ResponseApi(
    val success: String = "",
    val message: String = "",
    val data: List<PostModel>
)
