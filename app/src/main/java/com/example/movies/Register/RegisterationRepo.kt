package com.example.movies.Register

import com.example.movies.Pojo.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class RegisterationRepo(var sentState: state) {



    fun uploded(user: User) {
        val dataRef = FirebaseDatabase.getInstance().getReference("Users")
        dataRef.child("1").setValue(user)
    }

    interface state {
        fun onSuccess()
        fun onError(error: String)

    }
}


