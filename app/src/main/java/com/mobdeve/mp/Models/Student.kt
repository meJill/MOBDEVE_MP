package com.mobdeve.mp.Models

data class Student(
    val id: Int,
    val name: String,
    val password: String,
    val bookmarks: ArrayList<Job>
)