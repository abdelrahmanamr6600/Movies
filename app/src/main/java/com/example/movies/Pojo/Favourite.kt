package com.example.movies.Pojo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite")
data class Favourite(
    @PrimaryKey
    val id: Int,
    val original_language: String? = null,
    val overview: String? = null,
    val poster_path: String,
    val title: String,

    )
