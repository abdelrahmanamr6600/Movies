package com.example.movies.Login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.movies.Register.RegisterActivity
import com.example.movies.databinding.ActivityLoginBinding


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
                var email = loginTvEmail.text.toString()
                var passsword = loginTvPassword.text.toString()
                loginviewmodel.logInFirebase(email=email, password = passsword)
            }
        }
    }
//    override fun onBackPressed() {
//        if (pressed) {
//            super.onBackPressed()
//        } else {
//            return
//        }
//    }
}