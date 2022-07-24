package com.example.movies.Login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.movies.Pojo.User
import com.example.movies.Register.RegisterActivity
import com.example.movies.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class LoginActivity : AppCompatActivity() {
    var loginviewmodel = LoginViewModel()
    private lateinit var binding: ActivityLoginBinding
    var pressed = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginviewmodel = ViewModelProvider(this).get(LoginViewModel::class.java)


        binding.loginTvRegister.setOnClickListener {
            startActivity(Intent(applicationContext, RegisterActivity::class.java))
        }

        binding.loginBtnLog.setOnClickListener {
            binding.apply {
                val email = loginTvEmail.text.toString()
                val passsword = loginTvPassword.text.toString()
//                loginviewmodel.logInFirebase(email,passsword)

                createUserWithEmailAndPassword(email, passsword)
            }
        }
    }
    override fun onBackPressed() {
        if (pressed) {
            super.onBackPressed()
        } else {
            return
        }
    }

    fun createUserWithEmailAndPassword(email: String, password: String) {
        try {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        println("success")
                        val currentUserId = FirebaseAuth.getInstance().currentUser?.uid.toString()
                        uploadUserData(User(id = currentUserId, name = email, password = password))
                    } else {
                        println(it.exception?.message)
                        println("Error")
                    }
                }
        }catch (e : Exception){
            println(e.message ?: e.toString())
        }
    }

    private fun uploadUserData(user: User){
        val dataRef = FirebaseDatabase.getInstance().getReference("Users")
        dataRef.child("1").setValue(user)
    }
}