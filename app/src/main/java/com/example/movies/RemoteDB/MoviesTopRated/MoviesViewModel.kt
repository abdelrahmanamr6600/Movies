package com.example.movies.RemoteDB.MoviesTopRated

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.Pojo.Movies.Movies

class MoviesViewModel : ViewModel() {
    val movieRepo =MoviesRepo()
    fun getTopRatedMovies():MutableLiveData<Movies>{
        return  movieRepo.getMovies()
    }
}