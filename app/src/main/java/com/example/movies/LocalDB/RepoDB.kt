package com.example.movies.LocalDB

import com.example.movies.LocalDB.Interfaces.IRepo
import com.example.movies.Pojo.Favourite
import com.example.movies.Pojo.Movies.Result

class RepoDB(private val db: DB) : IRepo {

    override fun getMovies(): List<Result> =
        BaseApplication.db!!.getDao().getMovies()

    override fun insertMovies(movies: List<Result>) {
        BaseApplication.db!!.getDao().insertMovies(movies)
    }

    override fun insertMoviesFab(id: Int) {
        BaseApplication.db!!.getDao().insertMoviesFav(id)
    }

    override fun getFavMovies(movies: MutableList<Favourite>) {
        BaseApplication.db!!.getDao().getFavMovies()
    }

    override fun deleteMovieFavourite(id:Int) {
        BaseApplication.db!!.getDao().deleteMovieFavourite(id)
    }
}