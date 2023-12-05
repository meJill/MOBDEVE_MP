package com.mobdeve.mp
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mobdeve.mp.fragments.bookFragment
import com.mobdeve.mp.fragments.homeFragment
private lateinit var studentSignUpButton: Button
private lateinit var studentLoginButton: Button

class StudentLogin : AppCompatActivity() {
    private var x1: Float = 0.toFloat()
    private var x2: Float = 0.toFloat()
    private val MIN_DISTANCE = 150

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

            if (dbHelper.isUsernamePasswordMatch(findViewById<EditText>(R.id.studentL_Username).text.toString(), findViewById<EditText>(R.id.studentL_Password).text.toString())) {
                println("it worked")
                val intent = Intent(this, StudentHome::class.java)
                intent.putExtra("sName", findViewById<EditText>(R.id.studentL_Username).text.toString())
                startActivity(intent)
            } else
                println("no it didnt")

        }

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