package com.example.movies.LocalDB.Interfaces

import androidx.room.*
import com.example.movies.Pojo.Movies.Movies
import com.example.movies.Pojo.Movies.Result
import com.example.movies.Pojo.MoviesId.MoviesID

@Dao
interface InfoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovies(movie: List<Result>)

    @Insert
    fun insertMoviesFav(movies: MoviesID)

    @Query("SELECT * FROM movies")
    fun getMovies(): List<Result>

    @Query("SELECT * FROM movies WHERE ")
    fun getFavMovies(): MoviesID

    @Delete
    fun delete(list: List<Result>)


}