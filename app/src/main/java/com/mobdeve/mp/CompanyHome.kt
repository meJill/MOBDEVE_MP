package com.mobdeve.mp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CompanyHome: AppCompatActivity(){

    var id = -1
    var name: String? = null
    val dbHelper = MyDatabaseHelper(this)

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_in_company)

        val dashBoardButton: Button = findViewById(R.id.company_Dashboard)
        val postinternshipButton: Button = findViewById(R.id.company_PostInternship)
        val deleteButton: Button = findViewById(R.id.company_Delete)
        val editButton: Button = findViewById(R.id.company_Edit)
        println("It got created")
        id = intent.getIntExtra("Company_Id", -1)
        println(id)
        val company = dbHelper.getCompanyById(id)
        name = company?.name.toString()
        findViewById<TextView>(R.id.companyName_Edit).text = name

        editButton.setOnClickListener {
            val intent = Intent(this, CompanyEdit::class.java)
            intent.putExtra("Company_Id", id)
            startActivity(intent)

        }

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
            dbHelper.deleteCompanyById(id)
            finish()
        }

    }

    override fun onResume() {
        super.onResume()
        name = dbHelper.getCompanyById(id)?.name.toString()
        findViewById<TextView>(R.id.companyName_Edit).text = name

    }

}