package com.mobdeve.mp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

private lateinit var dashBoardButton: Button
private lateinit var postinternshipButton: Button
class CompanyHome: AppCompatActivity(){

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_in_company)

        dashBoardButton = findViewById(R.id.company_Dashboard)
        postinternshipButton = findViewById(R.id.company_PostInternship)

        dashBoardButton.setOnClickListener {
            val intent = Intent(this, CompanyDashboard::class.java)
            startActivity(intent)
        }

        postinternshipButton.setOnClickListener {
            val intent = Intent(this, CompanyAdd::class.java)
            startActivity(intent)
        }

    }

}