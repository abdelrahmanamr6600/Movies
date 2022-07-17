package com.example.movies.Register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.movies.Login.LoginActivity
import com.example.movies.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.registerTvLogin.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        binding.registerBtn.setOnClickListener {
            val name = binding.registerTvName.text.toString()
            val email = binding.registerTvEmail.text.toString()
            val number = binding.registerTvPhone.text.toString()
            val password = binding.registerTvPassword.text.toString()
            val confPassword = binding.registerTvConfrimPassword.text.toString()


            database = FirebaseDatabase.getInstance().getReference("Users")
            val User = User(name,email, number, password,confPassword)
            database.child(userName).setValue(User).addOnSuccessListener  {
                binding.registerTvName.text.clear()
                binding.registerTvEmail.text.clear()
                binding.registerTvPhone.text.clear()
                binding.registerTvPassword.text.clear()

                Toast.makeText(this,"Successfully Saved",Toast.LENGTH_SHORT).show()

            }


            if (name.isNotEmpty() && email.isNotEmpty() && number.isNotEmpty() &&
                password.isNotEmpty() && confPassword.isNotEmpty()){
                if (password == confPassword){
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                        if(it.isSuccessful){
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                        }
                        else{
                            Toast.makeText(this, it.exception.toString() , Toast.LENGTH_SHORT).show()

                        }
                    }
                }
                else{
                    Toast.makeText(this, "Password is not mach ", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this,"Pleas Filed the Text", Toast.LENGTH_SHORT).show()
            }

        }


    }
}