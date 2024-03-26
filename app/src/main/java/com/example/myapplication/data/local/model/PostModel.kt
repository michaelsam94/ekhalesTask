package com.example.myapplication.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Posts")
data class PostModel(
    val body: String,
    @PrimaryKey
    val id: Int,
    val title: String,
    val userId: Int
)
