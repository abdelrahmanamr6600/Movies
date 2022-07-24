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
                var name = registerTvName.text.toString()
                var email = registerTvEmail.text.toString()
                var phone = registerTvPhone.text.toString()
                var password = registerTvPassword.text.toString()
                var Confpassword = registerTvConfrimPassword.text.toString()
                val user = User("2",name,email,phone,password,Confpassword)
                registerViewModel.Registeration(user)
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this@RegisterActivity,LoginActivity::class.java)
                            startActivity(intent)
                        } else {

                        }
                    }


            }

        }

    }
    fun registerEmail(email:String ,password:String,user:User){

    }

    fun uploded(user: User){
        FirebaseDatabase.getInstance().getReference("Users").child(
            FirebaseAuth.getInstance().currentUser!!.uid
        ).setValue(user)
    }
    override fun onBackPressed() {
        if (pressed) {
            super.onBackPressed()
        } else {
            return
        }
    }
}