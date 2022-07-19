package com.example.movies.Pojo.Movies

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class Result(
//    val adult: Boolean? = null,
//    val backdrop_path: String? = null,
//    val genre_ids: List<Int>? = null,
    @PrimaryKey
    val id: Int,
    val original_language: String? = null,
//    val original_title: String,
  val overview: String? = null,
//    val popularity: Double? = null,
    val poster_path: String,
//    val release_date: String? = null,
    val title: String,
//    val video: Boolean?=null,
//    val vote_average: Double?=null,
//    val vote_count: Int?=null
)