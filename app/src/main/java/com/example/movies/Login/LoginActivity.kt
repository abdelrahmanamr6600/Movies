package com.example.movies.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.movies.MainActivity
import com.example.movies.Register.RegisterActivity
import com.example.movies.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {
    var loginviewmodel = LoginViewModel()
    private lateinit var binding: ActivityLoginBinding
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
                var email = loginTvEmail.text.toString()
                var passsword = loginTvPassword.text.toString()
                loginviewmodel.logInFirebase(email=email, password = passsword)
            }
        }
    }


}