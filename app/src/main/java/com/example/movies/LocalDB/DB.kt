package com.example.movies.LocalDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movies.LocalDB.Interfaces.InfoDao
import com.example.movies.Pojo.Movies.Movies
import com.example.movies.Pojo.Movies.Result

const val DATABASE_NAME = "movies"
@Database(entities = [Result::class], version = 2, exportSchema = false)

abstract class DB : RoomDatabase() {

    abstract fun getDao(): InfoDao

    companion object{
        @Volatile
        private var instance :DB?=null

        fun getInstance(context: Context):DB{
            return instance?: synchronized(Any()){
                instance?:buildDatabase(context).also{instance =it}
            }
        }

        private fun buildDatabase(context: Context): DB {
            return Room.databaseBuilder(context,DB::class.java, DATABASE_NAME).
            allowMainThreadQueries().
            fallbackToDestructiveMigration()
                .build()
        }
    }


}