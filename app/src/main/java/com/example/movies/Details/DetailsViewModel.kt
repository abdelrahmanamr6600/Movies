package com.example.movies.Details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.Pojo.MoviesId.MoviesID
import com.example.movies.Pojo.MoviesTopRated.Movies
import com.example.movies.RemoteDB.MoviesTopRated.MoviesRepo

class DetailsViewModel : ViewModel() {
    val movieRepo = DetailsRepo()
    fun getMoviesID(movie:Int): MutableLiveData<MoviesID> {
        return  movieRepo.getMoviebyId(movie)
    }
}