package com.example.movies.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.Pojo.Const
import com.example.movies.Pojo.MoviesPopular.ResultX
import com.example.movies.R
import com.example.movies.Pojo.MoviesTopRated.Result
import java.util.*

class MoviesPopularAdapter : RecyclerView.Adapter<MoviesPopularAdapter.ViewHolder>() {
    private lateinit var onItemListner: SentDetails
    var movieslist: List<ResultX> = emptyList()

    fun setList(data: List<ResultX>) {
        this.movieslist = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesPopularAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_movies_popular, parent, false)
        return ViewHolder(view,onItemListner)
    }

    override fun onBindViewHolder(holder: MoviesPopularAdapter.ViewHolder, position: Int) {
        var data: ResultX = movieslist[position]
        holder.setId(data)
    }

    override fun getItemCount(): Int {
        return movieslist.size
    }

    interface SentDetails {
        fun onItemClick(postion: Int)
    }
    fun setOnItemClick(item: SentDetails) {
        this.onItemListner = item
    }
    inner class ViewHolder(itemView: View,itemlistener:SentDetails) : RecyclerView.ViewHolder(itemView) {
        var img: ImageView = itemView.findViewById(R.id.id_moviesPopular)
        var titel: TextView = itemView.findViewById(R.id.name_of_moviesPopular)
        var rated: TextView = itemView.findViewById(R.id.rating_popular)
        var language: TextView = itemView.findViewById(R.id.typeof_movies)


                init {
                    itemView.setOnClickListener {
                        onItemListner.onItemClick(movieslist[layoutPosition].id)
                    }

                }

        fun setId(data: ResultX) {
            titel.text = data.title
            language.text = data.original_language
            Glide.with(img.context)
                .load(Const.BASE_URL_IMG + data.poster_path)
                .into(img)
            val r = Random()
            val i1 = r.nextInt(10 - 5) + 5
            rated.text="${i1}"
        }

    }
}