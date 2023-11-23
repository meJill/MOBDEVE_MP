package com.mobdeve.mp
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mobdeve.mp.fragments.bookFragment
import com.mobdeve.mp.fragments.homeFragment
private lateinit var studentSignUpButton: Button

class StudentLogin : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_login)

        studentSignUpButton = findViewById(R.id.student_signup)
//
        studentSignUpButton.setOnClickListener {
            val intent = Intent(this, StudentSignUp::class.java)
            startActivity(intent)
        }
    }
}