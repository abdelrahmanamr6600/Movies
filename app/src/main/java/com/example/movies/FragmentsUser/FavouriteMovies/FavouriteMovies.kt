package com.example.movies.FragmentsUser.FavouriteMovies

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.movies.Adapters.FavouriteAdapter
import com.example.movies.Adapters.MoviesTopRatedAdapter
import com.example.movies.BaseApplication
import com.example.movies.Pojo.Favourite
import com.example.movies.Pojo.Movies.Result
import com.example.movies.Pojo.MoviesId.MoviesID
import com.example.movies.R
import com.example.movies.RemoteDB.MoviesTopRated.MoviesViewModel
import com.example.movies.databinding.FragmentBookingBinding
import com.example.movies.databinding.FragmentFavouriteBinding
import com.example.movies.databinding.FragmentHomeBinding
import com.example.movies.databinding.ListMoviesBinding

class FavouriteMovies : Fragment() {
    private lateinit var binding: FragmentFavouriteBinding
    private val FavourtieAdapter by lazy { FavouriteAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mList = BaseApplication.db?.getDao()?.getFavMovies()
        mList?.forEach {
            Log.e(TAG, "onViewCreated: ${it.title}", )
        }
        sentDataToRecyclerviewFavourite(mList!!)
    }


    private fun sentDataToRecyclerviewFavourite(list: List<Favourite>) {
        FavourtieAdapter.setList(list)
        binding.recFavourite.adapter = FavourtieAdapter


    }

}