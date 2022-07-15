package com.example.movies.LocalDB

import androidx.room.TypeConverter
import com.example.movies.Pojo.Movies.Movies
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class Converter {
    private val gson = Gson()

    @TypeConverter
    fun stringToListPoi(data: String?): List<Movies?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object :
            TypeToken<List<Movies?>?>() {}.type

        return gson.fromJson<List<Movies?>>(data, listType)
    }

    @TypeConverter
    fun listPoiToString(list: List<Movies?>?): String? {
        return gson.toJson(list)
    }
}