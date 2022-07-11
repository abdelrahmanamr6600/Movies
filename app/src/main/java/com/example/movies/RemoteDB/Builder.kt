package com.example.movies.RemoteDB

import com.example.movies.Pojo.Const
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Builder {
        val retorfitBuilder: Retrofit = Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}