package com.example.movies.FragmentsUser

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.movies.Adapters.FavouriteAdapter
import com.example.movies.LocalDB.BaseApplication
import com.example.movies.Pojo.Favourite
import com.example.movies.databinding.FragmentFavouriteBinding
import com.example.movies.showToast


class FavouriteMovies : Fragment() {
    private lateinit var binding: FragmentFavouriteBinding
    private val favourtieAdapter by lazy { FavouriteAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


/*
        mList?.forEach {
           if(it==null){
               binding.secondCart.visibility=View.VISIBLE
               binding.recFavourite.visibility = View.GONE
           }else{
               binding.recFavourite.visibility = View.VISIBLE
           }
        }
*/
            BaseApplication.db?.getDao()?.getFavMovies()
                ?.let { sentDataToRecyclerviewFavourite(it) }
        deleteMovie()
    }


    private fun sentDataToRecyclerviewFavourite(list:MutableList<Favourite>) {
        favourtieAdapter.setList(list)
        binding.recFavourite.adapter =favourtieAdapter
    }
    private fun deleteMovie() {
        favourtieAdapter.setOnItemClick(object : FavouriteAdapter.SentDetails {
            override fun onItemClick(id: Int, postion: Int) {
                Log.d("Delete",postion.toString())
                BaseApplication.db?.getDao()?.deleteMovieFavourite(id)
                favourtieAdapter.deleteItem(postion)
                showToast(requireContext(),"Movie removed")
            }

        })
    }


}