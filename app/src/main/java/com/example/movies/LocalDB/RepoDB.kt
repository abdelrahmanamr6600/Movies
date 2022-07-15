package com.example.movies.LocalDB

import com.example.movies.LocalDB.Interfaces.InterfaceRepo
import com.example.movies.Pojo.Movies.Movies
import com.example.movies.Pojo.Movies.Result

class RepoDB(private val db: DB): InterfaceRepo {
 override fun getMovies(): List<Result> =
     db.getDao().getMovies()

   override fun insertMovies(movies: List<Result>) {
    db.getDao().insertMovies(movies)
    }

    override fun getFavMovies(movies: List<Result>) {
        db.getDao().getFavMovies()
    }

    override fun Delete(movies: List<Result>) {
        db.getDao().delete(movies)
    }
}