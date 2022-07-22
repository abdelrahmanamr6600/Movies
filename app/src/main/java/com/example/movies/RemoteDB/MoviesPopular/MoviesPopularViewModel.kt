package com.example.movies.RemoteDB.MoviesPopular

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.Pojo.Movies.Movies
import com.example.movies.Pojo.Movies.Result
import com.example.movies.RemoteDB.MoviesTopRated.MoviesRepo


class MoviesPopularViewModel :ViewModel(){
    val movieRepo :MoviesPopularRepo by lazy { MoviesPopularRepo() }
    fun getPopularMovies():MutableLiveData<List<Result>>{
        return  movieRepo.getMovies()
    }
}