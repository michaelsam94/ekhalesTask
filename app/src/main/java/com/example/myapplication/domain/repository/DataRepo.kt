package com.example.myapplication.domain.repository

import com.example.myapplication.data.remote.dto.Post
import com.example.myapplication.util.Resource

interface DataRepo {
    suspend fun getPosts(): Resource<List<Post>>
}
