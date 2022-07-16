package com.example.movies.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.Pojo.Const

import com.example.movies.R
import com.example.movies.Pojo.Movies.Result
import com.example.movies.Pojo.MoviesId.MoviesID
import java.util.*

class FavouriteAdapter : RecyclerView.Adapter<FavouriteAdapter.ViewHolder>() {

    var movieslist: List<MoviesID> = emptyList()

    fun setList(data: List<MoviesID>) {
        this.movieslist = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavouriteAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_favoruite, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavouriteAdapter.ViewHolder, position: Int) {
        var data: MoviesID= movieslist[position]
        holder.setId(data)
    }

    override fun getItemCount(): Int {
        return movieslist.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img: ImageView = itemView.findViewById(R.id.id_moviesPopular)
        var titel: TextView = itemView.findViewById(R.id.name_of_moviesPopular)
        var rated: TextView = itemView.findViewById(R.id.rating_popular)
        var language: TextView = itemView.findViewById(R.id.typeof_movies)

        fun setId(data: MoviesID) {

        }

    }
}