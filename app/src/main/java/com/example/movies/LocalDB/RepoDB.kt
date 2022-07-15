package com.example.movies.LocalDB

import com.example.movies.LocalDB.Interfaces.InterfaceRepo
import com.example.movies.Pojo.Movies.Movies

class RepoDB(private val db: DB): InterfaceRepo {
 override fun getMovies(): Movies =
     db.getDao().getMovies()

   override fun insertMovies(movies: Movies) {
    db.getDao().insertMovies(movies)
    }
}