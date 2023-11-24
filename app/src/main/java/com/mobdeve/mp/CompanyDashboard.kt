package com.mobdeve.mp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CompanyDashboard: AppCompatActivity(){

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter
    private val data: ArrayList<PostModel>  = DataHelper.initializeData()


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_dashboard)

        recyclerView = findViewById(R.id.dashboard_RV)
        recyclerView.layoutManager = LinearLayoutManager(this) // Use 'this' for the context
        adapter = MyAdapter(this.data)
        recyclerView.adapter = adapter

    }


}