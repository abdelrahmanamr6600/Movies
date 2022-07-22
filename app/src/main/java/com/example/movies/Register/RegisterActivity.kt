package com.example.movies.Register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.movies.Login.LoginActivity
import com.example.movies.Pojo.User
import com.example.movies.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    var pressed = false
val registerViewModel =RegisterViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.registerTvLogin.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        binding.registerBtn.setOnClickListener {
            binding.apply {
                var name = registerTvName.toString()
                var email = registerTvEmail.toString()
                var phone = registerTvPhone.toString()
                var password = registerTvPassword.toString()
                var Congpassword = registerTvConfrimPassword.toString()

                registerViewModel.Registeration(email,password, User(FirebaseAuth.getInstance().currentUser!!.uid
                ,name,email,phone,password,Congpassword))
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