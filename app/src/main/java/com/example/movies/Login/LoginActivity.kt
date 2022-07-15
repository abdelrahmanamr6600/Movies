package com.example.movies.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.movies.MainActivity
import com.example.movies.Register.RegisterActivity
import com.example.movies.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    val loginviewmodel = loginViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.loginTvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
/*
        binding.loginBtnLog.setOnClickListener {
            val email = binding.loginTvEmail.text.toString()
            val password = binding.loginTvPassword.text.toString()

            if ( email.isNotEmpty() &&password.isNotEmpty() ){
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                    if(it.isSuccessful){
                        val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        }
                    else{
                        Toast.makeText(this, it.exception.toString() , Toast.LENGTH_SHORT).show()

                        }
                    }
            }
            else{
                Toast.makeText(this,"Pleas Filed the Text", Toast.LENGTH_SHORT).show()
            }

        }

        */
        binding.loginBtnLog.setOnClickListener {
            loginUser()
        }
    }

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun loginUser() {
        binding.apply {
            var email = loginTvEmail.text
            var password = loginTvPassword.text

            loginviewmodel.logIn(email.toString(), password = password.toString())
        }
    }
}