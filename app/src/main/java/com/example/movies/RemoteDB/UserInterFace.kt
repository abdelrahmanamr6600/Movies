package com.example.movies.RemoteDB

import com.example.movies.Pojo.MoviesId.MoviesID
import com.example.movies.Pojo.MoviesPopular.MoviesPopular
import com.example.movies.Pojo.MoviesTopRated.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserInterFace {
    @GET("movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apikey: String = "87ff303a5be046799877856493b51a61"): Call<Movies>


    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apikey: String = "87ff303a5be046799877856493b51a61"): Call<MoviesPopular>


@GET("movie/{movie_id}")
    fun getMovieByID(
    @Path("movie_id") movieid:Int,
    @Query("api_key") apikey: String = "87ff303a5be046799877856493b51a61"
):Call<MoviesID>

}