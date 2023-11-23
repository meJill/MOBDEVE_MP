package com.mobdeve.mp
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mobdeve.mp.Models.Job
import com.mobdeve.mp.Models.Student
import com.mobdeve.mp.fragments.bookFragment
import com.mobdeve.mp.fragments.homeFragment

class StudentSignUp : AppCompatActivity() {
    private lateinit var login: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_signup)

        login = findViewById(R.id.login2)
        login?.setOnClickListener {
            val intent = Intent(this, StudentLogin::class.java)
            // Assuming you have a Student instance

            val student = Student(
                id = 1,
                name = findViewById<EditText>(R.id.username).text.toString(),
                password = findViewById<EditText>(R.id.password).text.toString(),
                bookmarks = arrayListOf(Job(id = 1, company = "ABC Corp", name = "Software Engineer"))
            )

            // Assuming you have an instance of MyDatabaseHelper
            val dbHelper = MyDatabaseHelper(this)

            // Add the student to the database
            val newRowId = dbHelper.addStudent(student)

            // Check the result
            if (newRowId != -1L) {
                // The student was added successfully
                println("Student added with ID: $newRowId ${student.name}")
            } else {
                // There was an error
                println("Error adding student to the database")
            }

            startActivity(intent)
        }
    }
}