package com.example.movies.Register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.movies.Login.LoginActivity
import com.example.movies.Pojo.User
import com.example.movies.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    var pressed = false
    val registerViewModel = RegisterViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.registerTvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.registerBtn.setOnClickListener {
            binding.apply {
                var name = registerTvName.text.toString()
                var email = registerTvEmail.text.toString()
                var phone = registerTvPhone.text.toString()
                var password = registerTvPassword.text.toString()
                var Confpassword = registerTvConfrimPassword.text.toString()
                val currentUserId = FirebaseAuth.getInstance().currentUser?.uid.toString()
                val user = User( id = currentUserId , name, email, phone, password, Confpassword)
                registerViewModel.Registeration(email,password,user)


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
}