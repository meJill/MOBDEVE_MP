package com.mobdeve.mp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CompanyHome: AppCompatActivity(){

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_in_company)

        var dashBoardButton: Button = findViewById(R.id.company_Dashboard)
        var postinternshipButton: Button = findViewById(R.id.company_PostInternship)
        var deleteButton: Button = findViewById(R.id.company_Delete)
        val name = intent.getStringExtra("Company_Name")
        findViewById<TextView>(R.id.companyName_Edit).text = name.toString()
        val dbHelper = MyDatabaseHelper(this)

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

        deleteButton.setOnClickListener {
            dbHelper.deleteCompanyByName(name.toString())
            finish()
        }

    }

}