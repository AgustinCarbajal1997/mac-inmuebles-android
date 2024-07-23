package com.example.macinmuebles.repository

import com.example.macinmuebles.data.ApiMacInmuebles
import com.example.macinmuebles.model.ResponseApi
import javax.inject.Inject

class PostRepository @Inject constructor(private val apiMacInmuebles: ApiMacInmuebles) {
    suspend fun getProperties(): ResponseApi ? {
        val response = apiMacInmuebles.getProperties()
        if(response.isSuccessful){
            return response.body()
        }
        return null
    }
}