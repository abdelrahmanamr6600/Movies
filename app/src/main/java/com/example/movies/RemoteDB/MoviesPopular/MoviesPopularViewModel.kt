package com.example.movies.RemoteDB.MoviesPopular

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.Pojo.Movies.Movies


class MoviesPopularViewModel : ViewModel() {
    val movieRepo =MoviesPopularRepo()
    fun getPopularMovies():MutableLiveData<Movies>{
        return  movieRepo.getMovies()
    }
}