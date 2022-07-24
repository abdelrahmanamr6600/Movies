package com.example.movies.Login

import android.content.Intent
import android.widget.Toast
import com.example.movies.MainActivity
import com.example.movies.showToast
import com.google.firebase.auth.FirebaseAuth

class LoginRepo(var sentState: state) {
/*
    fun logIn(email: String, password: String) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
        .addOnCompleteListener {
            if (it.isSuccessful) {
               sentState.success()
            }else{
                sentState.error(it.exception.toString())
            }
        }

    }
    */

    fun createUserandEmail(email: String, password: String) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    sentState.success()
                } else {
                    sentState.error(it.exception.toString())
                }
            }
    }

    interface state {
        fun success()
        fun error(name: String)
    }


}