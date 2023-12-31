package com.mobdeve.mp
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mobdeve.mp.Models.Student

class StudentSignUp : AppCompatActivity() {
    private var x1: Float = 0.toFloat()
    private var x2: Float = 0.toFloat()
    private val MIN_DISTANCE = 150
    private lateinit var signup: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_signup)

        signup = findViewById(R.id.studentS_signup)
        signup?.setOnClickListener {
            val intent = Intent(this, StudentLogin::class.java)
            // Assuming you have a Student instance

            val student = Student(
                id = 1,
                name = findViewById<EditText>(R.id.studentS_username).text.toString(),
                password = findViewById<EditText>(R.id.studentS_password).text.toString(),
            )

            val dbHelper = MyDatabaseHelper(this)

            if (dbHelper.isStudentUsernameExists(findViewById<EditText>(R.id.studentS_username).text.toString())) {
                showToast("Please use another name")
            } else if (findViewById<EditText>(R.id.studentS_username).text.toString().isEmpty() || findViewById<EditText>(R.id.studentS_password).text.toString().isEmpty()) {
                showToast("Please fill in the blank")
            } else {
                // Add the student to the database
                val newRowId = dbHelper.addStudent(student)

                // Check the result
                if (newRowId != -1L) {
                    // The student was added successfully
                    println("Student added with ID: $newRowId")
                } else {
                    // There was an error
                    println("Error adding student to the database")
                }

                finish()
            }
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> x1 = event.x
            MotionEvent.ACTION_UP -> {
                x2 = event.x
                val deltaX = x2 - x1
                if (Math.abs(deltaX) > MIN_DISTANCE) {
                    if (x2 > x1) {
                        onBackPressed()
                    }
                }
            }
        }
        return super.onTouchEvent(event)
    }
}