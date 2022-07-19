package com.example.movies.RemoteDB.MoviesTopRated

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.Pojo.Movies.Movies
import com.example.movies.Pojo.Movies.Result
import com.example.movies.Pojo.MoviesId.MoviesID

class MoviesViewModel(application: Application) : AndroidViewModel(application) {
    private val myRepo: MoviesRepo by lazy { MoviesRepo(application) }

    fun getTopRatedMovies():MutableLiveData<List<Result>>{
        return  myRepo.getMovies()
    }


//    fun getMoviesID(movie:Int): MutableLiveData<MoviesID> {
//        return  myRepo.getMoviebyId(movie)
//    }
}