package com.example.movies.LocalDB

import com.example.movies.BaseApplication
import com.example.movies.LocalDB.Interfaces.InterfaceRepo
import com.example.movies.Pojo.Favourite
import com.example.movies.Pojo.Movies.Movies
import com.example.movies.Pojo.Movies.Result
import com.example.movies.Pojo.MoviesId.MoviesID

class RepoDB(private val db: DB) : InterfaceRepo {

    override fun getMovies(): List<Result> =
        BaseApplication.db!!.getDao().getMovies()

    override fun insertMovies(movies: List<Result>) {
        BaseApplication.db!!.getDao().insertMovies(movies)
    }

    override fun insertMoviesFab(id: Int) {
        BaseApplication.db!!.getDao().insertMoviesFav(id)
    }

    override fun getFavMovies(movies: List<Favourite>) {
        BaseApplication.db!!.getDao().getFavMovies()
    }

    override fun Delete(movies: List<Result>) {
        BaseApplication.db!!.getDao().delete(movies)
    }
}