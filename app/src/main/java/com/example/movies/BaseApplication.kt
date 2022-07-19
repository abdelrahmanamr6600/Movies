package com.example.movies

import android.app.Application
import androidx.room.Room
import com.example.movies.LocalDB.DATABASE_NAME
import com.example.movies.LocalDB.DB

class BaseApplication : Application() {

    companion object {
        var db: DB? = null
        fun getDatabase(): DB? {
            return db
        }

    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(applicationContext,
            DB::class.java,
            DATABASE_NAME)
            .allowMainThreadQueries()
            .build()
    }
}