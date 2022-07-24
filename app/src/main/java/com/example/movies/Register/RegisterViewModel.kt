package com.example.movies.Register

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import com.example.movies.Login.LoginActivity
import com.example.movies.MainActivity
import com.example.movies.Pojo.User

class RegisterViewModel: ViewModel(),RegisterationRepo.state {
    var context: Context? = null
    val repo = RegisterationRepo(this)

    fun  Registeration(user: User){
       repo.uploded(user)


    }

    override fun onSuccess() {
        context?.startActivity(Intent(context,LoginActivity::class.java))
    }

    override fun onError(error: String) {
        TODO("Not yet implemented")
    }


}