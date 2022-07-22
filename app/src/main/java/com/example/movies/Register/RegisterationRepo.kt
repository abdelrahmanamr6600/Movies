package com.example.movies.Register

import com.example.movies.Pojo.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class RegisterationRepo(var sentState:state) {

    fun registerEmail(email:String ,password:String){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->

            }
    }

    fun uploded(user: User){
        FirebaseDatabase.getInstance().getReference("Users").child(
            FirebaseAuth.getInstance().currentUser!!.uid
        ).setValue(user).addOnCompleteListener {
         if(it.isSuccessful){


         }
        }
    }

interface state{
    fun onSuccess()
    fun onError(error:String)

}
}


