package com.example.movies.LocalDB.Interfaces

import androidx.room.*
import com.example.movies.Pojo.Movies.Movies
import com.example.movies.Pojo.Movies.Result

@Dao
interface InfoDao {
    @Insert (onConflict = OnConflictStrategy.IGNORE)
    fun insertMovies(movie: List<Result>)

    @Query("SELECT * FROM movies")
    fun getMovies(): List<Result>
    @Query("SELECT * FROM movies")
    fun getFavMovies():List<Result>

    @Delete
    fun delete(list:List<Result>)

}