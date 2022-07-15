package com.example.movies.LocalDB

import com.example.movies.LocalDB.Interfaces.InterfaceRepo
import com.example.movies.Pojo.Movies.Movies
import com.example.movies.Pojo.Movies.Result

class RepoDB(private val db: DB): InterfaceRepo {
 override fun getMovies(): Result =
     db.getDao().getMovies()

   override fun insertMovies(movies: Result) {
    db.getDao().insertMovies(movies)
    }
}