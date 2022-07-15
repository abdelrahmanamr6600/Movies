package com.example.movies.LocalDB

import androidx.room.TypeConverter
import com.example.movies.Pojo.Movies.Movies
import com.example.movies.Pojo.Movies.Result
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class Converter {
    private val gson = Gson()

    @TypeConverter
    fun stringToListPoi(data: String?): List<Result?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object :
            TypeToken<List<Result?>?>() {}.type

        return gson.fromJson<List<Result?>>(data, listType)
    }

    @TypeConverter
    fun listPoiToString(list: List<Result?>?): String? {
        return gson.toJson(list)
    }
}