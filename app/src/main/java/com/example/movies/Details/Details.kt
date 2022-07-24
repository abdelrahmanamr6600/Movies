package com.example.movies.Details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import com.bumptech.glide.Glide
import com.example.movies.FragmentsUser.FragmentHome
import com.example.movies.Pojo.Const
import com.example.movies.databinding.ActivityDetailsBinding
import com.example.movies.showToast

class Details : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    val moviesID = DetailsViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getMoviesByID()
        binding.watchId.setOnClickListener {
            showToast(applicationContext, "We will add this soon")
        }

        binding.backIcon.setOnClickListener {
            startActivity(Intent(applicationContext,FragmentHome::class.java))
        }
    }
// use coroutines
    fun getMoviesByID() {
        val catId = intent.getIntExtra("id", 78)
        moviesID.getMoviesID(catId).observe(this) {
            binding.apply {
                nameDetails.text = it.title
                Glide.with(baseContext).load(Const.BASE_URL_IMG + it.poster_path)
                    .into(idMovies)
                topratedMovies.text = it.release_date
                overvieMovie.text = it.overview
                overvieMovie.movementMethod=ScrollingMovementMethod()
            }
        }
    }
}