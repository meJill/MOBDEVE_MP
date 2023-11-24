package com.mobdeve.mp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var data: ArrayList<PostModel>
    private lateinit var myAdapter: MyAdapter
    private lateinit var homeButton: Button
    private lateinit var studentButton: Button
    private lateinit var companyButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Initialize the data, recyclerView, and adapter
        this.data = DataHelper.initializeData()

        this.myAdapter = MyAdapter(this.data)

        homeButton = findViewById(R.id.home)
        homeButton?.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

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
