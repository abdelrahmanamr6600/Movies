package com.example.movies.RemoteDB.MoviesTopRated

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.Pojo.Movies.Movies
import com.example.movies.Pojo.MoviesId.MoviesID

class MoviesViewModel : ViewModel() {
    val movieRepo =MoviesRepo()
    fun getTopRatedMovies():MutableLiveData<Movies>{
        return  movieRepo.getMovies()
    }


    fun getMoviesID(movie:Int): MutableLiveData<MoviesID> {
        return  movieRepo.getMoviebyId(movie)
    }
}