package com.example.movies.RemoteDB.Movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.Pojo.Movies

class MoviesViewModel : ViewModel() {
    val movieRepo =MoviesRepo()
    fun getMovies():MutableLiveData<Movies>{
        return  movieRepo.getMovies()
    }
}