package com.example.movies.RemoteDB.MoviesPopular

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.Pojo.MoviesPopular.MoviesPopular
import com.example.movies.Pojo.MoviesTopRated.Movies

class MoviesPopularViewModel : ViewModel() {
    val movieRepo =MoviesPopularRepo()
    fun getPopularMovies():MutableLiveData<MoviesPopular>{
        return  movieRepo.getMovies()
    }
}