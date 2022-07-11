package com.example.movies.RemoteDB.MoviesPopular

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.movies.Pojo.MoviesPopular.MoviesPopular
import com.example.movies.Pojo.MoviesTopRated.Movies
import com.example.movies.RemoteDB.Builder
import com.example.movies.RemoteDB.UserInterFace
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesPopularRepo {

    fun getMovies(): MutableLiveData<MoviesPopular> {
        var mutableLiveData = MutableLiveData<MoviesPopular>()
        var userInterfacebuilder = Builder.retorfitBuilder.create(UserInterFace::class.java)
        var call = userInterfacebuilder.getPopularMovies()
        call.enqueue(object : Callback<MoviesPopular> {
            override fun onResponse(call: Call<MoviesPopular>, response: Response<MoviesPopular>) {
                if (response.isSuccessful) {
                    mutableLiveData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<MoviesPopular>, t: Throwable) {
                Log.d("Error", t.message.toString())

            }
        })
        return mutableLiveData
    }
}