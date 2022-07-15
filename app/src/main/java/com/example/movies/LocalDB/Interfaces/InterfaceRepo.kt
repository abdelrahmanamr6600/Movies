package com.example.movies.LocalDB.Interfaces

import com.example.movies.Pojo.Movies.Movies
import com.example.movies.Pojo.Movies.Result

interface InterfaceRepo {

fun getMovies():List<Result>
fun insertMovies(movies:List<Result>)
fun getFavMovies(movies:List<Result>)
fun Delete(movies:List<Result>)
}