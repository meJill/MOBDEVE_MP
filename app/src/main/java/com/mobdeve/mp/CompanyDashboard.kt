package com.mobdeve.mp


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CompanyDashboard: AppCompatActivity(){

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CompanyAdapter
    private val data: ArrayList<CompanyPostModel> = CompanyDataHelper.initializeData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_dashboard)

        recyclerView = findViewById(R.id.dashboard_RV)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CompanyAdapter(this.data) // Initialize your adapter here and pass your data if needed
        recyclerView.adapter = adapter
    }

}