package com.mobdeve.mp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mobdeve.mp.Models.Job
import com.mobdeve.mp.Models.Student

private lateinit var reqs: EditText
private lateinit var CompanyAddJobButton: Button
class CompanyAdd: AppCompatActivity(){
    private var x1: Float = 0.toFloat()
    private var x2: Float = 0.toFloat()
    private val MIN_DISTANCE = 150
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_req)

        reqs = findViewById(R.id.job_text_company)
        CompanyAddJobButton = findViewById(R.id.company_add_req)
        val name = intent.getStringExtra("Company_Name")
        val dbHelper = MyDatabaseHelper(this)

        CompanyAddJobButton.setOnClickListener {
            val postedReqs = reqs.text.toString()

            // Check if both username and password fields are not empty
            if (postedReqs.isEmpty()) {
                showToast("Please enter a job")
            } else if (dbHelper.doesJobExist(postedReqs, name.toString())) {
                showToast("Job already exists!")
            } else {
                val job = Job(
                    company = name.toString(),
                    name = findViewById<EditText>(R.id.job_text_company).text.toString(),
                )
                dbHelper.addJob(job)
                val message = "Added: $postedReqs\n"
                showToast(message)
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