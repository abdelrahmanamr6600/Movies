package com.example.movies.Pojo

data class User(
    val id: String = "",
    val name: String = "",
    val email: String = "".lowercase(),
    val number: String = "",
    val password: String = "",
    val confpassword: String = "",
)


