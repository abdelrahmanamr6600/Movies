package com.example.movies.FragmentsUser

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movies.Adapters.MoviesPopularAdapter
import com.example.movies.Adapters.MoviesTopRatedAdapter
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
    val movieTopRatedViewmodel = MoviesViewModel()
    val moviePopularViewmodel = MoviesPopularViewModel()

   val instance = context?.let { DB.getInstance(context = it) }
   val db = instance?.let { RepoDB(it) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        getTopRatedMovies()
        getPopularMovies()
        getIdFromTopRatedMovies()
        getIdFromPopularMovies()

        return  binding.getRoot();
    }
    fun getTopRatedMovies() {
        movieTopRatedViewmodel.getTopRatedMovies().observe(viewLifecycleOwner) {
            sentDataToRecyclerviewTopRated(it.results)
            db?.insertMovies(it.results)
        }
    }

    fun sentDataToRecyclerviewTopRated(list: List<Result>) {
//        if(list==null){
//            moviesTopRatedAdapter.setList( db.getMovies().results)
//        }
        moviesTopRatedAdapter.setList(list)
        binding.recMovies.adapter = moviesTopRatedAdapter
    }

    fun getPopularMovies() {
        moviePopularViewmodel.getPopularMovies().observe(viewLifecycleOwner) {
            sentDataToRecyclerviewPopular(it.results)
        }
    }

    fun sentDataToRecyclerviewPopular(list: List<Result>) {
        moviesPopularAdapter.setList(list)
        binding.recMoviesPopular.adapter = moviesPopularAdapter
    }

    fun getIdFromTopRatedMovies() {
        moviesTopRatedAdapter.setOnItemClick(object : MoviesTopRatedAdapter.SentDetails {

            override fun onItemClick(id: Int) {
                val intent = Intent(requireContext(), Details::class.java)
                intent.putExtra("id", id)
                startActivity(intent)
            }

        })
    }

    fun getIdFromPopularMovies() {
        moviesPopularAdapter.setOnItemClick(object : MoviesPopularAdapter.SentDetails {

            override fun onItemClick(id: Int) {
                val intent = Intent(requireContext(), Details::class.java)
                intent.putExtra("id", id)
                startActivity(intent)
            }

        })
    }

}