package com.mobdeve.mp

import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CompanyJobEdit : AppCompatActivity() {
    private var x1: Float = 0.toFloat()
    private var x2: Float = 0.toFloat()
    private val MIN_DISTANCE = 150

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_job_edit)

        val saveButton: Button = findViewById(R.id.company_jobE_save)
        val cancelButton: Button = findViewById(R.id.company_jobE_cancel)
        val Og_name = intent.getStringExtra("Og_Name").toString()
        findViewById<EditText>(R.id.jobE_text_company).setText(Og_name)
        val c_name = intent.getStringExtra("Company_Name").toString()
        val dbHelper = MyDatabaseHelper(this)


        saveButton.setOnClickListener {
            if (findViewById<EditText>(R.id.jobE_text_company).text.toString().isEmpty()) {
                showToast("Please do not leave the field blank")
            } else if (dbHelper.doesJobExist(findViewById<EditText>(R.id.jobE_text_company).text.toString(), c_name)) {
                showToast("Job already exists!")
            } else {
                val dbHelper = MyDatabaseHelper(this)
                dbHelper.editJob(Og_name, c_name, findViewById<EditText>(R.id.jobE_text_company).text.toString())
                finish()
            }
        }

        cancelButton.setOnClickListener {
            finish()
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