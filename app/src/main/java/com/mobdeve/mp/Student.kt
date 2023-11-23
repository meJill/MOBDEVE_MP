package com.mobdeve.mp

data class Student(
    val id: Int,
    val name: String,
    val password: String,
    val bookmarks: ArrayList<Job>
)