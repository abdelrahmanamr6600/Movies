package com.example.movies.Pojo.MoviesPopular

data class MoviesPopular(
    val page: Int,
    val results: List<ResultX>,
    val total_pages: Int,
    val total_results: Int
)