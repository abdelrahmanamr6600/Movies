package com.example.movies.FragmentsUser

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.movies.Adapters.MoviesPopularAdapter
import com.example.movies.Adapters.MoviesTopRatedAdapter
import com.example.movies.BaseApplication
import com.example.movies.Details.Details
import com.example.movies.LocalDB.DB
import com.example.movies.LocalDB.RepoDB
import com.example.movies.Pojo.Movies.Result
import com.example.movies.R
import com.example.movies.RemoteDB.MoviesPopular.MoviesPopularViewModel
import com.example.movies.RemoteDB.MoviesTopRated.MoviesViewModel
import com.example.movies.databinding.FragmentHomeBinding
import com.example.movies.databinding.FragmentTestBinding

class Home : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val moviesTopRatedAdapter by lazy { MoviesTopRatedAdapter() }
    private val moviesPopularAdapter by lazy { MoviesPopularAdapter() }
    private var moviePopularViewmodel = MoviesPopularViewModel()
    private var movieTopRatedViewmodel = MoviesViewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentHomeBinding.inflate(inflater, container, false)

        getTopRatedMovies()
        getIdFromTopRatedMovies()
        getPopularMovies()
        getIdFromPopularMovies()
        return binding.root
    }

    private fun getTopRatedMovies() {
        movieTopRatedViewmodel.getTopRatedMovies().observe(viewLifecycleOwner) {
            sentDataToRecyclerviewTopRated(it)
        }
    }

    private fun sentDataToRecyclerviewTopRated(list: List<Result>) {
        moviesTopRatedAdapter.setList(list)
        binding.recMovies.adapter = moviesTopRatedAdapter
    }

    private fun getPopularMovies() {
        moviePopularViewmodel.getPopularMovies().observe(viewLifecycleOwner) {
            sentDataToRecyclerviewPopular(it)
        }
    }

    private fun sentDataToRecyclerviewPopular(list: List<Result>) {
        moviesPopularAdapter.setList(list)
        binding.recMoviesPopular.adapter = moviesPopularAdapter
    }

    private fun getIdFromTopRatedMovies() {
        moviesTopRatedAdapter.setOnItemClick(object : MoviesTopRatedAdapter.SentDetails {

            override fun onItemClick(id: Int) {
                val intent = Intent(requireContext(), Details::class.java)
                intent.putExtra("id", id)
                startActivity(intent)
            }

            override fun getClickedFavourite(postion: Int) {
                Log.d("Clicked", "Postion is $postion")
                BaseApplication.db?.getDao()?.insertMoviesFav(postion)
            }

        })
    }

    private fun getIdFromPopularMovies() {
        moviesPopularAdapter.setOnItemClick(object : MoviesPopularAdapter.SentDetails {

            override fun onItemClick(id: Int) {
                val intent = Intent(requireContext(), Details::class.java)
                intent.putExtra("id", id)
                startActivity(intent)
            }

        })
    }

}