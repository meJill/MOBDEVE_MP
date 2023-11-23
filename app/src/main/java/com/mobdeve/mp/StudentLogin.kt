package com.mobdeve.mp
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mobdeve.mp.fragments.bookFragment
import com.mobdeve.mp.fragments.homeFragment
private lateinit var studentSignUpButton: Button
private lateinit var studentLoginButton: Button

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

        studentLoginButton = findViewById(R.id.login)

        studentLoginButton.setOnClickListener {
            val dbHelper = MyDatabaseHelper(this)
            if (dbHelper.isUsernamePasswordMatch(findViewById<EditText>(R.id.studentUsername).text.toString(), findViewById<EditText>(R.id.studentPassword).text.toString())) {
                println("it worked")
            } else
                println("no it didnt")

        }

    }
}