package com.example.movies.Pojo.Movies

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Result(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val original_language: String? = null,
    val overview: String? = null,
    val poster_path: String,
    val title: String,
)