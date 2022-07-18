package com.example.movies.RemoteDB.MoviesTopRated

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.movies.LocalDB.DB
import com.example.movies.LocalDB.RepoDB

import com.example.movies.Pojo.Movies.Movies
import com.example.movies.Pojo.MoviesId.MoviesID
import com.example.movies.RemoteDB.Builder
import com.example.movies.RemoteDB.UserInterFace
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesRepo {
//    val instance = context?.let { DB.getInstance(context = it) }
//    val db = instance?.let { RepoDB(it) }

    fun getMovies(): MutableLiveData<Movies> {
        var mutableLiveData = MutableLiveData<Movies>()
        var userInterfacebuilder = Builder.retorfitBuilder.create(UserInterFace::class.java)
        var call = userInterfacebuilder.getTopRatedMovies()
        call.enqueue(object : Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if (response.isSuccessful) {
                    mutableLiveData.postValue(response.body())

                }
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.d("Error", t.message.toString())

            }
        })
        return mutableLiveData
    }

    fun getMoviebyId(movie: Int): MutableLiveData<MoviesID> {
        var mutable = MutableLiveData<MoviesID>()
        val interBuilder: UserInterFace = Builder.retorfitBuilder.create(UserInterFace::class.java)
        val call = interBuilder.getMovieByID(movie)
        call.enqueue(object : Callback<MoviesID> {
            override fun onResponse(call: Call<MoviesID>, response: Response<MoviesID>) {
                if (response.isSuccessful)
                    mutable.postValue(response.body())
            }

            override fun onFailure(call: Call<MoviesID>, t: Throwable) {
                Log.d("Error", t.message.toString())
            }

        })
        return mutable
    }
}