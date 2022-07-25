package com.example.movies.Register

import com.example.movies.Pojo.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class RegisterationRepo(var sentState: state) {

    fun createUserWithEmailAndPassword(email: String, password: String,user:User) {
        try {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        println("success")

                     user.id=FirebaseAuth.getInstance().currentUser?.uid.toString()
                        uploadUserData(user)
                    } else {
                        println(it.exception?.message)
                        println("Error")
                    }
                }
        }catch (e : Exception){
            println(e.message ?: e.toString())
        }
    }

    private fun uploadUserData(user: User){
        val dataRef = FirebaseDatabase.getInstance().getReference("Users")

        dataRef.child(FirebaseAuth.getInstance().currentUser?.uid.toString()).setValue(user)
    }

    interface state {
        fun onSuccess()
        fun onError(error: String)

    }
}


