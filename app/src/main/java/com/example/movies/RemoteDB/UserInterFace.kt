package com.example.movies.RemoteDB

import com.example.movies.Pojo.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserInterFace {
@GET("movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apikey :String ="87ff303a5be046799877856493b51a61"): Call<Movies>
}