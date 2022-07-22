package com.example.movies.RemoteDB.MoviesPopular

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.movies.BaseApplication
import com.example.movies.LocalDB.DB
import com.example.movies.LocalDB.RepoDB

import com.example.movies.Pojo.Movies.Movies
import com.example.movies.Pojo.Movies.Result
import com.example.movies.RemoteDB.Builder
import com.example.movies.RemoteDB.UserInterFace
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesPopularRepo {
//    val instance = context?.let { DB.getInstance(context = it) }
//    val db = instance?.let { RepoDB(it) }

// use coroutines
    fun getMovies(): MutableLiveData<List<Result>> {
        var mutableLiveData = MutableLiveData<List<Result>>()
        var userInterfacebuilder = Builder.retorfitBuilder.create(UserInterFace::class.java)
        var call = userInterfacebuilder.getPopularMovies()
        call.enqueue(object : Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if (response.isSuccessful) {
                    mutableLiveData.postValue(response.body()!!.results)
                    BaseApplication.db!!.getDao().insertMovies(response.body()!!.results)
                }
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.d("Error", t.message.toString())
              mutableLiveData.postValue(BaseApplication.db!!.getDao().getMovies())
            }
        })
        return mutableLiveData
    }


}