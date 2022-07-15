package com.example.movies.Details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.Pojo.MoviesId.MoviesID

class DetailsViewModel : ViewModel() {
    val movieRepo = DetailsRepo()
    fun getMoviesID(movie:Int): MutableLiveData<MoviesID> {
        return  movieRepo.getMoviebyId(movie)
    }
}