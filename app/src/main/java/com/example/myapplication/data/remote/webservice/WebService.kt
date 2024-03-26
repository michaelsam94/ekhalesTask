package com.example.myapplication.data.remote.webservice

import com.example.myapplication.data.remote.dto.Post
import retrofit2.Response
import retrofit2.http.GET

interface WebService {
    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>
}
