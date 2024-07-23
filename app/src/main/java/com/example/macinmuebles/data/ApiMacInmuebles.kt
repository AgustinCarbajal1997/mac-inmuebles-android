package com.example.macinmuebles.data

import com.example.macinmuebles.model.ResponseApi
import com.example.macinmuebles.util.Constants.Companion.POST
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiMacInmuebles {
    @POST(POST)
    suspend fun getProperties(): Response<ResponseApi>
}

