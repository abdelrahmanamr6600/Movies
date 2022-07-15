package com.example.movies.LocalDB.Interfaces

import com.example.movies.Pojo.Movies.Movies

interface InterfaceRepo {

fun getMovies():Movies
fun insertMovies(movies:Movies)
}