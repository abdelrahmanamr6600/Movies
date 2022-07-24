package com.example.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.movies.FragmentsUser.*
import com.example.movies.FragmentsUser.FavouriteMovies

import com.example.movies.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var pressed = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadFragment(FragmentHome())
        binding.bottomNav.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.home_user -> {
                    loadFragment(FragmentHome())
                    return@setOnNavigationItemReselectedListener
                }

                R.id.list_user -> {
                    loadFragment(FavouriteMovies())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.profile_customer ->{
                    loadFragment(Profile())
                    return@setOnNavigationItemReselectedListener
            }
        }
    }
    }
    fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    override fun onBackPressed() {
        if (pressed) {
            super.onBackPressed()
        } else {
            return
        }
    }

}