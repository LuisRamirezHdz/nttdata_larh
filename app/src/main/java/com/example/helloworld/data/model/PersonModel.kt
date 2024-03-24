package com.example.helloworld.data.model

data class PersonModel (
    val name: Name,
    val email: String? = null,
    val picture: Picture,
    val dob: Dob,
    )

data class Name (
    val title: String,
    val first: String,
    val last: String
)

data class Picture (
    val large: String,
    val medium: String,
    val thumbnail: String
)

data class Dob (
    val date: String,
    val age: Long
)