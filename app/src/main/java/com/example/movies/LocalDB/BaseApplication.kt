package com.example.movies.LocalDB

import android.app.Application
import androidx.room.Room

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
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
}