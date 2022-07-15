package com.example.movies.LocalDB.Interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movies.Pojo.Movies.Movies

@Dao
interface InfoDao {
    @Insert (onConflict = OnConflictStrategy.IGNORE)
    fun insertMovies(movie: Movies)

    @Query("SELECT * FROM movies")
    fun getMovies(): Movies



}