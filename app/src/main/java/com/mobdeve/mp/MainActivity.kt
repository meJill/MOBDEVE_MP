package com.mobdeve.mp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

//    private lateinit var data: ArrayList<StudentPostModel>
//    private lateinit var myAdapter: StudentAdapter
//    private lateinit var homeButton: Button
    private lateinit var studentButton: Button
    private lateinit var companyButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        studentButton = findViewById(R.id.student)
        studentButton?.setOnClickListener {
            val intent = Intent(this, StudentLogin::class.java)
            startActivity(intent)
        }

        companyButton = findViewById(R.id.company)
        companyButton?.setOnClickListener {
            val intent = Intent(this, CompanyLogin::class.java)
            startActivity(intent)
        }
    }
}
