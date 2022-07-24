package com.example.movies.LocalDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movies.LocalDB.Interfaces.InfoDao
import com.example.movies.Pojo.Favourite
import com.example.movies.Pojo.Movies.Movies
import com.example.movies.Pojo.Movies.Result

const val DATABASE_NAME = "movies"
@Database(entities = [Result::class,Favourite::class], version = 5, exportSchema = false)
//
abstract class DB : RoomDatabase() {

    abstract fun getDao(): InfoDao


}