package com.mobdeve.mp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private lateinit var dashBoardButton: Button
class CompanyAdd: AppCompatActivity(){

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_in_company)

        val name = intent.getStringExtra("Company_Name")
        findViewById<TextView>(R.id.companyName_Edit).text = name

        dashBoardButton = findViewById(R.id.company_Dashboard)

        dashBoardButton.setOnClickListener {
            val intent = Intent(this, CompanyDashboard::class.java)
            startActivity(intent)
        }

    }


}