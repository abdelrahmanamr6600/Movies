package com.example.movies.LocalDB.Interfaces

import com.example.movies.Pojo.Favourite
import com.example.movies.Pojo.Movies.Movies
import com.example.movies.Pojo.Movies.Result
import com.example.movies.Pojo.MoviesId.MoviesID

interface InterfaceRepo {

    fun getMovies(): List<Result>
     fun insertMovies(movies: List<Result>)
    fun insertMoviesFab(id:Int)
    fun getFavMovies(movies:MutableList<Favourite>)
    fun deleteMovieFavourite(id:Int)
}