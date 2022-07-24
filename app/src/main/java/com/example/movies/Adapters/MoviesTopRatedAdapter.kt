package com.example.movies.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.Pojo.Const
import com.example.movies.Pojo.Movies.Result
import com.example.movies.R
import java.util.*

class MoviesTopRatedAdapter : RecyclerView.Adapter<MoviesTopRatedAdapter.ViewHolder>() {
    private lateinit var onItemListner: SentDetails
    var movieslist: List<Result> = emptyList()

    fun setList(data: List<Result>) {
        this.movieslist = data
        notifyDataSetChanged()
    }

    fun setOnItemClick(item: SentDetails) {
        this.onItemListner = item
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesTopRatedAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_movies, parent, false)
        return ViewHolder(view, itemlistenr = onItemListner)
    }

    override fun onBindViewHolder(holder: MoviesTopRatedAdapter.ViewHolder, position: Int) {
        var data: Result = movieslist[position]
        holder.setId(data)
    }

    override fun getItemCount(): Int {
        return movieslist.size
    }

    interface SentDetails {
        fun onItemClick(postion: Int)
        fun getClickedFavourite(postion: Int)
    }

    inner class ViewHolder(itemView: View, itemlistenr: SentDetails) :
        RecyclerView.ViewHolder(itemView) {
        var img: ImageView = itemView.findViewById(R.id.id_movies)
        var titel: TextView = itemView.findViewById(R.id.name_of_movies)
        var rated: TextView = itemView.findViewById(R.id.toprated_movies)
        var img_fav: ImageView = itemView.findViewById(R.id.imgFav)


        init {
            img.setOnClickListener {
                onItemListner.onItemClick(movieslist[layoutPosition].id)
            }

            img_fav.setOnClickListener {
                onItemListner.getClickedFavourite(movieslist[layoutPosition].id)
                img_fav.setImageResource(R.drawable.ic_heartclicked)
            }

        }

        fun setId(data: Result) {
            titel.text = data.title
            Glide.with(img.context)
                .load(Const.BASE_URL_IMG + data.poster_path)
                .into(img)
            val r = Random()
            val i1 = r.nextInt(10 - 5) + 5
            rated.text = "${i1}"
        }

    }
}