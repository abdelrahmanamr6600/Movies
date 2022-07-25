package com.example.movies.Login

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.movies.MainActivity
import com.example.movies.Register.RegisterActivity

class LoginViewModel: ViewModel(),LoginRepo.state {
    var context: Context? = null
    val repo = LoginRepo(this)

    fun  logInFirebase(email:String , password : String ){
        repo.createUserandEmail(email,password)
    }

    override fun success() {
        context?.startActivity(Intent(context,MainActivity::class.java))
    }

    override fun error(name: String) {
//     Toast.makeText(context,"Erorr $name",Toast.LENGTH_SHORT).show()
    }


}