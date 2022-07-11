package com.example.movies.FragmentsUser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movies.Adapters.MoviesAdapter
import com.example.movies.Pojo.Result
import com.example.movies.RemoteDB.Movies.MoviesViewModel
import com.example.movies.databinding.FragmentHomeBinding

class Home : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val myAdapter by lazy { MoviesAdapter() }
    val movieViewmodel = MoviesViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        movieViewmodel.getMovies().observe(viewLifecycleOwner) {
            sentDataToRecyclerview(it.results)
        }

        return binding.getRoot();
    }

    fun sentDataToRecyclerview(list: List<Result>) {
        myAdapter.setList(list)
        binding.recMovies.adapter = myAdapter
    }
}