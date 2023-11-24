package com.mobdeve.mp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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
        val name = intent.getStringExtra("Company_Name")
        findViewById<TextView>(R.id.companyName_Edit).text = name.toString()

        dashBoardButton.setOnClickListener {
            val intent = Intent(this, CompanyDashboard::class.java)
            intent.putExtra("Company_Name", name)
            startActivity(intent)
        }

        postinternshipButton.setOnClickListener {
            val intent = Intent(this, CompanyAdd::class.java)
            intent.putExtra("Company_Name", name)
            startActivity(intent)
        }

    }

}