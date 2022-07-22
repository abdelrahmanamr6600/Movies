package com.example.movies.Register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.movies.Login.LoginActivity
import com.example.movies.Pojo.User
import com.example.movies.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

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
}